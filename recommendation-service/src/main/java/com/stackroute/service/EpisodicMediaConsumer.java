package com.stackroute.service;

import com.stackroute.domain.EpisodicMedia;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.repository.DocumentaryRepository;
import com.stackroute.repository.MovieRepository;
import com.stackroute.repository.TvEpisodesRepository;
import com.stackroute.repository.WebSeriesRepository;
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
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ in movie @@@@@@@@@@@@@@@@@@@");
            movieRepository.createMovieNode(standaloneMedia.getMediaTitle());
            movieRepository.createCategoryRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaCategory());
            movieRepository.createLanguageRelation(standaloneMedia.getMediaTitle(), standaloneMedia.getMediaLanguage());
            //  movieRepository.createGenreRelation(standaloneMedia.getMediaTitle(),standaloneMedia.getMediaGenre());
        }

        System.out.println("=================published Json object consumer ===================   " + standaloneMedia.toString());
    }


}
