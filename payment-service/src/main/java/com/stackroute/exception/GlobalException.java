package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
    @ExceptionHandler(EmailIdNotFoundException.class)
    public ResponseEntity<?> handleMediaNotFoundException(EmailIdNotFoundException mediaNotFound){
        return new ResponseEntity<String>("Email Id not found", HttpStatus.CONFLICT);
    }

}
