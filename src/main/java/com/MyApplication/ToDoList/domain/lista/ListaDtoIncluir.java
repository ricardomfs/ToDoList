package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListaDtoIncluir (
        @NotBlank
        String name,
        @NotNull
        Long projeto
){
}
