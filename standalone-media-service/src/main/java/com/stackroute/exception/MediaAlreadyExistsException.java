package com.stackroute.exception;

public class MediaAlreadyExistsException extends Exception {
    private final String message;

    public MediaAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}