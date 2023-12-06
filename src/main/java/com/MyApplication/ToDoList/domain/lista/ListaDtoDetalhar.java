package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.ItemDtoDetalhar;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record ListaDtoDetalhar(
        Long id,
        String name,
        LocalDate dataDeCriacao,
        List<ItemDtoDetalhar> itens,
        Long projeto

) {
    public ListaDtoDetalhar(Lista lista) {
        this(
                lista.getId(),
                lista.getName(),
                lista.getDataDeCriacao(),
                lista.getItens() != null ? lista
                        .getItens()
                        .stream()
                        .map(ItemDtoDetalhar::new)
                        .collect(Collectors.toList()) : null,
                lista
                        .getProjeto()
                        .getId()
        );
    }
}
