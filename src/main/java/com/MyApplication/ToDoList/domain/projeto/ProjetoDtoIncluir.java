package com.MyApplication.ToDoList.domain.projeto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoDtoIncluir(
        @NotBlank
        String name,
        @NotBlank
        String descricao
){
}
