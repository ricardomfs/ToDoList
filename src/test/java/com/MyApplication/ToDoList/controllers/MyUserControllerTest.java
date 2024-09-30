package com.MyApplication.ToDoList.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MyUserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("When persistMyUserTest, will return status CREATED")
    void persistMyUserTest() throws Exception {
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """        
                                        {
                                            "username":"Test User To Persist",
                                            "password":"12345"
                                        }
                                        """
                        ))
                .andReturn()
                .getResponse();


        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @DisplayName("When persistMyUserTest, will return status OK")
    void performLoginTest() throws Exception {
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """        
                                        {
                                            "username":"testilson",
                                            "password":"12345"
                                        }
                                        """
                        ))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK.value());
    }
}