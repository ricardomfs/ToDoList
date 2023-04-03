package com.MyApplication.ToDoList.domain.item;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ItemDtoUpdateIncluir(
        String oldName,
        LocalDate oldPrazo,
        String newName,
        LocalDate newPrazo
        ){
}
