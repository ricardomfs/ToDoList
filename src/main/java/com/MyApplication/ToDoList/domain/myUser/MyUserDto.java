package com.MyApplication.ToDoList.domain.myUser;

import com.MyApplication.ToDoList.domain.MyRole.MyRoleDto;

import java.util.List;

public record MyUserDto(
        Long id,
        String username,
        List<MyRoleDto> roles
) {
    public MyUserDto(MyUser myUser) {
        this(
                myUser.getId(),
                myUser.getUsername(),
                myUser
                        .getMyRoleList()
                        .stream()
                        .map(MyRoleDto::new)
                        .toList()
        );
    }
}
