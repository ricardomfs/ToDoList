package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    private List<Item> itens;

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
}
