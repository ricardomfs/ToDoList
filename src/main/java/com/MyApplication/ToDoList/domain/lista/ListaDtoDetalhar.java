package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.toDoList.ToDoList;

import java.util.List;

public record ListaDtoDetalhar (
        Long id,
        String name,
        List<Item> itens,
        ToDoList toDoList

){
    public ListaDtoDetalhar(Lista lista) {
        this(
                lista.getId(),
                lista.getName(),
                lista.getItens(),
                lista.getToDoList()
        );
    }
}
