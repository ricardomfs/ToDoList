package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.myUser.MyUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ListaServiceTest {
    @Autowired
    private ListaService listaService;

    @Test
    @Order(1)
    @DisplayName("When findByIdOrElseThrowNotFound must return a Lista or Throw NOT_FOUND")
    void findByIdOrElseThrowNotFound() {
        Assertions
                .assertThat(listaService.findByIdOrElseThrowNotFound(2L))
                .isNotNull();
        Assertions
                .assertThatExceptionOfType(ResponseStatusException.class)
                .isThrownBy(() -> listaService.findByIdOrElseThrowNotFound(0L));
    }

    @Test
    @Order(2)
    @DisplayName("When findByName() must return a Lista or null")
    @WithUserDetails(value = "testilson")
    void findByName() {
        MyUser principal = (MyUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Page<Lista> all = listaService.findAll(Page
                .empty()
                .getPageable());
        Lista myFirstList = listaService.findByName("My Second List", principal.getId());

        Assertions
                .assertThat(myFirstList)
                .isNotNull();
    }

    @Test
    @Order(3)
    @DisplayName("When persistLista() must persist a Lista for the Logged user")
    @WithUserDetails(value = "testilson")
    void persistLista() {
        Lista listaTeste = listaService.persistLista(new ListaDtoIncluir("Lista Teste"));

        Assertions
                .assertThat(listaTeste)
                .isNotNull();
    }

    @Test
    @Order(4)
    @DisplayName("When findAll() must return all Lista's")
    void findAll() {
        Page<Lista> pageOfLista = listaService.findAll(Pageable.ofSize(5));
        Assertions
                .assertThat(pageOfLista)
                .isNotEmpty();
    }

    @Test
    @Order(5)
    @DisplayName("When updateLista() must update a Lista")
    void updateLista() {
        String newName = "My List Updated";
        Long listId = 2L;
        listaService.updateLista(new ListaDtoUpdateIncluir(listId, newName));

        Assertions
                .assertThat(listaService
                        .findByIdOrElseThrowNotFound(listId)
                        .getName())
                .isEqualTo(newName);
    }

    @Test
    @Order(6)
    @DisplayName("When deleteLista() must delete a register of a Lista using the ID")
    void deleteLista() {
        Long listaToDeleteId = 1L;

        Assertions
                .assertThatNoException()
                .isThrownBy(() -> listaService.deleteLista(listaToDeleteId));
    }
}