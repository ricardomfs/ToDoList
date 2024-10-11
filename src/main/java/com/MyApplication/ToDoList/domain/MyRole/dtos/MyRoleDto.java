package com.MyApplication.ToDoList.domain.MyRole.dtos;

import com.MyApplication.ToDoList.domain.MyRole.MyRole;

public record MyRoleDto(
        Long id,
        String descricao
) {
    public MyRoleDto(MyRole role) {
        this(
                role.getId(),
                role.getDescricao()
        );
    }
}
