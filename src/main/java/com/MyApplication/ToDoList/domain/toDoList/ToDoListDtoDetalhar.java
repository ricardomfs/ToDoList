package com.MyApplication.ToDoList.domain.toDoList;

import com.MyApplication.ToDoList.domain.lista.Lista;

import java.util.List;

public record ToDoListDtoDetalhar(
        Long id,
        String name,
        List<Lista> listas
){
    public ToDoListDtoDetalhar(ToDoList toDoList){
        this(
                toDoList.getId(),
                toDoList.getName(),
                toDoList.getListas()
        );
    }
}
