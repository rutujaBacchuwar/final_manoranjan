package com.stackroute.exception;

public class ViewerNotFoundException extends Exception {
    private String message1;

    public ViewerNotFoundException() {
    }

    //viewer not found exception handler method
    public ViewerNotFoundException(String message) {
        super(message);
        this.message1 = message;
    }
}
