package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;

import java.util.List;

public record ListaDtoDetalhar (
        Long id,
        String name,
        List<Item> itens

){
    public ListaDtoDetalhar(Lista lista) {
        this(
                lista.getId(),
                lista.getName(),
                lista.getItens()
        );
    }
}
