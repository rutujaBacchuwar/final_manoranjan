package com.stackroute.service;

import com.stackroute.domain.*;
import com.stackroute.exception.GenreNotFoundException;
import com.stackroute.exception.LanguageNotFoundException;
import com.stackroute.exception.MediaAlreadyExistException;
import com.stackroute.exception.MediaNotFoundException;
import com.stackroute.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.Collection;

@CacheConfig(cacheNames = "media")
@Primary
@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private DocumentaryRepository documentaryRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TvEpisodesRepository tvEpisodesRepository;

    @Autowired
    private WebSeriesRepository webSeriesRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private InterestedInRelationshipRepository interestedInRelationshipRepository;

    @Autowired
    private InLanguageRelationshipRepository inLanguageRelationshipRepository;

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //method to get all documentaries
    @Cacheable
    public Collection<Documentary> getDocumentary() throws MediaNotFoundException {
        if (documentaryRepository.getAllDocumentary() == null) {
            throw new MediaNotFoundException();
        }
        else {
            return documentaryRepository.getAllDocumentary();
        }
    }

    //method to get all movies
    @Cacheable
    public Collection<Movie> getMovie() throws MediaNotFoundException {
        if (movieRepository.getAllMovie() == null) {
            throw new MediaNotFoundException();
        }
        else {
            return movieRepository.getAllMovie();
        }
    }

    //method to get all Tv Episodes
    @Cacheable
    public Collection<TvEpisodes> getTvEpisodes() throws MediaNotFoundException {
        if (tvEpisodesRepository.getAllTvEpisodes() == null) {
            throw new MediaNotFoundException();
        }
        else {
            return tvEpisodesRepository.getAllTvEpisodes();
        }
    }

    //method to get all Web Series
    @Cacheable
    public Collection<WebSeries> getWebSeries() throws MediaNotFoundException {
        if (webSeriesRepository.getAllWebSeries() == null) {
            throw new MediaNotFoundException();
        }
        else {
            return webSeriesRepository.getAllWebSeries();
        }
    }

    //method to get all languages
    @Cacheable
    public Collection<Language> getLanguages() throws LanguageNotFoundException {
        if (languageRepository.getAllLanguages() == null) {
            throw new LanguageNotFoundException();
        } else {
            return languageRepository.getAllLanguages();
        }
    }

    //method to get all genres
    @Cacheable
    public Collection<Genre> getGenres() throws GenreNotFoundException {
        if (genreRepository.getAllGenres() == null) {
            throw new GenreNotFoundException();
        } else {
            return genreRepository.getAllGenres();
        }
    }

    //method to get documentary by title
    @Cacheable
    public Documentary getDocumentaryByTitle(String MediaTitle) throws MediaNotFoundException {
        if (documentaryRepository.findDocumentaryByMediaTitle(MediaTitle) == null) {
            throw new MediaNotFoundException();
        } else {
            return documentaryRepository.findDocumentaryByMediaTitle(MediaTitle);
        }
    }

    //method to get movie by title
    @Cacheable
    public Movie getMovieByTitle(String title) throws MediaNotFoundException {
        if (movieRepository.findMovieByMediaTitle(title) == null) {
            throw new MediaNotFoundException();
        } else {
            return movieRepository.findMovieByMediaTitle(title);
        }
    }

    //method to get Tv Episodes by title
    @Cacheable
    public TvEpisodes getTvEpisodesByTitle(String title) throws MediaNotFoundException {
        if (tvEpisodesRepository.findTvEpisodeByEpisodicTitle(title) == null) {
            throw new MediaNotFoundException();
        } else {
            return tvEpisodesRepository.findTvEpisodeByEpisodicTitle(title);
        }
    }

    //method to get Web Series by title
    @Cacheable
    public WebSeries getWebSeriesByTitle(String title) throws MediaNotFoundException {
        if (webSeriesRepository.findWebSeriesByEpisodicTitle(title) == null) {
            throw new MediaNotFoundException();
        } else {
            return webSeriesRepository.findWebSeriesByEpisodicTitle(title);
        }
    }

    //method to save Documentary
    @CacheEvict(allEntries = true)
    public Documentary saveDocumentary(Documentary documentary) throws MediaAlreadyExistException {
        if (documentaryRepository.findDocumentaryByMediaTitle(documentary.getMediaTitle()) == null)
        {
            documentaryRepository.createDocumentaryNode(documentary.getMediaTitle());
            documentaryRepository.createLanguageRelation(documentary.getMediaTitle(), documentary.getMediaLanguage());
            documentaryRepository.createCategoryRelation(documentary.getMediaTitle(), documentary.getMediaCategory());

            for (int i = 0; i < documentary.getMediaGenre().size(); i++) {
                System.out.println(documentary.getMediaGenre().get(i));
                documentaryRepository.createGenreRelation(documentary.getMediaTitle(), documentary.getMediaGenre().get(i));
            }
        }
        else
        {
            throw new MediaAlreadyExistException();
        }
      return documentary;
    }

    //method to save movie
    @CacheEvict(allEntries = true)
    public Movie saveMovie(Movie movie) throws MediaAlreadyExistException{
        if (movieRepository.findMovieByMediaTitle(movie.getMediaTitle()) == null) {
            movieRepository.createMovieNode(movie.getMediaTitle());
            movieRepository.createLanguageRelation(movie.getMediaTitle(), movie.getMediaLanguage());
            movieRepository.createCategoryRelation(movie.getMediaTitle(), movie.getMediaCategory());

            for (int i = 0; i < movie.getMediaGenre().size(); i++) {
                movieRepository.createGenreRelation(movie.getMediaTitle(), movie.getMediaGenre().get(i));
            }
        }
        else
        {
            throw new MediaAlreadyExistException();
        }
       return movie;
    }

    //method to save tv episodes
    @CacheEvict(allEntries = true)
    public TvEpisodes saveTvEpisodes(TvEpisodes tvEpisodes) throws MediaAlreadyExistException{
        if (tvEpisodesRepository.findTvEpisodeByEpisodicTitle(tvEpisodes.getEpisodicTitle()) == null) {

            tvEpisodesRepository.createTvEpisodesNode(tvEpisodes.getEpisodicTitle());
            tvEpisodesRepository.createLanguageRelation (tvEpisodes.getEpisodicTitle(), tvEpisodes.getEpisodicLanguage());
            tvEpisodesRepository.createCategoryRelation (tvEpisodes.getEpisodicTitle(), tvEpisodes.getEpisodicCategory());
        }
        else
        {
            throw new MediaAlreadyExistException();
        }
        return tvEpisodes;
    }

    //method to save web series
    @CacheEvict(allEntries = true)
    public WebSeries saveWebSeries(WebSeries webSeries) throws MediaAlreadyExistException{
        if (webSeriesRepository.findWebSeriesByEpisodicTitle(webSeries.getEpisodicTitle()) == null) {

            webSeriesRepository.createWebSeriesNode(webSeries.getEpisodicTitle());
            webSeriesRepository.createLanguageRelation(webSeries.getEpisodicTitle(), webSeries.getEpisodicLanguage());
            webSeriesRepository.createCategoryRelation(webSeries.getEpisodicTitle(), webSeries.getEpisodicCategory());
        }
        else
        {
            throw new MediaAlreadyExistException();
        }
        return webSeries;
    }

    public Collection<Documentary> getRecInterestDoc(String emailId){
        return interestedInRelationshipRepository.getRecommendedDocumentary(emailId);
    }

    public Collection<Movie> getRecInterestMovie(String emilId){
        return interestedInRelationshipRepository.getRecommendedMovie(emilId);
    }

    public Collection<Documentary> getRecLangDocumentary(String emailId){
        return inLanguageRelationshipRepository.getRecommendedDocumentary(emailId);
    }
    public Collection<Movie> getRecLangMovie(String emailId){
        return inLanguageRelationshipRepository.getRecommendedMovie(emailId);
    }
    public Collection<TvEpisodes> getRecLangTvEpisodes(String emailId){
        return inLanguageRelationshipRepository.getRecommendedTvEpisodes(emailId);
    }
    public Collection<WebSeries> getRecLangWebSeries(String emailId){
        return inLanguageRelationshipRepository.getRecommendedWebSeries(emailId);
    }
}