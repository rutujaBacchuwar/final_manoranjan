package com.stackroute.service;

import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.FileNotUploadedException;
import com.stackroute.exception.MediaAlreadyExistsException;
import com.stackroute.exception.MediaNotFoundException;
import com.stackroute.repository.StandaloneRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.slf4j.Logger;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@CacheConfig(cacheNames = "media")
@Service
public class StandaloneServiceImpl implements StandaloneService{

    @Autowired
    private StandaloneRepository mediaRepository;

    @Autowired
    KafkaTemplate<StandaloneMedia,StandaloneMedia> kafkaTemplate;

  private String Home = System.getenv("HOME");


    private static String topic = "saveMedia";

    private String mediaNotFound="Media not found";
    private String mediaAlreadyExist="Media already exists";
    private String fail="Fail";


    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get(this.Home+"/uploads");

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //displaying all the standalone media
    @Cacheable
    @Override
    public List<StandaloneMedia> getAllMedia() throws MediaNotFoundException {
        List<StandaloneMedia> medias = mediaRepository.findAll();
        if (medias == null) {
            throw new MediaNotFoundException(mediaNotFound);
        } else return medias;
    }

    //searching standalone media by passing mediaTitle
    @Cacheable
    @Override
    public StandaloneMedia getMediaById(String mediaTitle) throws MediaNotFoundException {
        if (mediaRepository.existsById(mediaTitle)) {
            return mediaRepository.findById(mediaTitle).get();
        }
        else throw new MediaNotFoundException(mediaNotFound);
    }

    //saving standalone media by sending media object
    @CacheEvict(allEntries = true)
    @Override
    public StandaloneMedia saveMedia(StandaloneMedia media) throws MediaAlreadyExistsException {
        StandaloneMedia media1;
        if (mediaRepository.existsById(media.getMediaTitle())) {
            throw new MediaAlreadyExistsException(mediaAlreadyExist);
        } else {
            media1 = mediaRepository.save(media);
            kafkaTemplate.send(topic, media);
        }
        return media1;
    }

    //deleting statndalone media by media tilte
    @CacheEvict(allEntries = true)
    @Override
    public StandaloneMedia deleteMedia(String mediaTitle) throws MediaNotFoundException {
        StandaloneMedia media;
        if (mediaRepository.existsById(mediaTitle)) {
            media = mediaRepository.findById(mediaTitle).get();
            mediaRepository.deleteById(mediaTitle);
            return media;
        } else throw new MediaNotFoundException(mediaNotFound);
    }

    //seraching standalone media by genre
//    @Cacheable
    @Override
    public List<StandaloneMedia> getMediaByGenre(String genre) throws MediaNotFoundException {
        List<StandaloneMedia> allMedia = mediaRepository.findAll();
        if (allMedia == null) {
            throw new MediaNotFoundException(mediaNotFound);
        } else {
            List<StandaloneMedia> genreMedia = new ArrayList<>();
            for (StandaloneMedia media : allMedia) {
                if (media.getMediaCategory().equals("Movie")) {
                    if (media.getMediaGenre().contains(genre)) {
                        genreMedia.add(media);
                    }
                }
            }
            if (genreMedia == null) {
                throw new MediaNotFoundException(mediaNotFound);
            } else return genreMedia;
        }
    }

    //searching standalone media by category
    @Cacheable
    @Override
    public List<StandaloneMedia> getMediaByCategory(String category) throws MediaNotFoundException {
        List<StandaloneMedia> allMedia = mediaRepository.findAll();
        if (allMedia == null) {
            throw new MediaNotFoundException(mediaNotFound);
        } else {
            List<StandaloneMedia> catMedia = new ArrayList<>();
            for (StandaloneMedia media : allMedia) {
                if (media.getMediaCategory().equals(category)) {
                    catMedia.add(media);
                }
            }
            if (catMedia == null) {
                throw new MediaNotFoundException(mediaNotFound);
            } else return catMedia;
        }
    }

    //getting the mediaList
    @Cacheable
    @Override
    public List<StandaloneMedia> getWishlist(List<String> titles) throws MediaNotFoundException {
        List<StandaloneMedia> wishlist=new ArrayList<>();
        for (String title:titles) {
            if(mediaRepository.existsById(title)){
                wishlist.add(mediaRepository.findById(title).get());
            }
        }
        if(wishlist==null){
            throw new MediaNotFoundException(mediaNotFound);
        }
        return wishlist;
    }


    //stores files
    public void store(MultipartFile file) throws FileNotUploadedException {
        try {
            System.out.println("location of file"+this.rootLocation);
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new FileNotUploadedException(fail);
        }
    }

    //load files
    public Resource loadFile(String filename) throws FileNotUploadedException {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotUploadedException(fail);
            }
        } catch (MalformedURLException e) {
            throw new FileNotUploadedException(fail);
        }
    }

    //deleting all media from rootLocation
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    //creating rootLocation directory
    public void init() throws FileNotUploadedException {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new FileNotUploadedException("Could not initialize storage!");
        }
    }
}
