package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.toDoList.ToDoListDtoIncluir;
import com.MyApplication.ToDoList.domain.toDoList.ToDoListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/to-do-list")
@RestController
@RequiredArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;
    @PostMapping
    public ResponseEntity persistToDoList(@RequestBody @Valid ToDoListDtoIncluir toDoList){
        return ResponseEntity.ok(toDoListService.persistToDoList(toDoList));
    }

    @GetMapping
    public ResponseEntity findAllToDoList(Pageable page) {
        return ResponseEntity.ok(toDoListService.findAll(page));
    }
}
