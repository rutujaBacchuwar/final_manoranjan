//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.domain.UserPayment;
//import com.stackroute.service.UserPaymentService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserPaymentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    private UserPayment userPayment;
//    @MockBean
//    private UserPaymentService userPaymentService;
//    @InjectMocks
//    private UserPaymentController userPaymentController;
//
//    private List<UserPayment> list = null;
//
//    @Before
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userPaymentController).build();
//        userPayment = new UserPayment();
//        userPayment.setEmailId("an@gmail.com");
//        userPayment.setPackageName("180days");
//        Date date = Date.valueOf(java.time.LocalDate.now());
//        userPayment.setMydate(date);
//        list = new ArrayList();
//        list.add(userPayment);
//        System.out.println(userPayment);
//    }
//
//    @Test
//    //testcase for saving user package details
//    public void saveUser() throws Exception {
//        when(userPaymentService.saveUserPayment((UserPayment) any())).thenReturn(userPayment);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userPayment)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    //failure case for saving the user package details
//    public void saveUserFailure() throws Exception {
//        when(userPaymentService.saveUserPayment((UserPayment) any())).thenThrow();
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userPayment)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllUser() throws Exception {
//        when(userPaymentService.getAllUsers()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userPayment)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}