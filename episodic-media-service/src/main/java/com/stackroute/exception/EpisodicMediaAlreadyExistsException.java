package com.stackroute.exception;

public class EpisodicMediaAlreadyExistsException extends Exception {
    private final String message;

    public EpisodicMediaAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}

