package com.stackroute.controller;

import com.stackroute.domain.Episode;
import com.stackroute.domain.EpisodicMedia;
import com.stackroute.exception.*;
import com.stackroute.service.EpisodicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "EpisodicControllerApi",produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/stream/v1")
@CrossOrigin("*")
public class EpisodicController {
    @Autowired
    private EpisodicService mediaService;

    //posting episodic media
    @PostMapping("/episodic-media")
    @ApiOperation("Save episodic media")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = EpisodicMedia.class)})
    public ResponseEntity<?> saveEpisodicMedia(@RequestBody EpisodicMedia media) throws EpisodicMediaAlreadyExistsException {
        EpisodicMedia media1;
        media1=mediaService.saveEpisodicMedia(media);
        return new ResponseEntity<>(media1, HttpStatus.OK);
    }

    //posting single episode
    @PostMapping("/episode/{media-title}")
    @ApiOperation("Save episode")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> saveEpisode(@PathVariable("media-title") String serialTitle, @RequestBody Episode episode) throws EpisodicMediaNotFoundException, EpisodeAlreadyExistsException {
        return new ResponseEntity<>(mediaService.addEpisode(serialTitle, episode), HttpStatus.OK);
    }

    //getting all the episodic media
    @GetMapping("/episodic-medias")
    @ApiOperation("Get all episodic-medias")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getAllEpisodicMedias() throws NoEpisodicMediaExistException {
        List<EpisodicMedia> episodicMediaList;
        episodicMediaList=mediaService.getAllEpisodicMedias();
        return new ResponseEntity<>(episodicMediaList,HttpStatus.OK);
    }

    //searching all the episodes of single episodic media
    @GetMapping("/episodes/{title}")
    @ApiOperation("Get all episodes ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getAllEpisodes(@PathVariable("title") String serialTitle) throws EpisodicMediaNotFoundException, NoEpisodeExistException {
        return new ResponseEntity<>(mediaService.getAllEpisodes(serialTitle),HttpStatus.OK);
    }

    //searching single episodic media by title
    @GetMapping("/episodic-media/{title}")
    @ApiOperation("Get serial by id ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getEpisodicMediaById(@PathVariable("title") String serialTitle) throws EpisodicMediaNotFoundException {
        return new ResponseEntity<>(mediaService.getEpisodicMediaByTitle(serialTitle),HttpStatus.OK);
    }


    //seraching the episode by episode title and episode number
    @GetMapping("/episode/{title}/{episode-num}")
    @ApiOperation("Get episode by id ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getEpisodeById(@PathVariable("title") String serialTitle, @PathVariable("episode-num") int episodeNum) throws EpisodicMediaNotFoundException, EpisodeNotFoundException {
        return new ResponseEntity<>(mediaService.getEpisodeByNumber(serialTitle, episodeNum), HttpStatus.OK);
    }

    //searching the episodic media by language
    @GetMapping("/episodic-media/tv/{language}")
    @ApiOperation("Get episodic-media by language")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getEpisodicMediaByLanguage(@PathVariable("language") String language) throws EpisodicMediaNotFoundException {
        return new ResponseEntity<>(mediaService.getEpisodicByLanguage(language),HttpStatus.OK);
    }

    //searching the episodic media by category
    @GetMapping("/episodic-media/category/{category}")
    @ApiOperation("Get episode by category ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getEpisodicByCategory(@PathVariable("category") String category) throws EpisodicMediaNotFoundException {
        return new ResponseEntity<>(mediaService.getEpisodicMediaByCategory(category),HttpStatus.OK);
    }

    //deleting episodic media by title
    @DeleteMapping("/episodic-media/{title}")
    @ApiOperation("Delete episodic media")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> deleteEpisodicMedia(@PathVariable("title") String serialTitle) throws EpisodicMediaNotFoundException {
        return new ResponseEntity<>(mediaService.deleteEpisodicMedia(serialTitle),HttpStatus.OK);

    }

    //deleting episodic media by tiel an episode number
    @DeleteMapping("/episode/{title}/{episode-num}")
    @ApiOperation("Delete episode")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> deleteEpisode(@PathVariable("title") String serialTitle, @PathVariable("episode-num") int episodeNum) throws EpisodicMediaNotFoundException, EpisodeNotFoundException {
        return new ResponseEntity<>(mediaService.deleteEpisode(serialTitle, episodeNum),HttpStatus.OK);
    }

    //getting list of standalone media in wishlist
    @PatchMapping("/wish")
    @ApiOperation("Get media list ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getWishlist(@RequestBody List<String> titles) throws EpisodicMediaNotFoundException {
        return new ResponseEntity<>(mediaService.getListOfEpisodicMedia(titles),HttpStatus.OK);
    }
}
