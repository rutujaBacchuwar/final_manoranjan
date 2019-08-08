package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.ViewerAlreadyExistException;
import com.stackroute.exception.ViewerNotFoundException;
import com.stackroute.repository.GenreRepository;
import com.stackroute.repository.ViewerRepository;
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
    private ViewerRepository viewerRepository;

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
        if (viewerRepository.getAllViewers() == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.getAllViewers();
        }
    }

    //method to save viewer
    @CacheEvict(allEntries = true)
    public User saveViewer(User user) throws ViewerAlreadyExistException {
        if (viewerRepository.findByEmailId(user.getEmailId()) == null) {
            viewerRepository.createViewer(user.getName(), user.getEmailId());
            int length = user.getGenre().size();
            for (int i = 0; i < length; i++) {
                viewerRepository.createGenreRelation(user.getEmailId(), user.getGenre().get(i));
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
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.findByEmailId(emailId);
        }
    }

    //method to update viewer details
    @CacheEvict(allEntries = true)
    public User updateDetails(User user) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(user.getEmailId()) == null) {
            throw new ViewerNotFoundException();
        } else {
            User user1 = viewerRepository.findByEmailId(user.getEmailId());
            user1.setEmailId(user.getEmailId());
            user1.setGenre(user.getGenre());
            viewerRepository.save(user1);
            return user1;
        }
    }

    //method to delete viewer by emailId
    @CacheEvict(allEntries = true)
    public Collection<User> deleteViewer(String emailId) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            User user = viewerRepository.findByEmailId(emailId);
            viewerRepository.delete(user);
            return viewerRepository.getAllViewers();
        }
    }


    //method to save viewer and documentary relation
    @CacheEvict(allEntries = true)
    public User saveDocumentaryRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createDocumentaryRelation(emailId, title);
        }
    }

    //method to save viewer and movie relation
    @CacheEvict(allEntries = true)
    public User saveMovieRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createMovieRelation(emailId, title);
        }
    }

    //method to save viewer and TvEpisodes relation
    public User saveTvEpisodesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createTvEpisodesRelation(emailId, title);
        }
    }

    //method to save viewer and WebSeries relation
    public User saveWebSeriesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createWebSeriesRelation(emailId, title);
        }
    }
}