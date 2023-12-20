package com.MyApplication.ToDoList.domain.user.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyRoleService {
    private final MyRoleRepository myRoleRepository;

    public MyRole findByIdOrElseThrowBadRequest(Long id) {
        return myRoleRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role de Id: " + id + " não encontrada!"));
    }

    public List<MyRole> findAllRoles() {
        return myRoleRepository.findAll();
    }
}
