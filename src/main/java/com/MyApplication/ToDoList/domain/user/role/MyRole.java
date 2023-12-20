package com.MyApplication.ToDoList.domain.user.role;

import com.MyApplication.ToDoList.domain.user.MyUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "my_roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToMany(mappedBy = "myRoles")
    private List<MyUser> myUsers;
}
