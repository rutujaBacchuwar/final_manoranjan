package com.stackroute.repository;


import com.stackroute.domain.UserPayment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserPaymentRepositoryTest {

    @Autowired
    private UserPaymentRepository userPaymentRepository;
    private UserPayment userPayment;
    Date date = new java.util.Date();

    @Before
    public void setUp() {
        userPayment = new UserPayment();
        userPayment.setEmailId("an@gmail.com");
        userPayment.setPackageName("180days");
        Date date = new java.util.Date();
        userPayment.setMydate(date);
    }

    @After
    public void tearDown() {
        userPaymentRepository.deleteAll();
    }

    @Test
    //repository for saving the user package details
    public void testSaveUser() {

        UserPayment userPayment = new UserPayment("an@gmail.com", "90days", date);
        UserPayment userPayment1 = new UserPayment("an@gmail.com", "90days", date);
        userPaymentRepository.save(userPayment1);
        Assert.assertEquals(userPayment, userPayment1);
    }

    @Test
    //failure testcase in repository for saving the user package details
    public void testSaveUserFailure() {

        UserPayment userPayment = new UserPayment("an@gmail.com", "90days", date);
        UserPayment userPayment1 = new UserPayment("anu@gmail.com", "90days", date);
        userPaymentRepository.save(userPayment1);
        Assert.assertNotEquals(userPayment, userPayment1);
    }

    @Test
    //testcase for getting all the users
    public void testGetAllUser() {
        UserPayment userPayment = new UserPayment("one@gmail.com", "90days", date);
        UserPayment userPayment1 = new UserPayment("two@gmail.com", "180days", date);
        userPaymentRepository.save(userPayment);
        userPaymentRepository.save(userPayment1);
        List<UserPayment> list = userPaymentRepository.findAll();
        Assert.assertEquals("one@gmail.com", list.get(0).getEmailId());
    }
}
