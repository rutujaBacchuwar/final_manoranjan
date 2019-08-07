package com.stackroute.service;

import com.stackroute.domain.*;
import com.stackroute.exception.GenreNotFoundException;
import com.stackroute.exception.LanguageNotFoundException;
import com.stackroute.exception.MediaAlreadyExistException;
import com.stackroute.exception.MediaNotFoundException;

import java.util.Collection;

public interface MediaService {
    public Collection<Documentary> getDocumentary() throws MediaNotFoundException;
    public Collection<Movie> getMovie() throws MediaNotFoundException;
    public Collection<TvEpisodes> getTvEpisodes() throws MediaNotFoundException;
    public Collection<WebSeries> getWebSeries() throws MediaNotFoundException;

    public Collection<Language> getLanguages() throws LanguageNotFoundException;
    public Collection<Genre> getGenres() throws GenreNotFoundException;

    public Documentary getDocumentaryByTitle(String title) throws MediaNotFoundException;
    public Movie getMovieByTitle(String title) throws MediaNotFoundException;
    public TvEpisodes getTvEpisodesByTitle(String title) throws MediaNotFoundException;
    public WebSeries getWebSeriesByTitle(String title) throws MediaNotFoundException;

    public Documentary saveDocumentary(Documentary documentary) throws MediaAlreadyExistException;
    public Movie saveMovie(Movie movie) throws MediaAlreadyExistException;
    public TvEpisodes saveTvEpisodes(TvEpisodes tvEpisodes) throws MediaAlreadyExistException;
    public WebSeries saveWebSeries(WebSeries webSeries) throws MediaAlreadyExistException;

    public Collection<Documentary> getRecInterestDoc(String emailId);
    public Collection<Movie> getRecInterestMovie(String emilId);

    public Collection<Documentary> getRecLangDocumentary(String emailId);
    public Collection<Movie> getRecLangMovie(String emailId);
    public Collection<TvEpisodes> getRecLangTvEpisodes(String emailId);
    public Collection<WebSeries> getRecLangWebSeries(String emailId);
}