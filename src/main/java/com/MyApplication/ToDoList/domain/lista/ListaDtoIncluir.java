package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.constraints.NotBlank;

public record ListaDtoIncluir (
        @NotBlank
        String name
){
}
