package com.stackroute.seed;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import com.stackroute.domain.Cast;
import com.stackroute.domain.Crew;
import com.stackroute.domain.Episode;
import com.stackroute.domain.EpisodicMedia;
import com.stackroute.exception.EpisodicMediaAlreadyExistsException;
import com.stackroute.service.EpisodicService;

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
public class EpisodicSeedData implements ApplicationListener<ContextRefreshedEvent> {

    private EpisodicService episodicService;
    @Autowired
    public EpisodicSeedData(EpisodicService episodicService) {
        this.episodicService = episodicService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        File file = new File("./src/main/resources/episodic.csv");
        System.out.println("File Exists : " + file.exists());
        try{
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();
        List<String[]> seedData = csvReader.readAll();
        System.out.println("seed data................................................");
        System.out.println("count" + seedData.size());
        EpisodicMedia episodicMedia = new EpisodicMedia();
        for (String row[] : seedData) {
           // System.out.println("values"+ Arrays.toString(row));
            episodicMedia.setEpisodicTitle(row[0]);
            episodicMedia.setEpisodicCategory(row[1]);
            episodicMedia.setEpisodicSynopsis(row[2]);
            episodicMedia.setEpisodicLanguage(row[3]);
            episodicMedia.setEpisodicPosterUrl(row[4]);
            episodicMedia.setEpisodicStudioName(row[5]);
            List<Crew> crews=new ArrayList<>();
            Crew crew=new Crew();
            crew.setCrewName(row[6]);
            crew.setCrewRole(row[7]);
            crews.add(crew);
            episodicMedia.setEpisodicCrew(crews);
            List<Cast> casts=new ArrayList<>();
            Cast cast=new Cast();
            cast.setScreenName(row[8]);
            cast.setRealName(row[9]);
            casts.add(cast);
            episodicMedia.setEpisodicCast(casts);
            List<Episode> episodes=new ArrayList<>();
            Episode episode=new Episode();
            episode.setEpisodeNo(Integer.parseInt(row[10]));
            episode.setEpisodeUrl(row[11]);
            episode.setEpisodePosterUrl(row[12]);
            episode.setEpisodeDescription(row[13]);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(row[14]);
            episode.setEpisodeReleaseDate(date);
            episodes.add(episode);
            episodicMedia.setEpisodeList(episodes);
            episodicMedia.setEpisodicType(row[15]);
            System.out.println("running"+episodicMedia);
            episodicService.saveEpisodicMedia(episodicMedia);
        }
    } catch (IOException | ParseException | EpisodicMediaAlreadyExistsException ex) {
        ex.getMessage();
        System.out.println("Exception occured");
    }
    }
}
