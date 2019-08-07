//package com.stackroute.episodicmediaservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.episodicmediaservice.domain.Cast;
//import com.stackroute.episodicmediaservice.domain.Crew;
//import com.stackroute.episodicmediaservice.domain.Episode;
//import com.stackroute.episodicmediaservice.domain.EpisodicMedia;
//import com.stackroute.episodicmediaservice.exception.EpisodicControllerHandler;
//import com.stackroute.episodicmediaservice.exception.EpisodicMediaAlreadyExistsException;
//import com.stackroute.episodicmediaservice.service.EpisodicService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class EpisodicControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EpisodicService mediaService;
//
//    @InjectMocks
//    private EpisodicController mediaController;
//
//    private EpisodicMedia episodicMedia;
//
//    private List<EpisodicMedia> episodicMediaList=null;
//
//    private List<Episode> episodes;
//
//    private Episode episode;
//    private Episode episode1;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc= MockMvcBuilders.standaloneSetup(mediaController).setControllerAdvice(new EpisodicControllerHandler()).build();
//
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
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
//        Crew crewEM = new Crew("Chetan", "Writer");
//        Cast castEM = new Cast("Naira", "Shivangi");
//        Cast cast1EM = new Cast("Kartik", "Mohsin");
//
//        List<Crew> crewsEM = new ArrayList<>();
//        crewsEM.add(crewEM);
//
//        episodicMedia.setEpisodicCrew(crewsEM);
//
//        List<Cast> castsEM = new ArrayList<>();
//        castsEM.add(castEM);
//        castsEM.add(cast1EM);
//
//        episodicMedia.setEpisodicCast(castsEM);
//
//        episode = new Episode();
//        episode.setEpisodeNo(1);
//        episode.setEpisodeDescription("First meeting");
//        episode.setEpisodeUrl("video.mp4");
//        episode.setEpisodePosterUrl("https://cdn.pinkvilla.com/files/styles/contentpreview/public/yehrishtatrptopperweek.jpg?itok=p9vofO7z");
//
//        Date dateEM = simpleDateFormat.parse("2019-06-09");
//        episode.setEpisodeReleaseDate(dateEM);
//
//        episode1 = new Episode();
//        episode1.setEpisodeNo(2);
//        episode1.setEpisodeDescription("Second meeting");
//        episode1.setEpisodeUrl("video.mp4");
//        episode1.setEpisodePosterUrl("https://cdn.pinkvilla.com/files/styles/contentpreview/public/yehrishtatrptopperweek.jpg?itok=p9vofO7z");
//
//        Date date1 = simpleDateFormat.parse("2019-06-10");
//        episode1.setEpisodeReleaseDate(date1);
//
//        episodes = new ArrayList<>();
//        episodes.add(episode);
//
//        episodicMedia.setEpisodeList(episodes);
//
//        episodicMediaList = new ArrayList<>();
//        episodicMediaList.add(episodicMedia);
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //testcase for save serial
////    @Test
////    public void saveSerialTest_returnOkHttpStatus() throws Exception {
////        when(mediaService.saveEpisodicMedia(any())).thenReturn(episodicMedia);
////        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/serial")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMedia)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for saveserial failure
////    @Test
////    public void saveSerialTest_returnConflictHttpStatus() throws Exception {
////        when(mediaService.saveEpisodicMedia(any())).thenReturn(null);
////        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/serial")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(null)))
////                .andExpect(MockMvcResultMatchers.status().isConflict())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for save episode
////    @Test
////    public void saveEpisodeTest_returnOkHttpStatus() throws Exception {
////        when(mediaService.addEpisode(any(), any())).thenReturn(episode);
////        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/episode/Yeh rista")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episode)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for save serial failure
////    @Test
////    public void saveEpisodeTest_returnConflictHttpStatus() throws Exception {
////        when(mediaService.addEpisode(any(), any())).thenReturn(null);
////        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/episode/Yeh rista")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(null)))
////                .andExpect(MockMvcResultMatchers.status().isConflict())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for getallserials
////    @Test
////    public void getAllSerialsTest() throws Exception {
////        when(mediaService.getAllEpisodicMedias()).thenReturn(episodicMediaList);
////        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/serials")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMedia)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for getallepisodes
////    @Test
////    public void getAllEpisodesTest() throws Exception {
////        when(mediaService.getAllEpisodes("Yeh rishta")).thenReturn(episodes);
////        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/episodes/Yeh rishta")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episode)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for getserialbyId
////    @Test
////    public void getSerialByIdTest() throws Exception {
////        when(mediaService.getEpisodicMediaByTitle("Yeh rishta")).thenReturn(episodicMedia);
////        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/serial/Yeh rishta")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMedia)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for get serial by language
////    @Test
////    public void getSerialByLanguageTest() throws Exception {
////        when(mediaService.getEpisodicByLanguage("Hindi")).thenReturn(episodicMediaList);
////        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/series/tv/Hindi")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMediaList)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for get episode by category
////    @Test
////    public void getEpisodicByCategoryTest() throws Exception {
////        when(mediaService.getEpisodicMediaByCategory("TV Episodes")).thenReturn(episodicMediaList);
////        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/series/category/TV Episodes")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMediaList)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    //testcase for deleting serial
////    @Test
////    public void deleteSerialTest() throws Exception {
////        when(mediaService.deleteEpisodicMedia(episodicMedia.getEpisodicTitle())).thenReturn(episodicMedia);
////        mockMvc.perform(MockMvcRequestBuilders.delete("/stream/v1/serial/Yeh rishta")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(episodicMedia)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
//
//}