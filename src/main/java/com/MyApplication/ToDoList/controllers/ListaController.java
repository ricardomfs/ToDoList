package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.lista.ListaDtoDetalhar;
import com.MyApplication.ToDoList.domain.lista.ListaDtoIncluir;
import com.MyApplication.ToDoList.domain.lista.ListaDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.lista.ListaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {
    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @PostMapping
    public ResponseEntity<ListaDtoDetalhar> save(@RequestBody @Valid ListaDtoIncluir dto) {
        return ResponseEntity.ok(new ListaDtoDetalhar(listaService.persistLista(dto)));
    }

    @GetMapping
    public ResponseEntity<List<ListaDtoDetalhar>> findAll(Pageable page) {
        return ResponseEntity.ok(listaService.findAll(page).stream().map(ListaDtoDetalhar::new).toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ListaDtoDetalhar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ListaDtoDetalhar(listaService.findByIdOrElseThrowNotFound(id)));
    }

    @PatchMapping
    public ResponseEntity<ListaDtoDetalhar> updateListSituation(@RequestBody @Valid ListaDtoUpdateIncluir update) {
        listaService.updateLista(update);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ListaDtoDetalhar> deleteLista(@PathVariable Long id) {
        listaService.deleteLista(id);
        return ResponseEntity.noContent().build();
    }
}
