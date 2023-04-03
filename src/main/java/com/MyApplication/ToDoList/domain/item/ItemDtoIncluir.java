package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoIncluir (
        @NotBlank
        String name,
        @NotBlank
        LocalDate prazo,
        boolean completed
        ){
}
