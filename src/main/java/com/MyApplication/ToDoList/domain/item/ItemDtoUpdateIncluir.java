package com.MyApplication.ToDoList.domain.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoUpdateIncluir(
        @NotNull
        Long idLista,
        String oldName,
        LocalDate oldPrazo,
        String newName,
        LocalDate newPrazo
        ){
}
