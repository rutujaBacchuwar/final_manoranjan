package com.stackroute.service;

import com.stackroute.domain.UserPayment;
import com.stackroute.exceptions.DataAlreadyExistException;
import com.stackroute.exceptions.UserAllReadyExistException;
import com.stackroute.domain.User;
import com.stackroute.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    //save user
    public User saveUser(User user) throws UserAllReadyExistException;

    //display list of all user
    public List<User> getAllUsers();
    //delete particular user
    public User deleteUser(String emailId) throws UserNotFoundException;

    //update particular user
    public User updateUser(String emailId, User user) throws UserNotFoundException;

    //get user by their emailId
    public User getById(String emailId) throws UserNotFoundException;

    //get all wishlist
    public List<String> getStandaloneWishlist(String emailId) throws UserNotFoundException;

    public List<String> getEpisodicWishlist(String emailId) throws UserNotFoundException;

    //get all history
    public List<String> getStandaloneHistory(String emailId) throws UserNotFoundException;
    public List<String> getEpisodicHistory(String emailId) throws UserNotFoundException;

    public List<String> addToStandaloneWishlish(String emailId,String title) throws UserNotFoundException, DataAlreadyExistException;
    public List<String> addToEpisodicWishlish(String emailId,String title) throws UserNotFoundException, DataAlreadyExistException;

    public List<String> addToStandaloneHistory(String emailId,String title) throws UserNotFoundException, DataAlreadyExistException;
    public List<String> addToEpisodicHistory(String emailId,String title) throws UserNotFoundException, DataAlreadyExistException;
    //cosuming userservice through KAFKA
    public UserPayment saveUserPayment(UserPayment userPayment);

}
