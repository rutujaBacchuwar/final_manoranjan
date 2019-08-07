package com.stackroute.service;

import com.stackroute.domain.Viewer;
import com.stackroute.exception.ViewerAlreadyExistException;
import com.stackroute.exception.ViewerNotFoundException;
import java.util.Collection;

public interface ViewerService {

    public Collection<Viewer> getAll() throws ViewerNotFoundException;

    public Viewer saveViewer(Viewer viewer) throws ViewerAlreadyExistException;

    public Viewer getViewerByEmailId(String emailId) throws ViewerNotFoundException;

    public Viewer updateDetails(Viewer viewer) throws ViewerNotFoundException;

    public Collection<Viewer> deleteViewer(String emailId) throws ViewerNotFoundException;

    public Viewer saveDocumentaryRelation(String emailId, String title) throws ViewerNotFoundException;

    public Viewer saveMovieRelation(String emailId, String title) throws ViewerNotFoundException;

    public Viewer saveTvEpisodesRelation(String emailId, String title) throws ViewerNotFoundException;

    public Viewer saveWebSeriesRelation(String emailId, String title) throws ViewerNotFoundException;

}
