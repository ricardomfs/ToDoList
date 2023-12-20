package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.domain.user.role.MyRole;
import com.MyApplication.ToDoList.domain.user.role.MyRoleService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {
    private final MyUserRepository myUserRepository;
    private final MyRoleService myRoleService;
    private final PasswordEncoder encoder;

    public MyUser findByIdOrElseThrowBadRequest(Long id) {
        return myUserRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario de Id:" + id + " não encontrado"));
    }

    public MyUser persistMyUser(UserDtoInclude user) {
        MyUser userToPersist = new MyUser(user);

        MyRole userRole = myRoleService.findByIdOrElseThrowBadRequest(2L);

        userToPersist.setMyRoles(Collections.singletonList(userRole));
        userToPersist.setPassword(encoder.encode(userToPersist.getPassword()));

        return myUserRepository.save(userToPersist);
    }

    @Transactional
    public void deleteMyUserById(Long id) {
        myUserRepository.deleteById(id);
    }

    @Transactional
    public void updateMyUser(UserDtoUpdate userUpdate) {
        MyUser build = MyUser
                .builder()
                .id(userUpdate.id())
                .username(userUpdate.username())
                .password(userUpdate.password())
                .build();

        myUserRepository.save(build);
    }

    public MyUser findByUsername(String username) {
        Optional<MyUser> userOptional = myUserRepository.findByUsername(username);
        return userOptional.orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findByUsername(username);
    }

    public boolean authenticateUser(UserDtoInclude userLogin) {
        UserDetails userDetails = loadUserByUsername(userLogin.username());
        if (userDetails == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado!");
        }
        encoder.matches(userLogin.password(), userDetails.getPassword());
    }
}
