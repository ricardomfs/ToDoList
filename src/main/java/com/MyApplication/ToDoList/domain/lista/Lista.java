package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.lista.dtos.ListaDtoIncluir;
import com.MyApplication.ToDoList.domain.myUser.MyUser;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    private List<Item> itens;
    @ManyToOne
    @JoinColumn(name = "myUser", nullable = false)
    private MyUser myUser;

    public Lista(ListaDtoIncluir dtoIncluir) {
        this.name = dtoIncluir.name();
        this.itens = new ArrayList<>();
    }

    public Lista() {
    }

    public Lista(Long id, String name, List<Item> itens) {
        this.id = id;
        this.name = name;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return Objects.equals(id, lista.id) && Objects.equals(name, lista.name) && Objects.equals(itens, lista.itens) && Objects.equals(myUser, lista.myUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, itens, myUser);
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itens=" + itens +
                ", myUser=" + myUser +
                '}';
    }
}
