package com.MyApplication.ToDoList.domain.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/to-do-list")
@RestController
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;
    @PostMapping
    public ResponseEntity persistToDoList(@RequestBody @Valid ProjetoDtoIncluir toDoList){
        return ResponseEntity.ok(projetoService.persistToDoList(toDoList));
    }

    @GetMapping
    public ResponseEntity findAllToDoList(Pageable page) {
        return ResponseEntity.ok(projetoService.findAll(page));
    }
}
