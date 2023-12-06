package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ItemDtoDetalhar(
        Long id,
        String name,
        LocalDate prazo,
        boolean isComplete,
        Long lista
        //todo comentario do item
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
