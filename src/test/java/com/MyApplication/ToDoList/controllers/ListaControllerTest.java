package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.config.security.TokenService;
import com.MyApplication.ToDoList.domain.myUser.MyUser;
import com.MyApplication.ToDoList.domain.myUser.MyUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ListaControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private MyUserService myUserService;
    private static String jwtToken;

    @BeforeEach
    void beforeEachTest() {
        if (jwtToken == null) {
            String username = "testilson";
            MyUser user = myUserService.findByUsername(username);
            jwtToken = tokenService.generateToken(user);
        }
    }

    @Test
    @DisplayName("When save() must return status 200(OK)")
    @Order(1)
    void save() throws Exception {
        String jsonContent = "{\"name\":\"teste5\"}";

        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .post("/lista")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent)
                        .header("Authorization", "Bearer " + jwtToken))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @Order(2)
    @DisplayName("When findAll() must return status 200(OK)")
    void findAll() throws Exception {
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .get("/lista")
                        .header("Authorization", "Bearer " + jwtToken))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @Order(3)
    @DisplayName("When findById() must return status 200(OK)")
    void findById() throws Exception {
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .get("/lista/" + 1L)
                        .header("Authorization", "Bearer " + jwtToken))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @Order(4)
    @DisplayName("When updateListSituation() must return status 204(NO CONTENT)")
    void updateListSituation() throws Exception {
        String content =
                """
                        {
                            "id":1,
                            "newName":"nameUpdated"
                        }
                        """;

        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .patch("/lista")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                        .header("Authorization", "Bearer " + jwtToken))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @Order(5)
    @DisplayName("When deleteLista() must return status 204(NO CONTENT)")
    void deleteLista() throws Exception {
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders
                        .delete("/lista/" + 1L)
                        .header("Authorization", "Bearer " + jwtToken))
                .andReturn()
                .getResponse();

        Assertions
                .assertThat(response.getStatus())
                .isEqualTo(HttpStatus.NO_CONTENT.value());
    }
}