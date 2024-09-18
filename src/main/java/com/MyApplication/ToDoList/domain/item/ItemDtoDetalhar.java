package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;

import java.time.LocalDate;

public record ItemDtoDetalhar(
        Long id,
        String name,
        LocalDate prazo,
        boolean complete,
        Lista lista
        ) {
        public ItemDtoDetalhar(Item item){
                this(
                        item.getId(),
                        item.getName(),
                        item.getPrazo(),
                        item.isCompleted(),
                        item.getLista()
                );
        }
}
