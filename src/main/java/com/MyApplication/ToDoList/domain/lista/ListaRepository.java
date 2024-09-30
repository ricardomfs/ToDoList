package com.MyApplication.ToDoList.domain.lista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Long> {
    Optional<Lista> findByNameAndMyUserId(String name, Long userId);
}
