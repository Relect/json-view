package com.example.json_viev.controller;

import com.example.json_viev.model.User;
import com.example.json_viev.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private UserService service;
    @InjectMocks
    private Controller controller;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getUserByIdTest() throws Exception {
        User user = new User(1L, "Ivan", "Ivan@mail.ru", null);
        Mockito.when(service.getUser(1L)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ivan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("Ivan@mail.ru"));

        Mockito.verify(service, Mockito.times(1)).getUser(1);

    }
}
