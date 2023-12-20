package com.MyApplication.ToDoList.domain.comentario;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ComentarioDtoUpdate(
        @NotNull
        Long id,
        @NotEmpty
        String descricao

) {
}
