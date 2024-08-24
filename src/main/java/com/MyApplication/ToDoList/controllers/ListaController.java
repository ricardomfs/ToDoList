package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.item.ItemDtoIncluir;
import com.MyApplication.ToDoList.domain.lista.ListaDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.lista.ListaService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lista")
public class ListaController {
    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @PostMapping
    private ResponseEntity save(ItemDtoIncluir itemDto){
        return ResponseEntity.ok(listaService.persistLista(itemDto));
    }

    @GetMapping
    private ResponseEntity findAll(Pageable page){
        return ResponseEntity.ok(listaService.findAll(page));
    }
    @GetMapping(path = "/{id}")
    private ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(listaService.findById(id));
    }
    @PatchMapping(path = "/update")
    private ResponseEntity updateListSituation(ListaDtoUpdateIncluir update) {
        return ResponseEntity.ok(listaService.updateLista(update));
    }
    @DeleteMapping(path = "/delete/{name}")
    private ResponseEntity deleteLista(@PathVariable String name){
        return ResponseEntity.ok(listaService.deleteLista(name));
    }
}
