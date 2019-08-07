package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.domain.UserPayment;
import com.stackroute.exception.EmailIdNotFoundException;

import java.util.List;

public interface UserPaymentService {

    //saving user package details
    public UserPayment saveUserPayment(UserPayment userPackage) throws EmailIdNotFoundException;
    //getting all users who have subscribed for the packages
    public List<UserPayment> getAllUsers();
    //deleting the users based on email Id
    public UserPayment deleteUser(String emailId);
    //consuming the user details from user service
    public User saveUser(User user);
}
