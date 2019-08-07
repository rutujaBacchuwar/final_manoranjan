package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exception.*;
import com.stackroute.jwt.SecurityTokenGenerator;
import com.stackroute.service.UserService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Api(value = "UserAuthenticationServiceApi",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(value = "*")
@RequestMapping("api/v1")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //posting the user login details and generating token
    @ApiOperation(value = "Accept user into repository and generating token")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK")})
    @PostMapping("/user")
    public ResponseEntity<?> login(@RequestBody User loginDetails) throws UserNameOrPasswordEmptyException, UserNameNotFoundException, PasswordNotMatchException {

        String username = loginDetails.getEmailId();
        String password = loginDetails.getPassword();
        if (username == null || password == null) {
            throw new UserNameOrPasswordEmptyException();
        }

        User user = userService.findByEmailIdAndPassword(username, password);

        if (user == null) {
            throw new UserNameNotFoundException();
        }

        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new PasswordNotMatchException();
        }

        // generating token

        SecurityTokenGenerator securityTokenGenrator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId("" + user.getEmailId()).setSubject(user.getRole()).setAudience(user.getEmailId()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();
            map1.put("token", jwtToken);
            map1.put("message", user.getRole());
            return map1;
        };
        Map<String, String> map = securityTokenGenrator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    //fetching all the users
    @ApiOperation(value = "Gets all the user details(username,password,role)")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Ok")})
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() throws UserNotFoundException
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //posting the user details
    @ApiOperation(value = "It saves all the user details")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Ok")})
    @PostMapping("/users/user")
    public ResponseEntity<?> saveEvent(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}