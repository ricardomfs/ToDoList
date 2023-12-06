package com.MyApplication.ToDoList.domain.lista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Long> {
    @Query("""
            SELECT l FROM Lista l WHERE l.name := name;
            """)
    Optional<Lista> findByName(String name);

}
