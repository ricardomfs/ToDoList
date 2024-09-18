package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.domain.MyRole.MyRole;
import com.MyApplication.ToDoList.domain.MyRole.MyRoleService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class MyUserService implements UserDetailsService {
    private final MyUserRepository myUserRepository;
    private final MyRoleService myRoleService;

    public MyUserService(MyUserRepository myUserRepository, MyRoleService myRoleService) {
        this.myUserRepository = myUserRepository;
        this.myRoleService = myRoleService;
    }

    public MyUser findUserByUsername(String username) {
        return myUserRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findUserByUsername(username);
    }

    @Transactional
    public MyUser persistUser(MyUserPersistDto dto) {
        MyUser myUserToPersist = new MyUser(dto);
        myUserToPersist.setMyRoleList(new ArrayList<>());

        MyRole myRole = myRoleService.findByIdOrElseThrowBadRequest(1L);
        myUserToPersist.getMyRoleList().add(myRole);
        return myUserRepository.save(myUserToPersist);
    }

    @Transactional
    public void updateUser(MyUserUpdatePasswordDto dto) {
        MyUser userToUpdate = this.findUserByUsername(dto.username());

        userToUpdate.setPassword(dto.password());
    }

    public MyUser findBySecurityContext() {
        MyUser myUserByContext = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUserByContext;
    }
}
