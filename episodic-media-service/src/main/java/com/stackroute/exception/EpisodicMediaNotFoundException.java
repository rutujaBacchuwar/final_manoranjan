package com.stackroute.exception;

public class EpisodicMediaNotFoundException extends Exception {
    private final String message;

    public EpisodicMediaNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}

