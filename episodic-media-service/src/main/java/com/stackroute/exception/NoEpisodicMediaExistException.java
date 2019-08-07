package com.stackroute.exception;

public class NoEpisodicMediaExistException extends Exception {

    private final String message;

    public NoEpisodicMediaExistException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
