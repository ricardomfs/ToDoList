package com.MyApplication.ToDoList.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-endpoint")
public class TestController {

    @GetMapping
    public String ping() {
        return "Ping!";
    }
}
