package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.config.security.TokenService;
import com.MyApplication.ToDoList.domain.MyRole.MyRole;
import com.MyApplication.ToDoList.domain.MyRole.MyRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class MyUserService {
    private final MyUserRepository myUserRepository;
    private final MyRoleService myRoleService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public MyUserService(MyUserRepository myUserRepository, MyRoleService myRoleService, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.myUserRepository = myUserRepository;
        this.myRoleService = myRoleService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public MyUser findUserByUsername(String username) {
        return myUserRepository.findByUsername(username);
    }

    @Transactional
    public MyUser persistUser(MyUserPersistDto dto) {
        MyUser myUserToPersist = new MyUser();
        myUserToPersist.setUsername(dto.username());
        myUserToPersist.setPassword(passwordEncoder.encode(dto.password()));
        myUserToPersist.setMyRoleList(new ArrayList<>());

        MyRole myRole = myRoleService.findByIdOrElseThrowBadRequest(1L);
        myUserToPersist
                .getMyRoleList()
                .add(myRole);
        return myUserRepository.save(myUserToPersist);
    }

    @Transactional
    public void updateUser(MyUserUpdatePasswordDto dto) {
        MyUser userToUpdate = this.findUserByUsername(dto.username());

        userToUpdate.setPassword(dto.password());
    }

    public String makeLogin(LoginDto dto) {
        MyUser userByUsername = this.findUserByUsername(dto.username());
        if (userByUsername == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com  o username: " + dto.username() + " não encontrado");
        }
        boolean matches = passwordEncoder.matches(dto.password(), userByUsername.getPassword());
        if (!matches) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida");
        }
        return tokenService.generateToken(userByUsername);
    }

    public MyUser findBySecurityContext() {
        MyUser myUserByContext = (MyUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return myUserByContext;
    }
}
