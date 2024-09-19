package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.user.*;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MyUserController {
    private final MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @PostMapping
    public ResponseEntity<Void> persistMyUser(@RequestBody @Valid MyUserPersistDto dto) {
        myUserService.persistUser(dto);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> makeLogin(@RequestBody @Valid LoginDto dto) {
        return ResponseEntity.ok(myUserService.makeLogin(dto));
    }
}
