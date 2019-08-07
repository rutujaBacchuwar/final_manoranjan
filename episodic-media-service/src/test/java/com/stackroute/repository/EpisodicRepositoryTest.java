//package com.stackroute.episodicmediaservice.repository;
//
//import com.stackroute.episodicmediaservice.domain.Cast;
//import com.stackroute.episodicmediaservice.domain.Crew;
//import com.stackroute.episodicmediaservice.domain.Episode;
//import com.stackroute.episodicmediaservice.domain.EpisodicMedia;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class EpisodicRepositoryTest {
//    @Autowired
//    private EpisodicRepository episodicMediaRepository;
//
//    private EpisodicMedia episodicMedia;
//
//    @Before
//    public void setup() throws ParseException {
//
//        episodicMedia = new EpisodicMedia();
//        episodicMedia.setEpisodicType("Yeh rista");
//        episodicMedia.setEpisodicSynopsis("Yeh Rishta Kya Kehlata Hai tells the story of how the two meet, " +
//                "time and again, which leads to their relationship progressing further with each encounter.");
//        episodicMedia.setEpisodicLanguage("Hindi");
//        episodicMedia.setEpisodicType("premium");
//        episodicMedia.setEpisodicCategory("TV Episodes");
//        episodicMedia.setEpisodicPosterUrl("https://cdn.pinkvilla.com/files/styles/contentpreview/public/yehrishtatrptopperweek.jpg?itok=p9vofO7z");
//        episodicMedia.setEpisodicStudioName("Red chillies");
//
//        Crew crew = new Crew("Chetan", "Writer");
//        Cast cast = new Cast("Naira", "Shivangi");
//        Cast cast1 = new Cast("Kartik", "Mohsin");
//
//        List<Crew> crews = new ArrayList<>();
//        crews.add(crew);
//
//        episodicMedia.setEpisodicCrew(crews);
//
//        List<Cast> casts = new ArrayList<>();
//        casts.add(cast);
//        casts.add(cast1);
//
//        episodicMedia.setEpisodicCast(casts);
//
//        Episode episode = new Episode();
//        episode.setEpisodeNo(1);
//        episode.setEpisodeDescription("First meeting");
//        episode.setEpisodeUrl("video.mp4");
//        episode.setEpisodePosterUrl("https://cdn.pinkvilla.com/files/styles/contentpreview/public/yehrishtatrptopperweek.jpg?itok=p9vofO7z");
//
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date date = simpleDateFormat.parse("2019-06-09");
//        episode.setEpisodeReleaseDate(date);
//
//        Episode episode1 = new Episode();
//        episode1.setEpisodeNo(2);
//        episode1.setEpisodeDescription("Second meeting");
//        episode1.setEpisodeUrl("video.mp4");
//        episode1.setEpisodePosterUrl("https://cdn.pinkvilla.com/files/styles/contentpreview/public/yehrishtatrptopperweek.jpg?itok=p9vofO7z");
//
//        Date date1 = simpleDateFormat.parse("2019-06-10");
//        episode1.setEpisodeReleaseDate(date1);
//
//        List<Episode> episodes = new ArrayList<>();
//        episodes.add(episode);
//        episodes.add(episode1);
//
//        episodicMedia.setEpisodeList(episodes);
//    }
//
//    @After
//    public void teardown() {
//        episodicMediaRepository.deleteAll();
//    }
//
//    //testcase for save episodic media
//    @Test
//    public void saveEpisodicMediaTest_returnTrueIfSavedMediaExist() {
//        episodicMediaRepository.save(episodicMedia);
//        Assert.assertEquals(true, episodicMediaRepository.existsById(episodicMedia.getEpisodicTitle()));
//    }
//
//    //testcase for save episodic media failure
//    @Test
//    public void saveEpisodicMediaFailureTest_returnFalseAsSavedMediaExists() {
//        episodicMediaRepository.save(episodicMedia);
//        Assert.assertNotEquals(false, episodicMediaRepository.existsById(episodicMedia.getEpisodicTitle()));
//    }
//
//    //testcase for delete episode media
//    @Test
//    public void deleteEpisodicMediaTest_returnFalseAsDeletedMediaDoesNotExist() {
//        episodicMediaRepository.save(episodicMedia);
//        episodicMediaRepository.deleteById(episodicMedia.getEpisodicTitle());
//        Assert.assertEquals(false, episodicMediaRepository.findAll().contains(episodicMedia));
//    }
//
//    //testcase for delete episodic media failure
//    @Test
//    public void deleteEpisodicMediaFailureTest_returnTrueAsDeletedMediaDoesNotExist() {
//        episodicMediaRepository.save(episodicMedia);
//        episodicMediaRepository.deleteById(episodicMedia.getEpisodicTitle());
//        Assert.assertNotEquals(true, episodicMediaRepository.findAll().contains(episodicMedia));
//    }
//
//    //testcase for getallmedia
//    @Test
//    public void getAllMediaTest_returnListOfEpisodiCMediaContainingEpisodicMedia() {
//        episodicMediaRepository.save(episodicMedia);
//        List<EpisodicMedia> episodicMediaList = episodicMediaRepository.findAll();
//        Assert.assertEquals(true, episodicMediaList.contains(episodicMedia));
//    }
//
//    //testcase for getallmedia failure
//    @Test
//    public void getAllMediaTestFailureTest_returnListOfEpisodiCMediaContainingEpisodicMedia() {
//        episodicMediaRepository.save(episodicMedia);
//        List<EpisodicMedia> episodicMediaList = episodicMediaRepository.findAll();
//        Assert.assertNotEquals(false, episodicMediaList.contains(episodicMedia));
//    }
//}