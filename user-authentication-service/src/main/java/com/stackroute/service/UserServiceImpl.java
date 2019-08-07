package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    private User user;

    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.userRepo = repo;
    }

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //finding user by emailId and password
    @Cacheable
    @Override
    public User findByEmailIdAndPassword(String emailId, String password) {
        return userRepo.findByEmailIdAndPassword(emailId, password);
    }


    //consuming user details from user-service using kafka
    @Override
    @KafkaListener(topics = "saveUser", groupId = "Group_JsonObject")
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (userRepo.existsByEmailId(user.getEmailId())) {
            throw new UserAlreadyExistsException();
        } else
            return userRepo.save(user);
    }

    //getting all the users
    @Cacheable
    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        return userRepo.findAll();
    }

}