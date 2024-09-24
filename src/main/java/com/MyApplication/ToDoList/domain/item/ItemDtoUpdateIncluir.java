package com.MyApplication.ToDoList.domain.item;

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
