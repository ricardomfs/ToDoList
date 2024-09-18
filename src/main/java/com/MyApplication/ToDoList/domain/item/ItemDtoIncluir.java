package com.MyApplication.ToDoList.domain.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoIncluir(
        @NotNull
        Long listaId,
        @NotBlank
        String name,
        @NotBlank
        LocalDate prazo
) {
}
