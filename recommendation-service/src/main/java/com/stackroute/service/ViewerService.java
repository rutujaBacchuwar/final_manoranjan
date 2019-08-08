package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.ViewerAlreadyExistException;
import com.stackroute.exception.ViewerNotFoundException;
import java.util.Collection;

public interface ViewerService {

    public Collection<User> getAll() throws ViewerNotFoundException;

    public User saveViewer(User user) throws ViewerAlreadyExistException;

    public User getViewerByEmailId(String emailId) throws ViewerNotFoundException;

    public User updateDetails(User user) throws ViewerNotFoundException;

    public Collection<User> deleteViewer(String emailId) throws ViewerNotFoundException;

    public User saveDocumentaryRelation(String emailId, String title) throws ViewerNotFoundException;

    public User saveMovieRelation(String emailId, String title) throws ViewerNotFoundException;

    public User saveTvEpisodesRelation(String emailId, String title) throws ViewerNotFoundException;

    public User saveWebSeriesRelation(String emailId, String title) throws ViewerNotFoundException;

}
