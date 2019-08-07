package com.stackroute.service;

import com.stackroute.domain.Episode;
import com.stackroute.domain.EpisodicMedia;
import com.stackroute.exception.*;

import java.util.List;

public interface EpisodicService {

    //adding episodic media
    public EpisodicMedia saveEpisodicMedia(EpisodicMedia serial) throws EpisodicMediaAlreadyExistsException;

    //fetching all the episodic media
    public List<EpisodicMedia> getAllEpisodicMedias() throws NoEpisodicMediaExistException;

    //fetching episodic media by episodic Title
    public EpisodicMedia getEpisodicMediaByTitle(String episodicTitle) throws EpisodicMediaNotFoundException;

    //deleting episode by episode title
    public EpisodicMedia deleteEpisodicMedia(String serialTitle) throws EpisodicMediaNotFoundException;

    //fetching episodic media by category
    public List<EpisodicMedia> getEpisodicMediaByCategory(String category) throws EpisodicMediaNotFoundException;

    //fetching episodic media by language
    public List<EpisodicMedia> getEpisodicByLanguage(String language) throws EpisodicMediaNotFoundException;

    //adding episode
    public Episode addEpisode(String serialTitle, Episode episode) throws EpisodeAlreadyExistsException, EpisodicMediaNotFoundException;

    //deleting episode by episode title and episode number
    public Episode deleteEpisode(String serialTitle, int episodeNumber) throws EpisodicMediaNotFoundException, EpisodeNotFoundException;

    //fetching the episode by serailTitle and episode Number
    public Episode getEpisodeByNumber(String serialTitle, int episodeNumber) throws EpisodicMediaNotFoundException,EpisodeNotFoundException;

    //fetching all the episodes
    public List<Episode> getAllEpisodes(String serialTitle) throws EpisodicMediaNotFoundException, NoEpisodeExistException;

    //fetching all the media in wishlist
    public List<EpisodicMedia> getListOfEpisodicMedia(List<String> titles) throws EpisodicMediaNotFoundException;

}
