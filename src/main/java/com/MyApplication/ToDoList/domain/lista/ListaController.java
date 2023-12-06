package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.ItemDtoIncluir;
import com.MyApplication.ToDoList.domain.item.ItemDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.lista.Lista;
import com.MyApplication.ToDoList.domain.lista.ListaDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.lista.ListaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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
    private ResponseEntity<ListaDtoDetalhar> persistLista(ListaDtoIncluir dtoIncluir) {
        return ResponseEntity.ok(new ListaDtoDetalhar(listaService.persistLista(dtoIncluir)));
    }

    @GetMapping
    private ResponseEntity<Page<ListaDtoDetalhar>> findAll(Pageable page) {
        return ResponseEntity.ok(listaService.findAll(page).stream().map(ListaDtoIncluir::new));
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<ListaDtoDetalhar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(listaService.findByIdOrElseThrowBadRequest(id));
    }

    @PatchMapping(path = "/update")
    private ResponseEntity<ListaDtoDetalhar> updateListSituation(ListaDtoUpdateIncluir update) {
        return ResponseEntity.ok(listaService.updateLista(update));
    }

    @DeleteMapping(path = "/delete/{name}")
    private ResponseEntity<ListaDtoDetalhar> deleteLista(@PathVariable String name) {
        return ResponseEntity.ok(listaService.deleteLista(name));
    }
}
