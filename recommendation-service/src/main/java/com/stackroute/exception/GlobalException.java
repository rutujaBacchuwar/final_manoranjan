package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    //media already exists exception handler
    @ExceptionHandler(value = MediaAlreadyExistException.class)
    public ResponseEntity<String> exceptionHandler(MediaAlreadyExistException e) {
        return new ResponseEntity<String>("Error occurred: Media Already Exists" + e.getMessage(), HttpStatus.CONFLICT);
    }

    //media not found exception haqndler
    @ExceptionHandler(value = MediaNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(MediaNotFoundException e) {
        return new ResponseEntity<String>("Error occurred: Media Not Found" + e.getMessage(), HttpStatus.CONFLICT);
    }

    //viewer already exists exception handler
    @ExceptionHandler(value = ViewerAlreadyExistException.class)
    public ResponseEntity<String> exceptionHandler(ViewerAlreadyExistException e) {
        return new ResponseEntity<String>("Error occurred: Viewer Already Exists" + e.getMessage(), HttpStatus.CONFLICT);
    }

    //viewer not found exception handler
    @ExceptionHandler(value = ViewerNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(ViewerNotFoundException e) {
        return new ResponseEntity<String>("Error occurred: Viewer Not Found" + e.getMessage(), HttpStatus.CONFLICT);
    }

    //language not found exception handler
    @ExceptionHandler(value = LanguageNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(LanguageNotFoundException e) {
        return new ResponseEntity<String>("Error occurred: Language Not Found" + e.getMessage(), HttpStatus.CONFLICT);
    }

    //genre not found exception handler
    @ExceptionHandler(value = GenreNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(GenreNotFoundException e) {
        return new ResponseEntity<String>("Error occurred: Genre Not Found" + e.getMessage(), HttpStatus.CONFLICT);
    }
}
