package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.item.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDtoDetalhar> persistItem(@RequestBody @Valid ItemDtoIncluir dto) {
        return ResponseEntity.ok(new ItemDtoDetalhar(itemService.save(dto)));
    }

    @GetMapping(path = "/find-by-lista")
    public ResponseEntity<List<ItemDtoDetalhar>> findAllByListaId(@RequestParam Long listaId, Pageable pageable) {
        return ResponseEntity.ok(itemService
                .findAllByLista(listaId, pageable)
                .stream()
                .map(ItemDtoDetalhar::new)
                .toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemDtoDetalhar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ItemDtoDetalhar(itemService.findByIdOrElseThrowBadRequest(id)));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Void> updateItem(@RequestBody @Valid ItemDtoUpdateIncluir itemToUpdate) {
        itemService.updateItemByName(itemToUpdate);
        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteItem(@RequestParam String name, @RequestParam Long listaId) {
        itemService.deleteItemByName(name, listaId);
        return ResponseEntity
                .noContent()
                .build();
    }
}
