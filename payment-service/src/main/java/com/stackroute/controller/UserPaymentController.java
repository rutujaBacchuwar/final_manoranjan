package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.domain.UserPayment;
import com.stackroute.exception.EmailIdNotFoundException;
import com.stackroute.service.UserPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "PaymentServiceApi",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(value = "*")
@RequestMapping(value = "api/v1")
public class UserPaymentController {

    private UserPaymentService userPackageService;

    public UserPaymentController(UserPaymentService userPackageService) {
        this.userPackageService = userPackageService;
    }

    //posting the data in to the database

    @ApiOperation("Save user payment")
    @ApiResponses(value = {@ApiResponse(code = 201,message = "CREATED"),@ApiResponse(code = 409,message = "CONFLICT")})
    @PostMapping("user")
    public ResponseEntity<String> saveUser(@RequestBody UserPayment userPayment) throws EmailIdNotFoundException {
        ResponseEntity responseEntity;

        try {
            userPackageService.saveUserPayment(userPayment);
            responseEntity = new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

            return responseEntity;
        }
        return responseEntity;
    }

   //save user
    @ApiOperation("Save user")
    @ApiResponses(value = {@ApiResponse(code = 201,message = "CREATED"),@ApiResponse(code = 409,message = "CONFLICT")})
    @PostMapping("user-email")
    public ResponseEntity<String> saveUser(User user)
    {
        ResponseEntity responseEntity;
        try {
            userPackageService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
