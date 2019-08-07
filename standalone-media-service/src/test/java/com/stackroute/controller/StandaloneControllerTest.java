package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Cast;
import com.stackroute.domain.Crew;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.StandaloneControllerHandler;
import com.stackroute.service.StandaloneService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StandaloneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StandaloneService mediaService;

    @InjectMocks
    private StandaloneController mediaController;

    private StandaloneMedia media;
    private List<StandaloneMedia> mediaList=null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(mediaController).setControllerAdvice(new StandaloneControllerHandler()).build();
        media=new StandaloneMedia();

        media.setMediaTitle("2 states");
        media.setMediaCategory("Movie");
        media.setMediaSynopsis("Movies based on people from 2 different states");

        List<String> genres = new ArrayList<String>();
        genres.add("romantic");
        genres.add("action");

        media.setMediaGenre(genres);
        media.setMediaLanguage("Hindi");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("2018-09-09");
        media.setMediaReleaseDate(date);
        media.setMediaPosterUrl("https://images-na.ssl-images-amazon.com/images/I/51ZvSZqM9UL.jpg");
        media.setMediaStudioName("Red chillies");

        Crew crew = new Crew("Chetan Bhagat", "Writer");
        Cast cast = new Cast("Krish", "Arjun");
        Cast cast1 = new Cast("Ananya", "Alia");

        List<Crew> crews = new ArrayList<>();
        crews.add(crew);

        media.setMediaCrew(crews);

        List<Cast> casts = new ArrayList<>();
        casts.add(cast);
        casts.add(cast1);

        media.setMediaCast(casts);
        media.setMediaUrl("2states.mp4");
        media.setMediaTrailerUrl("trailer.mp4");
        media.setMediaType("Free");

        mediaList = new ArrayList<>();
        mediaList.add(media);
    }

    @After
    public void tearDown() throws Exception {

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //test case for savemedia
    @Test
    public void saveMediaTest_returnOkHttpStatus() throws Exception {
        when(mediaService.saveMedia(any())).thenReturn(media);
        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/media")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(media)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for save media failure
    @Test
    public void saveMediaTest_returnConflictHttpStatus() throws Exception {
        when(mediaService.saveMedia(any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/stream/v1/media")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(null)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for getAllMedia
    @Test
    public void getAllMediasTest_returnOkHttpStatus() throws Exception {
        when(mediaService.getAllMedia()).thenReturn(mediaList);
        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/medias")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(media)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for getmediabyid
    @Test
    public void getMediaByIdTest() throws Exception {
        when(mediaService.getMediaById("2 states")).thenReturn(media);
        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/media/2 states")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(media)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for getmediabygenre
    @Test
    public void getMediaByGenreTest() throws Exception {
        when(mediaService.getMediaByGenre("action")).thenReturn(mediaList);
        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/media/movie/action")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(mediaList)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for get specific category media
    @Test
    public void getSpecificCategoryMediaTest() throws Exception {
        when(mediaService.getMediaByCategory("Movie")).thenReturn(mediaList);
        mockMvc.perform(MockMvcRequestBuilders.get("/stream/v1/media/category/Movie")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(mediaList)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for deleting media
    @Test
    public void deleteMediaTest() throws Exception {
        when(mediaService.deleteMedia(media.getMediaTitle())).thenReturn(media);
        mockMvc.perform(MockMvcRequestBuilders.delete("/stream/v1/media/2 states")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(media)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}