package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.item.ItemDtoIncluir;
import com.MyApplication.ToDoList.domain.item.ItemDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.item.ItemService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity persistItem(@RequestBody @Valid ItemDtoIncluir itemDto){
        return ResponseEntity.ok(itemService.save(new Item(itemDto)));
    }
    @GetMapping(path = "/")
    public ResponseEntity findAll(Pageable page){
        return ResponseEntity.ok(itemService.findAll(page));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.findById(id));
    }
    @PatchMapping(path = "/update")
    public ResponseEntity updateItem(@RequestBody @Valid ItemDtoUpdateIncluir itemToUpdate){
        ResponseEntity.ok(itemService.updateItemByName(itemToUpdate));
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = "delete/{name}")
    public ResponseEntity deleteItem(@PathVariable String name) {
        return ResponseEntity.ok(itemService.deleteItemByName(name));
    }
}
