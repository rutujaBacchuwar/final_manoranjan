package com.stackroute.service;

import com.stackroute.domain.EpisodicMedia;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.domain.User;
import com.stackroute.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EpisodicMediaConsumer {

    @Autowired
    TvEpisodesRepository tvEpisodesRepository;

    @Autowired
    WebSeriesRepository webSeriesRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DocumentaryRepository documentaryRepository;

    @Autowired
    UserRepository userRepository;

    @KafkaListener(topics = "saveUser", groupId = "Group_UserObject")
    public void consumeJson(@Payload User user){
       System.out.println("=================published Json object consumer ===================   " +user.toString());
       userRepository.createUser(user.getName(),user.getEmailId());
        for (int i = 0; i < user.getGenre().size(); i++)
        {
            userRepository.createGenreRelation(user.getEmailId(), user.getGenre().get(i));
        }
    }

    @KafkaListener(topics = "saveEpisodicMedia", groupId = "Group_EpisodicMediaObject")
    public void consumeJson(@Payload EpisodicMedia episodicMedia) {
        System.out.println("=================published Json object consumer ===================   " + episodicMedia.toString());

        if (episodicMedia.getEpisodicCategory().equals("TV Episodes")) {
            System.out.println("+++++++++++++++++++++");
            tvEpisodesRepository.createTvEpisodesNode(episodicMedia.getEpisodicTitle());
            tvEpisodesRepository.createCategoryRelation(episodicMedia.getEpisodicTitle(), episodicMedia.getEpisodicCategory());
            tvEpisodesRepository.createLanguageRelation(episodicMedia.getEpisodicTitle(), episodicMedia.getEpisodicLanguage());
        } else {
            System.out.println("------------------------------------------");
            webSeriesRepository.createWebSeriesNode(episodicMedia.getEpisodicTitle());
            webSeriesRepository.createCategoryRelation(episodicMedia.getEpisodicTitle(), episodicMedia.getEpisodicCategory());
            webSeriesRepository.createLanguageRelation(episodicMedia.getEpisodicTitle(), episodicMedia.getEpisodicLanguage());
        }
    }

    @KafkaListener(topics = "saveMedia", groupId = "Group_MediaObject")
    public void consumeJson(@Payload StandaloneMedia standaloneMedia) {
        System.out.println("##############################################");
        System.out.println("****************************"+standaloneMedia.getMediaCategory());
        if (standaloneMedia.getMediaCategory().equals("Documentary")) {
            System.out.println("!!!!!!!!!!!!!!!!! in documentary !!!!!!!!!!!!!!!!!!!!!!!!!!");
            documentaryRepository.createDocumentaryNode(standaloneMedia.getMediaTitle());
            documentaryRepository.createCategoryRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaCategory());
            documentaryRepository.createLanguageRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaLanguage());
            for (int i = 0; i < standaloneMedia.getMediaGenre().size(); i++) {
                movieRepository.createGenreRelation(standaloneMedia.getMediaTitle(),standaloneMedia.getMediaGenre().get(i));
            }
        }
        else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ in movie @@@@@@@@@@@@@@@@@@@");
            movieRepository.createMovieNode(standaloneMedia.getMediaTitle());
            movieRepository.createCategoryRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaCategory());
            movieRepository.createLanguageRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaLanguage());
            for (int i = 0; i < standaloneMedia.getMediaGenre().size(); i++) {
                movieRepository.createGenreRelation(standaloneMedia.getMediaTitle(),standaloneMedia.getMediaGenre().get(i));
            }
        }
        System.out.println("=================published Json object consumer ===================   " + standaloneMedia.toString());
    }
}
