package com.MyApplication.ToDoList.domain.myUser.dtos;

import com.MyApplication.ToDoList.domain.MyRole.dtos.MyRoleDto;
import com.MyApplication.ToDoList.domain.myUser.MyUser;

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
