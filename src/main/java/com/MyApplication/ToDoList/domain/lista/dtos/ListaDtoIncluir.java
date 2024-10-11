package com.MyApplication.ToDoList.domain.lista.dtos;

import jakarta.validation.constraints.NotBlank;

public record ListaDtoIncluir (
        @NotBlank
        String name
){
}
