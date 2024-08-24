package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.constraints.NotBlank;

public record ListaDtoUpdateIncluir(
        @NotBlank
        String oldName,
        @NotBlank
        String newName
){
}
