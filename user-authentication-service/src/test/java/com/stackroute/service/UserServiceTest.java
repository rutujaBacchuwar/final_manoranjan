package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private User user;

    //Create a mock for UserRepository
    @Mock
    private UserRepository userRepository;

    @Mock
    KafkaTemplate<User, User> kafkaTemplate;

    private static String topic = "saveUser";

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private UserServiceImpl userService;
    List<User> list = null;

    private Optional optional;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setEmailId("p@gmail.com");
        user.setPassword("Pooja@110");
        user.setRole("user");
        list = new ArrayList<>();
        list.add(user);
        optional = Optional.of(user);
    }

    @After
    public void teardown() {
        optional = null;
    }

    //testcase for save user
    @Test
    public void saveUserTest() throws UserAlreadyExistsException {
        when(userRepository.save((User) any())).thenReturn(user);
//        kafkaTemplate.send(topic,user);
        User savedUser = userService.saveUser(user);
        Assert.assertEquals(user, savedUser);
        System.out.println("savedUser" + savedUser);
        verify(userRepository, times(1)).save(user);

    }

    //testcase for get all users
    @Test
    public void getAllUsersTest() throws UserNotFoundException {
        userRepository.save(user);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<User> userlist = userService.getAllUsers();
        Assert.assertEquals(list, userlist);
    }
}
