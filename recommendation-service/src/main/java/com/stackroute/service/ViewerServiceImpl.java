package com.stackroute.service;

import com.stackroute.domain.Viewer;
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
    public Collection<Viewer> getAll() throws ViewerNotFoundException {
        if (viewerRepository.getAllViewers() == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.getAllViewers();
        }
    }

    //method to save viewer
    @CacheEvict(allEntries = true)
    public Viewer saveViewer(Viewer viewer) throws ViewerAlreadyExistException {
        if (viewerRepository.findByEmailId(viewer.getEmailId()) == null) {
            viewerRepository.createViewer(viewer.getName(), viewer.getEmailId());
            int length = viewer.getInterest().size();
            for (int i = 0; i < length; i++) {
                viewerRepository.createGenreRelation(viewer.getEmailId(), viewer.getInterest().get(i));
            }
        }
        else {
            throw new ViewerAlreadyExistException();
        }
        return viewer;
    }

    //method to get viewer by emailId
    @Cacheable
    public Viewer getViewerByEmailId(String emailId) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.findByEmailId(emailId);
        }
    }

    //method to update viewer details
    @CacheEvict(allEntries = true)
    public Viewer updateDetails(Viewer viewer) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(viewer.getEmailId()) == null) {
            throw new ViewerNotFoundException();
        } else {
            Viewer viewer1 = viewerRepository.findByEmailId(viewer.getEmailId());
            viewer1.setEmailId(viewer.getEmailId());
            viewer1.setInterest(viewer.getInterest());
            viewerRepository.save(viewer1);
            return viewer1;
        }
    }

    //method to delete viewer by emailId
    @CacheEvict(allEntries = true)
    public Collection<Viewer> deleteViewer(String emailId) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            Viewer viewer = viewerRepository.findByEmailId(emailId);
            viewerRepository.delete(viewer);
            return viewerRepository.getAllViewers();
        }
    }


    //method to save viewer and documentary relation
    @CacheEvict(allEntries = true)
    public Viewer saveDocumentaryRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createDocumentaryRelation(emailId, title);
        }
    }

    //method to save viewer and movie relation
    @CacheEvict(allEntries = true)
    public Viewer saveMovieRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createMovieRelation(emailId, title);
        }
    }

    //method to save viewer and TvEpisodes relation
    public Viewer saveTvEpisodesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createTvEpisodesRelation(emailId, title);
        }
    }

    //method to save viewer and WebSeries relation
    public Viewer saveWebSeriesRelation(String emailId, String title) throws ViewerNotFoundException {
        if (viewerRepository.findByEmailId(emailId) == null) {
            throw new ViewerNotFoundException();
        } else {
            return viewerRepository.createWebSeriesRelation(emailId, title);
        }
    }
}