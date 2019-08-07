package com.stackroute.exception;

public class EpisodeAlreadyExistsException extends Exception {

    private final String message;

    public EpisodeAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
