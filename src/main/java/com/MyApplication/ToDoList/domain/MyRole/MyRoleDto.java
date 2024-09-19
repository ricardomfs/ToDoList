package com.MyApplication.ToDoList.domain.MyRole;

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
