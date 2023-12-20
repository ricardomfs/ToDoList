package com.MyApplication.ToDoList.domain.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final MyUserService myUserService;

    @PostMapping
    public ResponseEntity<UserDtoRetorno> persistUser(@RequestBody @Valid UserDtoInclude dto) {
        return ResponseEntity
                .created(URI.create("/session"))
                .body(new UserDtoRetorno(myUserService.persistMyUser(dto)));
    }

    @PutMapping
    public ResponseEntity<UserDtoRetorno> updateUser(@RequestBody @Valid UserDtoUpdate dtoUpdate) {
        myUserService.updateMyUser(dtoUpdate);
        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping(path = "${id}")
    public ResponseEntity<UserDtoRetorno> updateUser(@PathVariable(value = "id") Long id) {
        myUserService.deleteMyUserById(id);

        return ResponseEntity
                .noContent()
                .build();
    }
    @GetMapping
    public ResponseEntity login(@RequestBody @Valid UserDtoInclude login) {
        return myUserService.
    }
}
