package com.stackroute.service;

import com.stackroute.domain.UserPayment;
import com.stackroute.exceptions.DataAlreadyExistException;
import com.stackroute.exceptions.UserAllReadyExistException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.repository.UserPaymentRepository;
import com.stackroute.repository.UserRepository;
import com.stackroute.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl(UserPaymentRepository userPaymentRepository) {
        this.userPaymentRepository = userPaymentRepository;
    }

    @Autowired
    KafkaTemplate<User, User> kafkaTemplate;

    private static String topic = "saveUser";

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //adding new user
    @CacheEvict(allEntries = true)
    @Override
    public User saveUser(User user) throws UserAllReadyExistException {
        if (userRepository.existsById(user.getEmailId())) {
            throw new UserAllReadyExistException();
        }
        User saveUser = userRepository.save(user);
        if (saveUser == null)
            throw new UserAllReadyExistException();

        kafkaTemplate.send(topic, user);
        return saveUser;
    }

    //fetching all the registered users
    @Cacheable
    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    //delete user by email
    @CacheEvict(allEntries = true)
    @Override
    public User deleteUser(String emailId) throws UserNotFoundException {
        User user = null;
        Optional optional = userRepository.findById(emailId);
        if (optional.isPresent()) {
            user = (User) optional.get();
            userRepository.deleteById(emailId);
        } else
            throw new UserNotFoundException();
        return user;
    }

    //updating user details by email
    @CacheEvict(allEntries = true)
    @Override
    public User updateUser(String emailId, User user) throws UserNotFoundException {
        User user1 = new User();
        if (userRepository.existsById(user.getEmailId())) {
            user1 = userRepository.findById(emailId).get();
            user1.setEmailId(user.getEmailId());
            user1.setName(user.getName());
            user1.setMobileNo(user.getMobileNo());
            user1.setAge(user.getAge());
            user1.setGenre(user.getGenre());
            user1.setHistoryEpisodic(user.getHistoryEpisodic());
            user1.setGender(user.getGender());
            user1.setHistoryStandalone(user.getHistoryStandalone());
            user1.setWishListEpisodic(user.getWishListEpisodic());
            user1.setWishListStandalone(user.getWishListStandalone());
            user1.setPassword(user.getPassword());
            userRepository.save(user1);
        }
        else
            throw new UserNotFoundException();
        return userRepository.save(user1);
    }

    //fetching user by email id
    @Cacheable
    @Override
    public User getById(String emailId) throws UserNotFoundException {
        User user;
        Optional optional = userRepository.findById(emailId);
        if (optional.isPresent()) {
            user = userRepository.findById(emailId).get();

        } else
            throw new UserNotFoundException();
        return user;
    }

    //getting all the wishlist elements by emailid
    @Cacheable
    @Override
    public List<String> getStandaloneWishlist(String emailId) throws UserNotFoundException {
        List<String> wish;
        List<String> wish2;
        if(userRepository.existsById(emailId)){
            User user = userRepository.findById(emailId).get();
            wish = user.getWishListStandalone();
            if (wish == null) {
                throw new UserNotFoundException();
            }
        }
        else throw new UserNotFoundException();
        return wish;
    }

    //getting all the wishlist elements by emailid
    @Cacheable
    @Override
    public List<String> getEpisodicWishlist(String emailId) throws UserNotFoundException {
        List<String> wish;
        List<String> wish2;
        if(userRepository.existsById(emailId)){
            User user = userRepository.findById(emailId).get();
            wish=user.getWishListEpisodic();
            if (wish == null) {
                throw new UserNotFoundException();
            }
        }
        else throw new UserNotFoundException();
        return wish;
    }

    //fetching the history by emailId
    @Cacheable
    @Override
    public List<String> getStandaloneHistory(String emailId) throws UserNotFoundException {
        List<String> history;
        if(userRepository.existsById(emailId)){
            User user = userRepository.findById(emailId).get();
            history = user.getHistoryStandalone();
            if (history == null) {
                throw new UserNotFoundException();
            }
        }
        else throw new UserNotFoundException();
        return history;
    }

    //fetching the history by emailId
    @Cacheable
    @Override
    public List<String> getEpisodicHistory(String emailId) throws UserNotFoundException {
        List<String> history;
        if(userRepository.existsById(emailId)){
            User user = userRepository.findById(emailId).get();
            history=user.getHistoryEpisodic();
            if (history == null) {
                throw new UserNotFoundException();
            }
        }
        else throw new UserNotFoundException();
        return history;
    }

    //add to wishlist
    @CacheEvict(allEntries = true)
    @Override
    public List<String> addToStandaloneWishlish(String emailId, String title) throws UserNotFoundException, DataAlreadyExistException {
        User user;
        List<String> wishlist;
        if(userRepository.existsById(emailId)){
            user=userRepository.findById(emailId).get();
            if(user.getWishListStandalone().contains(title)){
                throw new DataAlreadyExistException();
            }
            wishlist=user.getWishListStandalone();
            wishlist.add(title);
            user.setWishListStandalone(wishlist);
            userRepository.save(user);
        }
        else throw new UserNotFoundException();
        return wishlist;
    }

    //add to wishlist
    @CacheEvict(allEntries = true)
    @Override
    public List<String> addToEpisodicWishlish(String emailId, String title) throws UserNotFoundException, DataAlreadyExistException {
        User user;
        List<String> wishlist;
        if(userRepository.existsById(emailId)){
            user=userRepository.findById(emailId).get();
            if(user.getWishListEpisodic().contains(title)){
                throw new DataAlreadyExistException();
            }
            wishlist=user.getWishListEpisodic();
            wishlist.add(title);
            user.setWishListEpisodic(wishlist);
            userRepository.save(user);
        }
        else throw new UserNotFoundException();
        return wishlist;
    }


    //add to history
    @CacheEvict(allEntries = true)
    @Override
    public List<String> addToStandaloneHistory(String emailId, String title) throws UserNotFoundException, DataAlreadyExistException {
        User user;
        List<String> history;
        if(userRepository.existsById(emailId)){
            user=userRepository.findById(emailId).get();
            if(user.getWishListEpisodic().contains(title)){
                throw new DataAlreadyExistException();
            }
            history=user.getHistoryStandalone();
            history.add(title);
            user.setHistoryStandalone(history);
            userRepository.save(user);
        }
        else throw new UserNotFoundException();
        return history;
    }

    //add to history
    @CacheEvict(allEntries = true)
    @Override
    public List<String> addToEpisodicHistory(String emailId, String title) throws UserNotFoundException, DataAlreadyExistException {
        User user;
        List<String> history;
        if(userRepository.existsById(emailId)){
            user=userRepository.findById(emailId).get();
            if(user.getWishListEpisodic().contains(title)){
                throw new DataAlreadyExistException();
            }
            history=user.getHistoryEpisodic();
            history.add(title);
            user.setHistoryEpisodic(history);
            userRepository.save(user);
        }
        else throw new UserNotFoundException();
        return history;
    }

    @Override
    @KafkaListener(topics = "savedUser",groupId = "Group_JsonObject")
    public UserPayment saveUserPayment(UserPayment userPayment) {
        UserPayment saveUser =  userPaymentRepository.save(userPayment);
        return saveUser;

    }
}
