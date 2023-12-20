package com.MyApplication.ToDoList.domain.user;

public record UserDtoUpdate(
        Long id,
        String username,
        String password
) {
}
