package com.MyApplication.ToDoList.domain.user;

import com.MyApplication.ToDoList.domain.MyRole.MyRole;
import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "my_user_has_my_role",
            joinColumns = {@JoinColumn(name = "my_user_id", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "my_role_id", nullable = false, referencedColumnName = "id")})
    private List<MyRole> myRoleList;
    @OneToMany(mappedBy = "myUser")
    private List<Lista> lista;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> rolesList = new ArrayList<>();
        for (MyRole role : this.myRoleList) {
            rolesList.add(new SimpleGrantedAuthority(role.getDescricao()));
        }
        return rolesList;
    }

    public MyUser() {
    }

    public MyUser(Long id, String username, String password, List<MyRole> myRoleList, List<Lista> lista) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.myRoleList = myRoleList;
        this.lista = lista;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return Objects.equals(id, myUser.id) && Objects.equals(username, myUser.username) && Objects.equals(password, myUser.password) && Objects.equals(myRoleList, myUser.myRoleList) && Objects.equals(lista, myUser.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, myRoleList, lista);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", myRoleList=" + myRoleList +
                '}';
    }
}
