package com.stackroute.repository;

import com.stackroute.domain.Cast;
import com.stackroute.domain.Crew;
import com.stackroute.domain.StandaloneMedia;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class StandaloneRepositoryTest {

    @Autowired
    private StandaloneRepository mediaRepository;

    private StandaloneMedia media;

    @Before
    public void setUp() throws Exception {
        media = new StandaloneMedia();
        media.setMediaTitle("2 states");
        media.setMediaCategory("Movie");
        media.setMediaSynopsis("Movies based on people from 2 different states");

        List<String> genres = new ArrayList<String>();
        genres.add("Romantic");
        genres.add("Action");

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
    }

    @After
    public void tearDown() throws Exception {
        mediaRepository.deleteAll();
    }

    //testcase for save media
    @Test
    public void testSaveMedia_returnSavedMedia() {
        mediaRepository.save(media);
        StandaloneMedia media1 = mediaRepository.findById("2 states").get();
        System.out.println(media1);
        Assert.assertEquals(media, media1);
    }

    //testcase for save media failure
    @Test
    public void testSaveMediaFailure_returnSavedMedia() {
        mediaRepository.save(media);
        StandaloneMedia media1 = mediaRepository.findById("2 states").get();
        Assert.assertNotEquals("2 cities", media1.getMediaTitle());

    }

    //testcase for all media
    @Test
    public void testAllMedia_returnListOfMedia() {
        mediaRepository.save(media);
        List<StandaloneMedia> mediaList = mediaRepository.findAll();
        Assert.assertEquals(true, mediaList.contains(media));
    }

    //test case for all media failure
    @Test
    public void testAllMediaFailure_returnListOfMedia() {
        mediaRepository.save(media);
        List<StandaloneMedia> mediaList = mediaRepository.findAll();
        Assert.assertNotEquals(false, mediaList.contains(media));
    }

    //testcase for delete media
    @Test
    public void testDeleteMedia_returnDeletedMedia() {
        mediaRepository.save(media);
        mediaRepository.deleteById("2 states");
        List<StandaloneMedia> mediaList = mediaRepository.findAll();
        Assert.assertEquals(false, mediaList.contains(media));
    }

    //testcase for delete media failure
    @Test
    public void testDeleteMediaFailure_returnDeletedMedia() {
        mediaRepository.save(media);
        mediaRepository.deleteById("2 states");
        List<StandaloneMedia> mediaList = mediaRepository.findAll();
        Assert.assertNotEquals(true, mediaList.contains(media));
    }


}