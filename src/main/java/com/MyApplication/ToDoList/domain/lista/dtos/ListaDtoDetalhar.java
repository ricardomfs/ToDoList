package com.MyApplication.ToDoList.domain.lista.dtos;

import com.MyApplication.ToDoList.domain.item.dtos.ItemDtoDetalhar;
import com.MyApplication.ToDoList.domain.lista.Lista;

import java.util.ArrayList;
import java.util.List;

public record ListaDtoDetalhar(
        Long id,
        String name,
        List<ItemDtoDetalhar> itens

) {
    public ListaDtoDetalhar(Lista lista) {
        this(
                lista.getId(),
                lista.getName(),
                lista.getItens() != null ? lista.getItens().stream().map(ItemDtoDetalhar::new).toList() : new ArrayList<>()
        );
    }
}
