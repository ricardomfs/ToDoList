package com.MyApplication.ToDoList.domain.item.dtos;

import com.MyApplication.ToDoList.domain.item.Item;

import java.time.LocalDate;

public record ItemDtoDetalhar(
        Long id,
        String name,
        LocalDate prazo,
        boolean complete,
        Long listaId
        ) {
        public ItemDtoDetalhar(Item item){
                this(
                        item.getId(),
                        item.getName(),
                        item.getPrazo(),
                        item.isCompleted(),
                        item.getLista().getId()
                );
        }
}
