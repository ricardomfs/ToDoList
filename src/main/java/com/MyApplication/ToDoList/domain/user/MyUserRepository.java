package com.MyApplication.ToDoList.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    @Query("""
            SELECT m FROM MyUser m WHERE m.username := username
            """)
    Optional<MyUser> findByUsername(String username);
}
