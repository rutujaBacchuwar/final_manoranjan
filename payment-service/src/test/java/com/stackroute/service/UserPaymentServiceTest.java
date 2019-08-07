//package com.stackroute.service;
//
//import com.stackroute.domain.UserPayment;
//import com.stackroute.repository.UserPaymentRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
//public class UserPaymentServiceTest {
//    private UserPayment userPayment=null;
//    //Create a mock for UserRepository
//    @Mock
//    private UserPaymentRepository userPaymentRepository;
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    private UserPaymentServiceImpl userPaymentService;
//    List<UserPayment> list= null;
//    @Before
//    public void setUp(){
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        userPayment = new UserPayment();
//        userPayment.setEmailId("an@gmail.com");
//        userPayment.setPackageName("180days");
//        Date date= Date.valueOf(java.time.LocalDate.now());
//        userPayment.setMydate(date);
//        list = new ArrayList();
//        list.add(userPayment);
//    }
//    //test case for saving the user package details
//    @Test
//    public void saveUserTestSuccess() throws Exception {
//
//        when(userPaymentRepository.save((UserPayment) any())).thenReturn(userPayment);
//        UserPayment savedUser = userPaymentService.saveUserPayment(userPayment);
//        Assert.assertEquals(userPayment,savedUser);
//        //verify here verifies that userRepository save method is only called once
//        verify(userPaymentRepository,times(1)).save(userPayment);
//
//    }
//    //failure testcase for saving the user package details
//    @Test
//    public void saveUserTestFailure() throws Exception {
//        when(userPaymentRepository.save((UserPayment) any())).thenReturn(null);
//        UserPayment savedUser = userPaymentService.saveUserPayment(userPayment);
//        Assert.assertNotEquals(userPayment,savedUser);
//    }
//    @Test
//    //getting the users who have registered for the particular package
//    public void getAllUser(){
//        userPaymentRepository.save(userPayment);
//        //stubbing the mock to return specific data
//        when(userPaymentRepository.findAll()).thenReturn(list);
//        List<UserPayment> userlist = userPaymentService.getAllUsers();
//        Assert.assertEquals(list,userlist);
//    }
//}
