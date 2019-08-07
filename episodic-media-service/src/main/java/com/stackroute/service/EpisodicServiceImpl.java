package com.stackroute.service;

import com.stackroute.domain.Episode;
import com.stackroute.domain.EpisodicMedia;
import com.stackroute.exception.*;
import com.stackroute.repository.EpisodicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "media")
@Service
public class EpisodicServiceImpl implements EpisodicService {

    @Autowired
    private EpisodicRepository episodicMediaRepository;

    @Autowired
    KafkaTemplate<EpisodicMedia, EpisodicMedia> kafkaTemplate1;

    @Autowired
    KafkaTemplate<Episode, Episode> kafkaTemplate2;

    private static String topic1 = "saveEpisodicMedia";
    private static String topic2 = "saveEpisode";

    private String mediaNotFound="Media not found";
    private String mediaAlreadyExist="Media already exists";
    private String fail="Fail";

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //saving episodic media by sending episodic media object
    @CacheEvict(allEntries = true)
    @Override
    public EpisodicMedia saveEpisodicMedia(EpisodicMedia serial) throws EpisodicMediaAlreadyExistsException {
        EpisodicMedia media;

        if (episodicMediaRepository.existsById(serial.getEpisodicTitle())) {
            throw new EpisodicMediaAlreadyExistsException(mediaAlreadyExist);
        } else {
            System.out.println("=================="+"kafka");
            System.out.println("+++++++++++++++++serial is++++++++++++++++++++++++"+serial.toString());
            kafkaTemplate1.send(topic1, serial);
            media = episodicMediaRepository.save(serial);
        }
        return media;
    }

    //displaying all episodic media
    @Cacheable
    @Override
    public List<EpisodicMedia> getAllEpisodicMedias() throws NoEpisodicMediaExistException {
        List<EpisodicMedia> episodicMediaList = episodicMediaRepository.findAll();
        if (episodicMediaList == null) {
            throw new NoEpisodicMediaExistException("No media available");
        } else return episodicMediaList;
    }

    //seraching episodic media by episodicTitle
    @Cacheable
    @Override
    public EpisodicMedia getEpisodicMediaByTitle(String episodicTitle) throws EpisodicMediaNotFoundException {
        EpisodicMedia media;
        if (episodicMediaRepository.existsById(episodicTitle)) {
            media = episodicMediaRepository.findById(episodicTitle).get();
            return media;
        } else throw new EpisodicMediaNotFoundException(mediaNotFound);
    }

    //deleting episodic media by serialTitle
    @CacheEvict(allEntries = true)
    @Override
    public EpisodicMedia deleteEpisodicMedia(String serialTitle) throws EpisodicMediaNotFoundException {
        EpisodicMedia media;
        if (episodicMediaRepository.existsById(serialTitle)) {
            media = episodicMediaRepository.findById(serialTitle).get();
            episodicMediaRepository.deleteById(serialTitle);
            return media;
        } else throw new EpisodicMediaNotFoundException(mediaNotFound);
    }

    //seraching episodic media by category
    @Cacheable
    @Override
    public List<EpisodicMedia> getEpisodicMediaByCategory(String category) throws EpisodicMediaNotFoundException {
        List<EpisodicMedia> allSerials = episodicMediaRepository.findAll();
        if (allSerials == null) {
            throw new EpisodicMediaNotFoundException(mediaNotFound);
        } else {
            List<EpisodicMedia> catSerials = new ArrayList<>();
            for (EpisodicMedia serial : allSerials) {
                if (serial.getEpisodicCategory().equals(category)) {
                    catSerials.add(serial);
                }
            }
            if (catSerials == null) {
                throw new EpisodicMediaNotFoundException(mediaNotFound);
            } else return catSerials;
        }
    }

    //searching episodic media by language
    @Cacheable
    @Override
    public List<EpisodicMedia> getEpisodicByLanguage(String language) throws EpisodicMediaNotFoundException {
        List<EpisodicMedia> allSerials = episodicMediaRepository.findAll();
        if (allSerials == null) {
            throw new EpisodicMediaNotFoundException(mediaNotFound);
        } else {
            List<EpisodicMedia> lanSerials = new ArrayList<>();
            for (EpisodicMedia serial : allSerials) {
                if (serial.getEpisodicCategory().equals("TV Episodes")) {
                    if (serial.getEpisodicLanguage().equals(language)) {
                        lanSerials.add(serial);
                    }
                }
            }
            if (lanSerials == null) {
                throw new EpisodicMediaNotFoundException(mediaNotFound);
            } else return lanSerials;
        }
    }

