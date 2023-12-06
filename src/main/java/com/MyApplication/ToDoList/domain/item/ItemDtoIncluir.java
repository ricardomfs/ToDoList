package com.MyApplication.ToDoList.domain.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoIncluir (
        @NotBlank
        String name,
        @NotBlank
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate prazo,
        @NotNull
        boolean isCompleted,
        @NotNull
        Long lista
){
}
