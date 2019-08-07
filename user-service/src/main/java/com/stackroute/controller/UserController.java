package com.stackroute.controller;

import com.stackroute.domain.Producer;
import com.stackroute.domain.UserPayment;
import com.stackroute.exceptions.*;
import com.stackroute.domain.User;
import com.stackroute.service.ProducerService;
import com.stackroute.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "UseServiceApi",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(value = "*")
@RequestMapping(value = "api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProducerService producerService;

    //posting user details
    @ApiOperation(value = "save user")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAllReadyExistException {
        ResponseEntity responseEntity;
        userService.saveUser(user);
        responseEntity=new ResponseEntity<>("Successfully created", HttpStatus.OK);
        return responseEntity;
    }

    //posting producer details
    @ApiOperation(value = "save producer")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PostMapping("producer")
    public ResponseEntity<?> saveProducer(@RequestBody Producer producer) throws ProducerAllReadyExistException {
        ResponseEntity responseEntity;
        producerService.saveProducer(producer);
        responseEntity=new ResponseEntity<>("Successfully created", HttpStatus.OK);
        return responseEntity;
    }

    //posting user payment details
    @ApiOperation(value = "save user payment")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK"),@ApiResponse(code = 409,message = "CONFLICT")})
    @PostMapping("user-payment")
    public ResponseEntity<?> saveUser(@RequestBody UserPayment userPackage) {
        ResponseEntity responseEntity;
        try {
            userService.saveUserPayment(userPackage);
            responseEntity=new ResponseEntity<>("Successfully created", HttpStatus.OK);
        }

        catch(Exception e)
        {
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //fetching all the users
    @ApiOperation(value = "Get all users")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers()  {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    //fetchhing the user wishlist details by email
    @GetMapping("user/wish/standalone/{email}")
    public ResponseEntity<?> getStandaloneWishlist(@PathVariable("email") String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getStandaloneWishlist(emailId),HttpStatus.OK);

    }
    //fetchhing the user wishlist details by email
    @GetMapping("user/wish/episodic/{email}")
    public ResponseEntity<?> getEpisodicWishlist(@PathVariable("email") String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getEpisodicWishlist(emailId),HttpStatus.OK);

    }

    //fetching user history by email
    @ApiOperation(value = "Get history")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("user/history/standalone/{email}")
    public ResponseEntity<?> getStandaloneHistory(@PathVariable("email") String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getStandaloneHistory(emailId),HttpStatus.OK);
    }

    //fetching user history by email
    @ApiOperation(value = "Get history")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("user/history/episodic/{email}")
    public ResponseEntity<?> getEpisodicHistory(@PathVariable("email") String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getEpisodicHistory(emailId),HttpStatus.OK);
    }

    //add media to wishlist
    @ApiOperation(value = "Add media to wishlist")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/user/wish/episodic/{email}/{title}")
    public ResponseEntity<?> addToEpisodicWishlish(@PathVariable("email") String emailId,@PathVariable("title") String title) throws UserNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(userService.addToEpisodicWishlish(emailId, title),HttpStatus.OK);
    }

    //add media to wishlist
    @ApiOperation(value = "Add media to wishlist")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/user/wish/standalone/{email}/{title}")
    public ResponseEntity<?> addToStandaloneWishlish(@PathVariable("email") String emailId,@PathVariable("title") String title) throws UserNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(userService.addToStandaloneWishlish(emailId, title),HttpStatus.OK);
    }

    //add media to  history
    @ApiOperation(value = "Add media to history")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/user/history/standalone/{email}/{title}")
    public ResponseEntity<?> addToStandaloneHistory(@PathVariable("email") String emailId,@PathVariable("title") String title) throws UserNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(userService.addToStandaloneHistory(emailId, title),HttpStatus.OK);
    }

    //add media to  history
    @ApiOperation(value = "Add media to history")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/user/history/episodic/{email}/{title}")
    public ResponseEntity<?> addToEpisodicHistory(@PathVariable("email") String emailId,@PathVariable("title") String title) throws UserNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(userService.addToEpisodicHistory(emailId, title),HttpStatus.OK);
    }

    //fetching user by emailId
    @ApiOperation(value = "Get user by email")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("/users/{email}")
    public ResponseEntity<?> getById(@PathVariable("email") String emailId) throws UserNotFoundException {
        ResponseEntity responseEntity;
        User user=null;
        user=userService.getById(emailId);
        responseEntity=new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    //deleting user by email
    @ApiOperation(value = "Delete user by email")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String emailId) throws UserNotFoundException {
        ResponseEntity responseEntity;
        userService.deleteUser(emailId);
        responseEntity=new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        return responseEntity;
    }

    //updating user details by email
    @ApiOperation(value = "Update user")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@PathVariable("email") String emailId, @RequestBody User user) throws UserNotFoundException {
        ResponseEntity responseEntity;
        userService.updateUser(emailId,user);
        responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    //updating producer details by email
    @ApiOperation(value = "Update producer")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/producer/{email}")
    public ResponseEntity<?> updateProducer(@PathVariable("email") String emailId, @RequestBody Producer producer) {
        ResponseEntity responseEntity;
        producerService.updateProducer(emailId,producer);
        responseEntity = new ResponseEntity<>(producer, HttpStatus.OK);
        return responseEntity;
    }

    //fetching producer by emailId
    @ApiOperation(value = "Get producer by email")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("/producers/{email}")
    public ResponseEntity<?> getByEmailId(@PathVariable("email") String emailId) {
        ResponseEntity responseEntity;
        Producer producer=null;
        producer=producerService.getByEmailId(emailId);
        responseEntity=new ResponseEntity<>(producer, HttpStatus.OK);
        return responseEntity;
    }
    //fetching producer standalone title by email
    @ApiOperation(value = "Get standalone title")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("producer/standalone/{email}")
    public ResponseEntity<?> getUploadedStandaloneTitle(@PathVariable("email") String emailId) throws ProducerNotFoundException {
        return new ResponseEntity<>(producerService.getUploadedStandaloneTitle(emailId), HttpStatus.OK);
    }

    //fetching producer episodic title by email
    @ApiOperation(value = "Get episodic title")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @GetMapping("producer/episodic/{email}")
    public ResponseEntity<?> getUploadedEpisodicTitle(@PathVariable("email") String emailId) throws ProducerNotFoundException {
        return new ResponseEntity<>(producerService.getUploadedEpisodicTitle(emailId), HttpStatus.OK);
    }

    //add standalone to  standalone title
    @ApiOperation(value = "Add standalone to stanalone title")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/producer/standalone/{email}/{title}")
    public ResponseEntity<?> updateUploadedStandalone(@PathVariable("email") String emailId,@PathVariable("title") String title) throws ProducerNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(producerService.updateUploadedStandalone(emailId, title),HttpStatus.OK);
    }

    //add episodic to  episodic title
    @ApiOperation(value = "Add episodic to  episodic title")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PutMapping("/producer/episodic/{email}/{title}")
    public ResponseEntity<?> updateUploadedEpisodic(@PathVariable("email") String emailId,@PathVariable("title") String title) throws ProducerNotFoundException, DataAlreadyExistException {
        return new ResponseEntity<>(producerService.updateUploadedEpisodic(emailId, title),HttpStatus.OK);
    }
}
