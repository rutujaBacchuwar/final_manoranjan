package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAllReadyExistException;
import com.stackroute.exceptions.UserNotFoundException;
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
        user.setName("Pooja");
        user.setAge(26);
        user.setGender("female");
        user.setMobileNo("9284519219");
        user.setPassword("Pooja@110");
        List<String> genre = new ArrayList<String>();
        genre.add("action");
        genre.add("horror");
        user.setGenre(genre);
        user.setRole("user");
        list = new ArrayList<>();
        list.add(user);
        optional = Optional.of(user);
    }

    @After
    public void teardown() {
        optional = null;
    }

    //testcase for get all users
    @Test
    public void getAllUsers() throws UserNotFoundException {
        userRepository.save(user);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<User> userlist = userService.getAllUsers();
        Assert.assertEquals(list, userlist);
    }
    //testcase for get by id
    @Test
    public void getByIdTest() throws UserNotFoundException {
        when(userRepository.findById(user.getEmailId())).thenReturn(optional);
        User t = userService.getById(user.getEmailId());
        Assert.assertEquals("p@gmail.com", t.getEmailId());
    }

    //testcase for get by id failure
    @Test(expected = UserNotFoundException.class)
    public void getByIdFailureTest() throws UserNotFoundException {
        when(userRepository.findById("a@gmail.com")).thenReturn(optional);
        User t = userService.getById(user.getEmailId());
        Assert.assertNotEquals("a@gmail.com", t.getEmailId());
        ;
    }
}
