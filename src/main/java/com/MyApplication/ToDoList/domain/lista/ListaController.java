package com.MyApplication.ToDoList.domain.lista;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lista")
public class ListaController {
    private final ListaService listaService;

    @PostMapping
    private ResponseEntity<ListaDtoDetalhar> persistLista(@RequestBody @Valid ListaDtoIncluir dtoIncluir) {
        return ResponseEntity.ok(new ListaDtoDetalhar(listaService.persistLista(dtoIncluir)));
    }

    @GetMapping
    private ResponseEntity<List<ListaDtoDetalhar>> findAll(Pageable page) {

        return ResponseEntity.ok(listaService
                .findAll(page)
                .getContent());
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<ListaDtoDetalhar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ListaDtoDetalhar(listaService.findByIdOrElseThrowBadRequest(id)));
    }

    @PatchMapping(path = "/update")
    private ResponseEntity<ListaDtoDetalhar> updateListSituation(ListaDtoUpdateIncluir update) {
        listaService.updateLista(update);
        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping(path = "/delete/{name}")
    private ResponseEntity<ListaDtoDetalhar> deleteLista(@PathVariable String name) {
        listaService.deleteLista(name);

        return ResponseEntity
                .noContent()
                .build();
    }
}
