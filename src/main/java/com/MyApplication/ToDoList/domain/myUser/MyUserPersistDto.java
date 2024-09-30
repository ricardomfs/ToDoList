package com.MyApplication.ToDoList.domain.myUser;

import jakarta.validation.constraints.NotEmpty;

public record MyUserPersistDto(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
