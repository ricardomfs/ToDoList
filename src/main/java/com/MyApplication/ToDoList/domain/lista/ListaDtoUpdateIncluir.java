package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.toDoList.ToDoList;
import jakarta.validation.constraints.NotBlank;

public record ListaDtoUpdateIncluir(
        @NotBlank
        String oldName,
        @NotBlank
        String newName
){
}
