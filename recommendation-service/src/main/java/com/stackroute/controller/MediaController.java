package com.stackroute.controller;

import com.stackroute.domain.*;
import com.stackroute.exception.*;
import com.stackroute.service.MediaServiceImpl;
import com.stackroute.service.ViewerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@Api(value = "RecommendationServiceApi",produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/rest/neo4j")
public class MediaController {

    @Autowired
    private MediaServiceImpl mediaService;

    @Autowired
    private ViewerServiceImpl viewerService;

    //getting documentaries
    @ApiOperation("Get all documentaries")
    @GetMapping("/documentaries")
    public Collection<Documentary> getDocumentary() throws MediaNotFoundException {
        return mediaService.getDocumentary();
    }

    //getting movies
    @ApiOperation("Get all movies")
    @GetMapping("/movies")
    public Collection<Movie> getMovie() throws MediaNotFoundException {
        return mediaService.getMovie();
    }

    //getting tv episodes
    @ApiOperation("Get tv episodes")
    @GetMapping("/tvEpisodes")
    public Collection<TvEpisodes> getTvEpisodes() throws MediaNotFoundException {
        return mediaService.getTvEpisodes();
    }

    //getting web series
    @ApiOperation("Get web series")
    @GetMapping("/webSeries")
    public Collection<WebSeries> getWebSeries() throws MediaNotFoundException {
        return mediaService.getWebSeries();
    }

    //getting all the languages
    @ApiOperation("Get languages")
    @GetMapping("/languages")
    public Collection<Language> getLanguages() throws LanguageNotFoundException {
        return mediaService.getLanguages();
    }

    //getting all the genres
    @ApiOperation("Get geners")
    @GetMapping("/genres")
    public Collection<Genre> getGenres() throws GenreNotFoundException {
        return mediaService.getGenres();
    }

    //getting documentary by title
    @ApiOperation("Get document by title")
    @GetMapping("/documentary/{title}")
    public Documentary getDocumentaryByTitle(@PathVariable("title") String title) throws MediaNotFoundException {
        return mediaService.getDocumentaryByTitle(title);
    }

    //getting movie by title
    @ApiOperation("Get movie by title")
    @GetMapping("/movie/{title}")
    public Movie getMovieByTitle(@PathVariable("title") String title) throws MediaNotFoundException {
        return mediaService.getMovieByTitle(title);
    }

    //getting tv Episodes by title
    @ApiOperation("Get episode by title")
    @GetMapping("/tvEpisodes/{title}")
    public TvEpisodes getTvEpisodesByTitle(@PathVariable("title") String title) throws MediaNotFoundException {
        return mediaService.getTvEpisodesByTitle(title);
    }

    //getting web series by title
    @ApiOperation("Get web series by title")
    @GetMapping("/webSeries/{title}")
    public WebSeries getWebSeriesByTitle(@PathVariable("title") String title) throws MediaNotFoundException {
        return mediaService.getWebSeriesByTitle(title);
    }

    //posting documentary
    @ApiOperation("save new documentory")
    @PostMapping("/standalone/documentary")
    public Documentary saveNewDocumentary(@RequestBody Documentary documentary) throws MediaAlreadyExistException {
        return mediaService.saveDocumentary(documentary);
    }

    //posting movie
    @ApiOperation("Save new movie")
    @PostMapping("/standalone/movie")
    public Movie saveNewMovie(@RequestBody Movie movie) throws MediaAlreadyExistException {
        return mediaService.saveMovie(movie);
    }

    //posting tv episodes
    @ApiOperation("Save new episode")
    @PostMapping("/episodicMedia/tvEpisode")
    public TvEpisodes saveNewTvEpisodes(@RequestBody TvEpisodes tvEpisodes) throws MediaAlreadyExistException {
        return mediaService.saveTvEpisodes(tvEpisodes);
    }

    //posting web series
    @ApiOperation("Save new web series")
    @PostMapping("/episodicMedia/webSeries")
    public WebSeries saveNewWebSeries(@RequestBody WebSeries webSeries) throws MediaAlreadyExistException {
        return mediaService.saveWebSeries(webSeries);
    }

    //getting all the viewers
    @ApiOperation("Get viewer")
    @GetMapping("/viewers")
    public Collection<Viewer> getViewer() throws ViewerNotFoundException {
        return viewerService.getAll();
    }

    //posting the viewer
    @ApiOperation("Save viewer")
    @PostMapping("/viewer")
    public Viewer saveViewer(@RequestBody Viewer viewer) throws ViewerAlreadyExistException {
        return viewerService.saveViewer(viewer);
    }

    //getting viewer by emailId
    @ApiOperation("Get by email")
    @GetMapping("/viewer/{email}")
    public Viewer getByEmailId(@PathVariable("email") String email) throws ViewerNotFoundException {
        return viewerService.getViewerByEmailId(email);
    }

    //updating viewer details
    @ApiOperation("Update details")
    @PutMapping("/viewer")
    public Viewer updateDetails(@RequestBody Viewer viewer) throws ViewerNotFoundException {
        return viewerService.updateDetails(viewer);
    }

    //deleting viewer
    @ApiOperation("delete viewer")
    @DeleteMapping("/viewer")
    public Collection<Viewer> deleteViewer(@RequestBody Viewer viewer) throws ViewerNotFoundException {
        return viewerService.deleteViewer(viewer.getEmailId());
    }


    //posting the emailId of viewer and title of documentary
    @ApiOperation("Save episodic media relation")
    @PostMapping("graphDocumentary/{email}/{title}")
    public Viewer saveDocumentaryRelation(@PathVariable String email, @PathVariable String title) throws ViewerNotFoundException {
        return viewerService.saveDocumentaryRelation(email, title);
    }

    //posting the emailId of viewer and title of movie
    @PostMapping("graphMovie/{email}/{title}")
    public Viewer saveMovieRelation(@PathVariable String email, @PathVariable String title) throws ViewerNotFoundException {
        return viewerService.saveMovieRelation(email, title);
    }

    //posting the emailId of viewer and title of tv episodes
    @PostMapping("graphTvEpisodes/{email}/{title}")
    public Viewer saveTvEpisodesRelation(@PathVariable String email, @PathVariable String title) throws ViewerNotFoundException {
        return viewerService.saveTvEpisodesRelation(email, title);
    }

    //posting the emailId of viewer and title of web series
    @PostMapping("graphWebSeries/{email}/{title}")
    public Viewer saveWebSeriesRelation(@PathVariable String email, @PathVariable String title) throws ViewerNotFoundException {
        return viewerService.saveWebSeriesRelation(email, title);
    }


    @GetMapping("/recommendedInterestDocumentary/{email}")
    public Collection<Documentary> getRecInterestDocumentary(@PathVariable String email) throws MediaNotFoundException {
        return mediaService.getRecInterestDoc(email);
    }
    @GetMapping("/recommendedInterestMovie/{email}")
    public Collection<Movie> getRecInterestMovie(@PathVariable String email) throws MediaNotFoundException {
        return mediaService.getRecInterestMovie(email);
    }
    @GetMapping("/recLangDocumentary/{email}")
    public Collection<Documentary> getRecLangDoc(@PathVariable String email){
        return mediaService.getRecLangDocumentary(email);
    }
    @GetMapping("/recLangMovie/{email}")
    public Collection<Movie> getRecLangMovie(@PathVariable String email){
        return mediaService.getRecLangMovie(email);
    }
    @GetMapping("/recLangTvEpisodes")
    public Collection<TvEpisodes> getRecLangTvEpisodes(@PathVariable String email){
        return mediaService.getRecLangTvEpisodes(email);
    }
    @GetMapping("/recLangWebSeries/{email}")
    public Collection<WebSeries> getRecLangWebSeries(@PathVariable String email){
        return mediaService.getRecLangWebSeries(email);
    }
}
