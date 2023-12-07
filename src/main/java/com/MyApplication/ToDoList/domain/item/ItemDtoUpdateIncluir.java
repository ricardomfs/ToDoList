package com.MyApplication.ToDoList.domain.item;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ItemDtoUpdateIncluir(
        Long id,
        String newName,
        String descricao,
        LocalDate newPrazo
        ){
}
