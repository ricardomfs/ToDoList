package com.MyApplication.ToDoList.controllers;

import com.MyApplication.ToDoList.domain.myUser.dtos.LoginDto;
import com.MyApplication.ToDoList.domain.myUser.dtos.MyUserPersistDto;
import com.MyApplication.ToDoList.domain.myUser.MyUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> performLogin(@RequestBody @Valid LoginDto dto) {
        return ResponseEntity.ok(myUserService.performLogin(dto));
    }
}
