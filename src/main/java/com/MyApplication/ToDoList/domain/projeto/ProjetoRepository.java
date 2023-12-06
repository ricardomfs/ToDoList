package com.MyApplication.ToDoList.domain.projeto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    Optional<Projeto> findByName(String name);
}
