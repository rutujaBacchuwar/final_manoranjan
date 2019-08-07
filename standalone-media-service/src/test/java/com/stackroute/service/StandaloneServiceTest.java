package com.stackroute.service;

import com.stackroute.domain.Cast;
import com.stackroute.domain.Crew;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.MediaAlreadyExistsException;
import com.stackroute.exception.MediaNotFoundException;
import com.stackroute.repository.StandaloneRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StandaloneServiceTest {
    @Mock
    private StandaloneRepository mediaRepository;

    @InjectMocks
    private StandaloneServiceImpl mediaService;

    private StandaloneMedia media;


    private List<StandaloneMedia> mediaList=null;

    private Optional optional;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);//initializes mock object
        media = new StandaloneMedia();
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

        optional = Optional.of(media);
    }

    @After
    public void tearDown() throws Exception {
        mediaRepository.deleteAll();
    }


    //testcase for get all media
    @Test
    public void getAllMediaTest_returnListOfMediaContainingMedia() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(mediaList);
        List<StandaloneMedia> mediaList1 = mediaService.getAllMedia();
        Assert.assertEquals(true, mediaList1.contains(media));
    }

    //testcase for getall media failure
    @Test(expected = MediaNotFoundException.class)
    public void getAllMediaFailureTest_returnListOfMediaContainingNull() throws MediaNotFoundException {
        when(mediaRepository.findAll()).thenReturn(null);
        List<StandaloneMedia> mediaList1 = mediaService.getAllMedia();
        Assert.assertEquals(true, mediaList1.contains(media));
    }

    //testcase for getmedia by id
    @Test
    public void getMediaByIdTest_returnMediaContainingGivenMediaTitle() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.existsById(media.getMediaTitle())).thenReturn(true);
        when(mediaRepository.findById(media.getMediaTitle())).thenReturn(optional);
        StandaloneMedia foundMedia = mediaService.getMediaById(media.getMediaTitle());
        Assert.assertEquals(optional.get(), foundMedia);
    }

    //testcase for getmedia by id failure
    @Test(expected = MediaNotFoundException.class)
    public void getMediaByIdFailureTest_returnNull() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.existsById(media.getMediaTitle())).thenReturn(false);
        when(mediaRepository.findById(media.getMediaTitle())).thenReturn(null);
        StandaloneMedia foundMedia = mediaService.getMediaById(media.getMediaTitle());
        Assert.assertEquals(media.getMediaTitle(), foundMedia.getMediaTitle());
    }

    //testcase for save media failure
    @Test(expected = MediaAlreadyExistsException.class)
    public void saveMediaFailureTest_returnSavedMediaAsNull() throws MediaAlreadyExistsException {
        when(mediaRepository.save(any())).thenReturn(null);
        StandaloneMedia savedMedia = mediaService.saveMedia(media);
        Assert.assertEquals(media, savedMedia);
    }

    //testcase for delete media
    @Test
    public void deleteMediaTest_returnDeletedMedia() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.existsById(media.getMediaTitle())).thenReturn(true);
        when(mediaRepository.findById(media.getMediaTitle())).thenReturn(optional);
        mediaRepository.deleteById(media.getMediaTitle());
        Assert.assertEquals(media, mediaService.deleteMedia(media.getMediaTitle()));
    }

    //testcase for delete media failure
    @Test(expected = MediaNotFoundException.class)
    public void deleteMediaFailureTest_returnNull() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.existsById(media.getMediaTitle())).thenReturn(false);
        when(mediaRepository.findById(media.getMediaTitle())).thenReturn(null);
        mediaRepository.deleteById(media.getMediaTitle());
        Assert.assertEquals(media, mediaService.deleteMedia(media.getMediaTitle()));
    }

    //testcase for gtemedia by genre
    @Test
    public void getMediaByGenreTest_returnListOfMediaOfGivenGenre() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(mediaList);
        List<StandaloneMedia> mediaList = mediaService.getMediaByGenre("action");
        Assert.assertEquals(true, mediaList.contains(media));
    }

    //testcase for get media by genre failure
    @Test(expected = MediaNotFoundException.class)
    public void getMediaByGenreFailureTest_returnNull() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(null);
        List<StandaloneMedia> mediaList = mediaService.getMediaByGenre("action");
        Assert.assertEquals(false, mediaList.contains(media));
    }

    //testcase for getmedia by category
    @Test
    public void getMediaByCategoryTest_returnListOfMediaOfGivenCategory() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(mediaList);
        List<StandaloneMedia> mediaList = mediaService.getMediaByCategory("Movie");
        Assert.assertEquals(true, mediaList.contains(media));
    }

    //testcase for get media by category negative
    @Test
    public void getMediaByCategoryNegativeTest_returnMediaList() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(mediaList);
        List<StandaloneMedia> mediaList = mediaService.getMediaByCategory("Documentary");
        Assert.assertNotEquals(true, mediaList.contains(media));
    }

    //testcase for getmedia by category failure
    @Test(expected = MediaNotFoundException.class)
    public void getMediaByCategoryFailureTest_returnNullMediaList() throws MediaNotFoundException {
        mediaRepository.save(media);
        when(mediaRepository.findAll()).thenReturn(null);
        List<StandaloneMedia> mediaList = mediaService.getMediaByCategory("Movie");
        Assert.assertEquals(false, mediaList.contains(media));
    }
}