    //adding episode to episodic media
    @CacheEvict(allEntries = true)
    @Override
    public Episode addEpisode(String serialTitle, Episode episode) throws EpisodicMediaNotFoundException, EpisodeAlreadyExistsException {
        if (episodicMediaRepository.existsById(serialTitle)) {
            EpisodicMedia media = episodicMediaRepository.findById(serialTitle).get();
            List<Episode> episodes = media.getEpisodeList();
            for (Episode i : episodes) {
                if (i.getEpisodeNo() == episode.getEpisodeNo()) {
                    throw new EpisodeAlreadyExistsException("Episode already exists");
                }
            }
            episodes.add(episode);
            media.setEpisodeList(episodes);
            episodicMediaRepository.save(media);
            System.out.println("episode deatils"+episode);
            kafkaTemplate2.send(topic2, episode);
            return episode;
        } else throw new EpisodicMediaNotFoundException(mediaNotFound);
    }

    //deleting episode from episodic media by serialTitle and episodeNumber
    @CacheEvict(allEntries = true)
    @Override
    public Episode deleteEpisode(String serialTitle, int episodeNumber) throws EpisodicMediaNotFoundException, EpisodeNotFoundException {
        if (episodicMediaRepository.existsById(serialTitle)) {
            EpisodicMedia media = episodicMediaRepository.findById(serialTitle).get();
            List<Episode> episodes = media.getEpisodeList();
            int flag = 0;
            Episode episode = new Episode();
            for (Episode i : episodes) {
                if (i.getEpisodeNo() == episodeNumber) {
                    episode = i;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                throw new EpisodeNotFoundException("episode not found");
            } else {
                episodes.remove(episode);
                media.setEpisodeList(episodes);
                episodicMediaRepository.save(media);
                return episode;
            }
        } else throw new EpisodicMediaNotFoundException(mediaNotFound);
    }

    //searching episode by serialTitle and episodeNumber
    @Cacheable
    @Override
    public Episode getEpisodeByNumber(String serialTitle, int episodeNumber) throws EpisodicMediaNotFoundException, EpisodeNotFoundException {
        if (episodicMediaRepository.existsById(serialTitle)) {
            EpisodicMedia media = episodicMediaRepository.findById(serialTitle).get();
            List<Episode> episodes = media.getEpisodeList();

            Episode episode = new Episode();
            int flag = 0;
            for (Episode i : episodes) {
                if (i.getEpisodeNo() == episodeNumber) {
                    episode = i;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                throw new EpisodeNotFoundException("episode not found");
            } else return episode;
        } else throw new EpisodicMediaNotFoundException(mediaNotFound);
    }

    //get all episodes
    @Cacheable
    @Override
    public List<Episode> getAllEpisodes(String serialTitle) throws EpisodicMediaNotFoundException, NoEpisodeExistException {
        if (episodicMediaRepository.existsById(serialTitle)) {
            EpisodicMedia media = episodicMediaRepository.findById(serialTitle).get();
            List<Episode> medias = media.getEpisodeList();
            if (medias == null) {
                throw new NoEpisodeExistException("No episode exist");
            } else return medias;
        } else {
            throw new EpisodicMediaNotFoundException(mediaNotFound);
        }
    }

    //getting all the media in wishList
    @Cacheable
    @Override
    public List<EpisodicMedia> getListOfEpisodicMedia(List<String> titles) throws EpisodicMediaNotFoundException {
        List<EpisodicMedia> wishlist=new ArrayList<>();
        for (String title:titles) {
            if(episodicMediaRepository.existsById(title)){
                wishlist.add(episodicMediaRepository.findById(title).get());
            }
        }
        if(wishlist==null){
            throw new EpisodicMediaNotFoundException(mediaNotFound);
        }
        return wishlist;
    }

}
