package com.stackroute.service;


import com.stackroute.domain.Producer;
import com.stackroute.exceptions.DataAlreadyExistException;
import com.stackroute.exceptions.ProducerAllReadyExistException;
import com.stackroute.exceptions.ProducerNotFoundException;
import com.stackroute.exceptions.UserNotFoundException;

import java.util.List;


public interface ProducerService {

    //save producer
    public Producer saveProducer(Producer producer) throws ProducerAllReadyExistException;

    //update particular producer
    public Producer updateProducer(String emailId, Producer producer);

    //get producer by their emailId
    public Producer getByEmailId(String emailId);

    //get uploaded standalone title
    public List<String> getUploadedStandaloneTitle(String emailId) throws ProducerNotFoundException;

    //get uploaded episodic title
    public List<String> getUploadedEpisodicTitle(String emailId)throws ProducerNotFoundException;

    //update uploaded standalone
    public List<String> updateUploadedStandalone(String emailId,String uploadedStandalone) throws ProducerNotFoundException, DataAlreadyExistException;

    //update uploaded episodic
    public List<String> updateUploadedEpisodic(String emailId,String uploadedEpisodic) throws ProducerNotFoundException, DataAlreadyExistException;

}

