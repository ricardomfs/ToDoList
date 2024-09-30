package com.MyApplication.ToDoList.domain.lista;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class ListaServiceTest {
    @Autowired
    private ListaService listaService;

    @Test
    @DisplayName("When findByIdOrElseThrowNotFound must return a Lista or Throw NOT_FOUND")
    void findByIdOrElseThrowNotFound() {
        Assertions.assertThat(listaService.findByIdOrElseThrowNotFound(1L)).isNotNull();
    }

    @Test
    void findByName() {
    }

    @Test
    void persistLista() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateLista() {
    }

    @Test
    void deleteLista() {
    }
}