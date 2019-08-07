package com.stackroute.exception;

public class ViewerAlreadyExistException extends Exception {
    private String message1;

    public ViewerAlreadyExistException() {
    }

    //viewer already exists exception handler method
    public ViewerAlreadyExistException(String message) {
        super(message);
        this.message1 = message;
    }
}
