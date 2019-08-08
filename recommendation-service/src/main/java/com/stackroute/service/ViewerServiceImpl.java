package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.ViewerAlreadyExistException;
import com.stackroute.exception.ViewerNotFoundException;
import com.stackroute.repository.GenreRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@CacheConfig(cacheNames = "viewer")
@Service
public class ViewerServiceImpl implements ViewerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenreRepository genreRepository;

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method to get all viewers
    @Cacheable
    public Collection<User> getAll() throws ViewerNotFoundException {
        if (userRepository.getAllUsers() == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.getAllUsers();
        }
    }

    //method to save viewer
    @CacheEvict(allEntries = true)
    public User saveViewer(User user) throws ViewerAlreadyExistException {
        if (userRepository.findByEmailId(user.getEmailId()) == null) {
            userRepository.createUser(user.getName(), user.getEmailId());
            int length = user.getGenre().size();
            for (int i = 0; i < length; i++) {
                userRepository.createGenreRelation(user.getEmailId(), user.getGenre().get(i));
            }
        }
        else {
            throw new ViewerAlreadyExistException();
        }
        return user;
    }

    //method to get viewer by emailId
    @Cacheable
    public User getViewerByEmailId(String emailId) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.findByEmailId(emailId);
        }
    }

    //method to update viewer details
    @CacheEvict(allEntries = true)
    public User updateDetails(User user) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(user.getEmailId()) == null) {
            throw new ViewerNotFoundException();
        } else {
            User user1 = userRepository.findByEmailId(user.getEmailId());
            user1.setEmailId(user.getEmailId());
            user1.setGenre(user.getGenre());
            userRepository.save(user1);
            return user1;
        }
    }

    //method to delete viewer by emailId
    @CacheEvict(allEntries = true)
    public Collection<User> deleteViewer(String emailId) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            User user = userRepository.findByEmailId(emailId);
            userRepository.delete(user);
            return userRepository.getAllUsers();
        }
    }


    //method to save viewer and documentary relation
    @CacheEvict(allEntries = true)
    public User saveDocumentaryRelation(String emailId, String title) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.createDocumentaryRelation(emailId, title);
        }
    }

    //method to save viewer and movie relation
    @CacheEvict(allEntries = true)
    public User saveMovieRelation(String emailId, String title) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.createMovieRelation(emailId, title);
        }
    }

    //method to save viewer and TvEpisodes relation
    public User saveTvEpisodesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.createTvEpisodesRelation(emailId, title);
        }
    }

    //method to save viewer and WebSeries relation
    public User saveWebSeriesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (userRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return userRepository.createWebSeriesRelation(emailId, title);
        }
    }
}