package com.MyApplication.ToDoList.domain.myUser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

@DataJpaTest
class MyUserRepositoryTest {
    @Autowired
    private MyUserRepository myUserRepository;

    @Test
    @DisplayName("When findByUsername return a instance of MyUser")
    void findByUsername() {

        MyUser testePersisted = myUserRepository.save(new MyUser(null, "teste", "$2a$12$TKiUADI9CXklQ5AlJ2loJe6eUTbyAs9WKp7xMKyB9.Lq4eKYR1gAG", new ArrayList<>(), new ArrayList<>()));

        MyUser byUsername = myUserRepository.findByUsername(testePersisted.getUsername());

        Assertions
                .assertThat(testePersisted)
                .isEqualTo(byUsername);
    }
}