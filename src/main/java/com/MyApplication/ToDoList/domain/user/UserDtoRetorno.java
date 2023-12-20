package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.domain.user.role.RoleDtoRetorno;

import java.util.List;
import java.util.stream.Collectors;

public record UserDtoRetorno(
        Long id,
        String username,
        String password,
        List<RoleDtoRetorno> roleDtoRetorno
) {
    public UserDtoRetorno(MyUser myUser) {
        this(
                myUser.getId(),
                myUser.getUsername(),
                myUser.getPassword(),
                myUser
                        .getMyRoles()
                        .stream()
                        .map(RoleDtoRetorno::new)
                        .collect(Collectors.toList())
        );
    }
}
