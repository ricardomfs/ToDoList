package com.MyApplication.ToDoList.domain.item.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoUpdateIncluir(
        @NotNull
        Long idLista,
        String oldName,
        String newName,
        LocalDate newPrazo
) {
}
