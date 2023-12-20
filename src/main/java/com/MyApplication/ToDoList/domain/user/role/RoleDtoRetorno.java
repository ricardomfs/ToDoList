package com.MyApplication.ToDoList.domain.user.role;

public record RoleDtoRetorno(
        Long id,
        String descricao
) {
    public RoleDtoRetorno(MyRole myRole) {
        this(
                myRole.getId(),
                myRole.getDescricao()
        );
    }
}
