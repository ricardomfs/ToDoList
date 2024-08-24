package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListaDtoUpdateIncluir(
        @NotNull
        Long id,
        @NotBlank
        String newName
){
}
