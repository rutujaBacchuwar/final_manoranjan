package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerHandler {

    //password not match exception handler
    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<?> handlePasswordNotMatchException(PasswordNotMatchException e){
        return new ResponseEntity<>("Password Doesn't Match !", HttpStatus.NOT_FOUND);
    }

    //user already exists exception handler
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        return new ResponseEntity<>("User Already Exists !", HttpStatus.CONFLICT);
    }

    //user name not found exception handler
    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<?> handleUserNameNotFoundException(UserNameNotFoundException e){
        return new ResponseEntity<>("User Name Not Found !", HttpStatus.NOT_FOUND);
    }

    //username or password empty exception handler
    @ExceptionHandler(UserNameOrPasswordEmptyException.class)
    public ResponseEntity<?> handleUserNameOrPasswordEmptyException(UserNameOrPasswordEmptyException e){
        return new ResponseEntity<>("User Name/Password is Empty !", HttpStatus.NOT_FOUND);
    }

    //user name not found exception handler
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>("User Not Found !", HttpStatus.NOT_FOUND);
    }

}