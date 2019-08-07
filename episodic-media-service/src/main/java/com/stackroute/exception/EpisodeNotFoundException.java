package com.stackroute.exception;

public class EpisodeNotFoundException extends Exception {

    private final String message;

    public EpisodeNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
