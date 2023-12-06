package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.constraints.NotBlank;

public record ListaDtoUpdateIncluir(
        Long id,
        String newName
){
}
