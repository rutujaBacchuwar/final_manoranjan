package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EpisodicControllerHandler {
    //media not found exception handler
    @ExceptionHandler(EpisodicMediaNotFoundException.class)
    public ResponseEntity<?> handleMediaNotFoundException(EpisodicMediaNotFoundException mediaNotFound){
        return new ResponseEntity<>("Episodic media not found", HttpStatus.CONFLICT);
    }

    //media already exists exception handler
    @ExceptionHandler(EpisodicMediaAlreadyExistsException.class)
    public ResponseEntity<?> handleMediaAlreadyExistsException(EpisodicMediaAlreadyExistsException mediaAlreadyExists){
        return new ResponseEntity<>("Episodic media already exists",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoEpisodicMediaExistException.class)
    public ResponseEntity<?> handleNoEpisodicMediaExistsException(NoEpisodicMediaExistException noMediaExist){
        return new ResponseEntity<>("No episodic media exists",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EpisodeAlreadyExistsException.class)
    public ResponseEntity<?> handleEpisodeAlreadyExistsException(EpisodeAlreadyExistsException episodeAlreadyExist){
        return new ResponseEntity<>("Episode already exists",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EpisodeNotFoundException.class)
    public ResponseEntity<?> handleEpisodeNotFoundException(EpisodeNotFoundException episodeNotFound){
        return new ResponseEntity<>("Episode not found",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoEpisodeExistException.class)
    public ResponseEntity<?> handleNoEpisodeExistException(NoEpisodeExistException noEpisodeExist){
        return new ResponseEntity<>("No episode exist",HttpStatus.CONFLICT);
    }


    //global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        return new ResponseEntity<>("Exception Occured", HttpStatus.CONFLICT);
    }
}
