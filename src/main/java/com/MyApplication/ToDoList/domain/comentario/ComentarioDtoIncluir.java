package com.MyApplication.ToDoList.domain.comentario;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ComentarioDtoIncluir(
        @NotEmpty
        String descricao,
        @NotNull
        Long item
) {
}
