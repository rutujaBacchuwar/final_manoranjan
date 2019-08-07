package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.GlobalControllerHandler;
import com.stackroute.exceptions.UserAllReadyExistException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.service.ProducerService;
import com.stackroute.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private User user;
    @MockBean
    private UserService userService;
    @MockBean
    private ProducerService producerService;
    @InjectMocks
    private UserController userController;

    private List<User> list = null;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(new GlobalControllerHandler()).build();

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
        list = new ArrayList();
        list.add(user);
    }

    //testcase for get all users
    @Test
    public void getAllUsersTest() throws Exception {
        userService.saveUser(user);
        when(userService.getAllUsers()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for save user
    @Test
    public void saveUserTest() throws Exception {
        when(userService.saveUser(any())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    //testcase for save user failure
    @Test
    public void saveUserFailureTest() throws Exception {
        when(userService.saveUser(any())).thenThrow(UserAllReadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for update user
    @Test
    public void updateUserTest() throws Exception {
        when(userService.updateUser(user.getEmailId(), user)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for update user failure
    @Test
    public void updateUserFailureTset() throws Exception {
        when(userService.updateUser(any(), any())).thenThrow(UserNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for get by id
    @Test
    public void getByIdTest() throws Exception {
        when(userService.getById(user.getEmailId())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for get by id failure
    @Test
    public void getByIdFailureTest() throws Exception {
        when(userService.getById(any())).thenThrow(UserNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for delete user
    @Test
    public void deleteUserTest() throws Exception {
        when(userService.deleteUser(user.getEmailId())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testcase for delete user failure
    @Test
    public void deleteUserFailureTest() throws Exception {
        when(userService.deleteUser(any())).thenThrow(UserNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user/email")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
