package com.MyApplication.ToDoList.domain.lista.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListaDtoUpdateIncluir(
        @NotNull
        Long id,
        @NotBlank
        String newName
){
}
