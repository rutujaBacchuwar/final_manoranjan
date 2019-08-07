package com.stackroute.repository;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user, user1;

    @Before
    public void setUp() {
        user = new User();
        user1 = new User();
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

        user1.setEmailId("a@gmail.com");
        user1.setName("Pooja");
        user1.setAge(26);
        user1.setGender("female");
        user1.setMobileNo("9284519219");
        user1.setPassword("Pooja@110");
        List<String> genre1 = new ArrayList<String>();
        genre1.add("action");
        genre1.add("horror");
        user1.setGenre(genre);
        user1.setRole("user");
    }

    @After
    public void tearDown() {

        userRepository.deleteAll();
    }

    //testcase for get all users failure
    @Test
    public void getAllUsersFailureTest() {
        userRepository.save(user);
        List<User> list = userRepository.findAll();
        System.out.println(list);
        Assert.assertNotEquals("a@gmail.com", list.get(0).getEmailId());
    }

    //testcase for save user
    @Test
    public void saveUserTest() {
        userRepository.save(user);
        Assert.assertEquals("p@gmail.com",user.getEmailId());
    }

    //testcase for save user failure
    @Test
    public void saveUserFailureTest() {
        userRepository.save(user);
        Assert.assertNotEquals("a@gmail.com",user.getEmailId());

    }

    //testcase for delete user
    @Test
    public void deleteUserTest() {
        userRepository.save(user);
        userRepository.save(user1);
        userRepository.delete(user);
        List<User> list = userRepository.findAll();
        Assert.assertEquals("a@gmail.com", list.get(0).getEmailId());
    }

    //testcase for delete user failure
    @Test
    public void deleteUserFailureTest() {
        userRepository.save(user);
        userRepository.save(user1);
        userRepository.delete(user1);
        List<User> list = userRepository.findAll();
        Assert.assertNotEquals("a@gmail.com", list.get(0).getEmailId());
    }

    //testcase for get by name
    @Test
    public void getByNameTest() throws UserNotFoundException {
        userRepository.save(user);
        userRepository.save(user1);
        User t3 = userRepository.findById("a@gmail.com").get();
        Assert.assertEquals(user1, t3);
    }

    //testcase for delete name failure
    @Test
    public void getByNameFailureTest() throws UserNotFoundException {
        userRepository.save(user);
        userRepository.save(user1);
        Assert.assertNotEquals(user.getEmailId(), "u@gmail.com");
    }
}
