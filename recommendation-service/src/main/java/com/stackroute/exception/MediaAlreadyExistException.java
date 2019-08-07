package com.stackroute.exception;

public class MediaAlreadyExistException extends Exception {
    private String message1;

    public MediaAlreadyExistException() {
    }

    //media already exists exception handler method
    public MediaAlreadyExistException(String message) {
        super(message);
        this.message1 = message;
    }
}
