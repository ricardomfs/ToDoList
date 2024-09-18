package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.domain.MyRole.MyRole;
import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "myUser")
    private List<MyRole> myRoleList;
    @OneToMany(mappedBy = "myUser")
    private List<Lista> lista;

    public MyUser(MyUserPersistDto dto) {
        this.username = dto.username();
        this.password = dto.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> rolesList = new ArrayList<>();
        for (MyRole role : this.myRoleList) {
            rolesList.add(new SimpleGrantedAuthority(role.getDescricao()));
        }
        return rolesList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MyRole> getMyRoleList() {
        return myRoleList;
    }

    public void setMyRoleList(List<MyRole> myRoleList) {
        this.myRoleList = myRoleList;
    }

    public List<Lista> getLista() {
        return lista;
    }

    public void setLista(List<Lista> lista) {
        this.lista = lista;
    }
}
