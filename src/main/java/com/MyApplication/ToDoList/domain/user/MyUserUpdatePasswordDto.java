package com.MyApplication.ToDoList.domain.user;

public record MyUserUpdatePasswordDto(
        String username,
        String password
) {
}
