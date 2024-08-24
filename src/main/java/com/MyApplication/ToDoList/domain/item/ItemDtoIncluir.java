package com.MyApplication.ToDoList.domain.item;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ItemDtoIncluir(
        @NotBlank
        String name,
        @NotBlank
        LocalDate prazo
) {
}
