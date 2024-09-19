package com.MyApplication.ToDoList.domain.user;

import jakarta.validation.constraints.NotEmpty;

public record MyUserPersistDto(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
