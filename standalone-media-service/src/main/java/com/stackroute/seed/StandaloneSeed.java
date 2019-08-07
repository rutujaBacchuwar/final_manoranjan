package com.stackroute.seed;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stackroute.domain.Cast;
import com.stackroute.domain.Crew;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.MediaAlreadyExistsException;
import com.stackroute.service.StandaloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Component
public class StandaloneSeed implements ApplicationListener<ContextRefreshedEvent> {
    StandaloneService standaloneService;

    @Autowired
    public StandaloneSeed(StandaloneService standaloneService) {
        this.standaloneService = standaloneService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        File file = new File("./src/main/resources/standalone.csv");
        System.out.println("File Exists : " + file.exists());
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            System.out.println("seed data................................................");
            StandaloneMedia standaloneMedia = new StandaloneMedia();
            for (String[] row : allData) {
                System.out.println("values" + Arrays.toString(row));
                standaloneMedia.setMediaTitle(row[0]);
                standaloneMedia.setMediaCategory(row[1]);
                standaloneMedia.setMediaSynopsis(row[2]);
                List<String> genres = new ArrayList<>();
                genres.add(row[3]);
                standaloneMedia.setMediaGenre(genres);
                standaloneMedia.setMediaLanguage(row[4]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(row[5]);
                standaloneMedia.setMediaReleaseDate(date);
                standaloneMedia.setMediaPosterUrl(row[6]);
                standaloneMedia.setMediaStudioName(row[7]);
                List<Crew> crews = new ArrayList<>();
                Crew crew = new Crew();
                crew.setCrewName(row[8]);
                crew.setCrewRole(row[9]);
                crews.add(crew);
                standaloneMedia.setMediaCrew(crews);
                List<Cast> casts = new ArrayList<>();
                Cast cast = new Cast();
                cast.setScreenName(row[10]);
                cast.setRealName(row[11]);
                casts.add(cast);
                standaloneMedia.setMediaCast(casts);
                standaloneMedia.setMediaUrl(row[12]);
                standaloneMedia.setMediaTrailerUrl(row[13]);
                standaloneMedia.setMediaType(row[14]);
                System.out.println("running" + standaloneMedia);
                standaloneService.saveMedia(standaloneMedia);
            }
        } catch (IOException | ParseException | MediaAlreadyExistsException ex) {
            ex.getMessage();
            System.out.println("Exception occured"+ ex.getMessage());
        }
    }
}

