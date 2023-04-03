package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.toDoList.ToDoList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListaDtoIncluir (
        @NotBlank
        String name,
        @NotNull
        List<Item> itemList,
        @NotBlank
        ToDoList toDoList
){
}
