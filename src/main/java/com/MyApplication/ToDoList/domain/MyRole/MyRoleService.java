package com.MyApplication.ToDoList.domain.MyRole;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MyRoleService {
    private final MyRoleRepository myRoleRepository;

    public MyRoleService(MyRoleRepository myRoleRepository) {
        this.myRoleRepository = myRoleRepository;
    }

    public MyRole findByIdOrElseThrowBadRequest(Long id) {
        return myRoleRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role de Id:" + id + " Não encontrada"));
    }
}
