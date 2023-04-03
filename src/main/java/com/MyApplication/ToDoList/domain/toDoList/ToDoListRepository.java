package com.MyApplication.ToDoList.domain.toDoList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    Optional<ToDoList> findByName(String name);
}
