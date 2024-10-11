package com.MyApplication.ToDoList.domain.myUser.dtos;

public record MyUserUpdatePasswordDto(
        String username,
        String newPassword
) {
}
