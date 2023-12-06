package com.MyApplication.ToDoList.domain.projeto;

import com.MyApplication.ToDoList.domain.lista.ListaDtoDetalhar;

import java.util.List;
import java.util.stream.Collectors;

public record ProjetoDtoDetalhar(
        Long id,
        String name,
        String descricao,
        List<ListaDtoDetalhar> listas
) {
    public ProjetoDtoDetalhar(Projeto projeto) {
        this(
                projeto.getId(),
                projeto.getName(),
                projeto.getDescricao(),
                projeto.getListas() != null ? projeto
                        .getListas()
                        .stream()
                        .map(ListaDtoDetalhar::new)
                        .collect(Collectors.toList()) : null
        );
    }
}
