package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    //Added new viewer
    User saveUser(User user) throws UserAlreadyExistsException;

    // get all viewers
    List<User> getAllUsers() throws UserNotFoundException;

    //find viewer by id and password
    User findByEmailIdAndPassword(String emailId, String password);
}
