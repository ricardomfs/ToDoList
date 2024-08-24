package com.MyApplication.ToDoList.domain.lista;

public record ToDoListDtoDetalhar(
        Long id,
        String name
){
    public ToDoListDtoDetalhar(Lista toDoList){
        this(
                toDoList.getId(),
                toDoList.getName()
        );
    }
}
