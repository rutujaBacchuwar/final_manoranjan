package com.stackroute.service;

import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.FileNotUploadedException;
import com.stackroute.exception.MediaAlreadyExistsException;
import com.stackroute.exception.MediaNotFoundException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.List;

public interface StandaloneService {

    //getting all the standalone media
    public List<StandaloneMedia> getAllMedia() throws MediaNotFoundException;

    //getting the standalone media by mediaTitle
    public StandaloneMedia getMediaById(String mediaTitle) throws MediaNotFoundException;

    //added new standalone media
    public StandaloneMedia saveMedia(StandaloneMedia media) throws MediaAlreadyExistsException;

    //deleting media by media Title
    public StandaloneMedia deleteMedia(String mediaTitle) throws MediaNotFoundException;

    //fetching standalone media details by genre
    public List<StandaloneMedia> getMediaByGenre(String Genre) throws MediaNotFoundException;

    //fetching standalone media by category
    public List<StandaloneMedia> getMediaByCategory(String category) throws MediaNotFoundException;

    //feching list of standalone media in wishlist
    public List<StandaloneMedia> getWishlist(List<String> titles) throws MediaNotFoundException;

    //adding file to a directory
    public void store(MultipartFile file) throws FileNotUploadedException;

    //loading resource file
    public Resource loadFile(String filename) throws FileNotUploadedException;

    //deleting all files from directory
    public void deleteAll();

    //initializing
    public void init() throws FileNotUploadedException;

}
