package com.MyApplication.ToDoList.domain.myUser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MyUserServiceTest {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("When findByUsernameTest, must return MyUser or throw UsernameNotFoundException Exception")
    public void findByUsernameTest() {
        Assertions
                .assertThat(myUserService.findByUsername("testilson"))
                .isNotNull();

        Assertions
                .assertThatExceptionOfType(UsernameNotFoundException.class)
                .isThrownBy(() -> myUserService.findByUsername("NOT_EXISTING_USER"));
    }


    @Test
    @DisplayName("When persistUserTest, must persist a user and return it")
    public void persistUserTest() {
        String username = "Test User To Persist";
        MyUser myUser = myUserService.persistUser(new MyUserPersistDto(username, "@TestPassword"));

        Assertions
                .assertThat(myUser)
                .isNotNull();
        Assertions
                .assertThat(myUser.getUsername())
                .isEqualTo(username);
    }

    @Test
    @DisplayName("When updateUserTest, must update a User password")
    public void updateUserTest() {
        String novaSenha = "@NovaSenha123";
        myUserService.updateUser(new MyUserUpdatePasswordDto("testilson", novaSenha));
        MyUser testilson = myUserService.findByUsername("testilson");

        Assertions
                .assertThat(passwordEncoder.matches(novaSenha, testilson.getPassword()))
                .isTrue();
    }

    @Test
    @DisplayName("When performLoginTest must validate the user credentials and return a valid JWT token")
    public void performLoginTest() {
        Assertions
                .assertThat(myUserService.performLogin(new LoginDto("testilson", "12345")))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @WithUserDetails(value = "testilson")
    @DisplayName("When findBySecurityContextTest, must return a valid User on the Security Context")
    public void findBySecurityContextTest() {
        MyUser myUserByContext = (MyUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Assertions
                .assertThat(myUserByContext.getUsername())
                .isEqualTo("testilson");
    }
}