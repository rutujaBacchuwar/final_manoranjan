package com.stackroute.controller;

import com.stackroute.domain.StandaloneMedia;
import com.stackroute.exception.FileNotUploadedException;
import com.stackroute.exception.MediaAlreadyExistsException;
import com.stackroute.exception.MediaNotFoundException;
import com.stackroute.service.StandaloneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "StandaloneMediaControllerApi",produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/stream/v1")
@CrossOrigin("*")
public class StandaloneController {

    @Autowired
    private StandaloneService mediaService;

    //posting standalone media
    @PostMapping("/media")
    @ApiOperation("Save media")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = StandaloneMedia.class)})
    public ResponseEntity<?> saveMedia(@RequestBody StandaloneMedia media) throws MediaAlreadyExistsException {
        StandaloneMedia media1;
        media1=mediaService.saveMedia(media);
        return new ResponseEntity<>(media1, HttpStatus.OK);
    }

    //getting all the standalone media
    @GetMapping("/medias")
    @ApiOperation("Get all medias ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getAllMedias() throws MediaNotFoundException {
        List<StandaloneMedia> mediaList;
        mediaList=mediaService.getAllMedia();
        return new ResponseEntity<>(mediaList,HttpStatus.OK);
    }

    //searching single standalone media by title
    @GetMapping("/media/{title}")
    @ApiOperation("Get media by id ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getMediaById(@PathVariable("title") String mediaTitle) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.getMediaById(mediaTitle),HttpStatus.OK);
    }

    //searching the standalone media by genre
    @GetMapping("/media/movie/{genre}")
    @ApiOperation("Get media by genre ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getMediaByGenre(@PathVariable("genre") String genre) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.getMediaByGenre(genre),HttpStatus.OK);
    }

    //searching the standalone media by category
    @GetMapping("/media/category/{category}")
    @ApiOperation("Get medias of spacific category ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getSpecificCategoryMedia(@PathVariable("category") String category) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.getMediaByCategory(category),HttpStatus.OK);
    }

    //displaying all the standalone media
    @PatchMapping("/wish")
    @ApiOperation("Get media list")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> getWishlist(@RequestBody List<String> titles) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.getWishlist(titles),HttpStatus.OK);
    }

    //deleting standalone media by title
    @DeleteMapping("/media/{title}")
    @ApiOperation("Delete media")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<?> deleteMedia(@PathVariable("title") String mediaTitle) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.deleteMedia(mediaTitle),HttpStatus.OK);
    }

    List<String> files = new ArrayList<>();

    //uploading files
//    @PostMapping("/post")
//    @ApiOperation("handle file upload")
//    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
//    public ResponseEntity<String> handleFileUpload(HttpServletRequest request) {
//
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        CommonsMultipartFile file =  null;
//
//        Iterator<String> iterator = multipartRequest.getFileNames();
//
//        while (iterator.hasNext()) {
//            String key = (String) iterator.next();
//            file = (CommonsMultipartFile) multipartRequest.getFile(key);
//        }
//
//
//        System.out.println("In controller method");
//        String message = "";
//        try {
//            mediaService.store(file);
//            System.out.println("after service");
//            files.add(file.getOriginalFilename());
//
//            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
//
//            System.out.println("uctwdfig"+message);
//            return ResponseEntity.status(HttpStatus.OK).body(message);
//        } catch (Exception e) {
//            message = "FAIL to upload " + file.getOriginalFilename() + "!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//        }
//    }

    //uploading files
    @PostMapping("/post")
    @ApiOperation("handle file upload")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        String message="";
        try{
            mediaService.store(file);
            files.add(file.getOriginalFilename());
            message="success"+file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            message="FAIL"+file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @GetMapping("/getallfiles")
    @ApiOperation("Get list of files ")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    public ResponseEntity<List<String>> getListFiles(Model model) {
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(StandaloneController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(fileNames);
    }

    //searching file by filenames
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws FileNotUploadedException {
        Resource file = mediaService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
