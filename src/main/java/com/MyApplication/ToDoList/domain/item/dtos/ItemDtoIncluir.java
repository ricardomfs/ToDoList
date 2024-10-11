package com.MyApplication.ToDoList.domain.item.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoIncluir(
        @NotNull
        Long listaId,
        @NotEmpty
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull
        LocalDate prazo
) {
}
