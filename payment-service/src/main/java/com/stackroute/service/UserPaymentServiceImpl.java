package com.stackroute.service;

import com.stackroute.domain.UserPayment;
import com.stackroute.exception.EmailIdNotFoundException;
import com.stackroute.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "payment")
@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    UserPayment userPayment = null;
    UserPaymentRepository userPaymentRepository;

    @Autowired
    UserRepository userRepository;

    public UserPaymentServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserPaymentServiceImpl(UserPaymentRepository userPaymentRepository) {
        this.userPaymentRepository = userPaymentRepository;
    }

    @Autowired
    KafkaTemplate<UserPayment, UserPayment> kafkaTemplate;

    private static String topic = "savedUser";

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @CacheEvict(allEntries = true)
    @Override//saving user package details
    public UserPayment saveUserPayment(UserPayment userPayment) throws EmailIdNotFoundException {
            UserPayment saveUser = userPaymentRepository.save(userPayment);
            kafkaTemplate.send(topic, saveUser);
            return saveUser;

    }

    @Cacheable
    @Override//getting all users who have subscribed for the packages
    public List<UserPayment> getAllUsers() {

        return userPaymentRepository.findAll();
    }

    @CacheEvict(allEntries = true)
    @Override //deleting the user
    public UserPayment deleteUser(String emailId) {
        userPayment = null;
        Optional optional = userPaymentRepository.findById(emailId);
        if (optional.isPresent()) {
            userPaymentRepository.deleteById(emailId);
        }
        return userPayment;
    }

    @Override
    //consuming the user details from user service
    @KafkaListener(topics = "saveUser",groupId = "Group_JsonObject1")
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
