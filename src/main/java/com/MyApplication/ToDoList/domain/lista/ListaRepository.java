package com.MyApplication.ToDoList.domain.lista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Long> {
    Optional<Lista> findByName(String name);

}
