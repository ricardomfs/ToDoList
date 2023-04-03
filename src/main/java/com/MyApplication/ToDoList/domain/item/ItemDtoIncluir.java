package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemDtoIncluir (
        @NotBlank
        String name,
        LocalDate prazo,
        boolean completed,
        @NotNull
        Lista lista
        ){
}
