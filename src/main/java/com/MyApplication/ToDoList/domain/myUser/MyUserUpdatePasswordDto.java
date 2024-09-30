package com.MyApplication.ToDoList.domain.myUser;

public record MyUserUpdatePasswordDto(
        String username,
        String newPassword
) {
}
