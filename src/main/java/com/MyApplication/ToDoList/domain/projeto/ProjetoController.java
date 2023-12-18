package com.MyApplication.ToDoList.domain.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-do-list")
@RequiredArgsConstructor
public class ProjetoController {
    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> persistToDoList(@RequestBody @Valid ProjetoDtoIncluir toDoList) {
        return ResponseEntity.ok(projetoService.persistToDoList(toDoList));
    }

    @GetMapping(name = "/get-all")
    public ResponseEntity<List<Projeto>> findAllToDoList(Pageable page) {
        Page<Projeto> projectPageable = projetoService
                .findAll(page);
        return ResponseEntity.ok(projectPageable.getContent());
    }
}
