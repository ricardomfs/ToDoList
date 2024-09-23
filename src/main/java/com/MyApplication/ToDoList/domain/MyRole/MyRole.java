/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyApplication.ToDoList.domain.MyRole;

import com.MyApplication.ToDoList.domain.user.MyUser;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author ricardo
 */
@Entity
@Table(name = "my_role")
public class MyRole {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @ManyToMany(mappedBy = "myRoleList")
    private List<MyUser> myUserList;

    public MyRole(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public MyRole() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
