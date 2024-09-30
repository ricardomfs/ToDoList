package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.myUser.MyUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ListaRepositoryTest {
    @Autowired
    private ListaRepository listaRepository;

    @Test
    @DisplayName("When findByNameAndMyUserId, will return a Optional of Lista")
    void findByNameAndMyUserId() {
        Optional<Lista> listaOptional = listaRepository.findByNameAndMyUserId("My First List", 1L);

        Assertions
                .assertThat(listaOptional)
                .isNotEmpty();
    }
}