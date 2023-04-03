package com.MyApplication.ToDoList.domain.toDoList;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ToDoListDtoIncluir(
        @NotBlank
        String name,
        @NotBlank
        List<Lista> listas
){
}
