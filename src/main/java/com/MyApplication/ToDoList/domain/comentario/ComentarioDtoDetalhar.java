package com.MyApplication.ToDoList.domain.comentario;

import java.time.LocalDate;

public record ComentarioDtoDetalhar(
        Long id,

        String descricao,
        LocalDate getDataDeCriacao
) {
    public ComentarioDtoDetalhar(Comentario comentario) {
        this(
                comentario.getId(),
                comentario.getDescricao(),
                comentario.getDataDeCriacao()
        );
    }
}
