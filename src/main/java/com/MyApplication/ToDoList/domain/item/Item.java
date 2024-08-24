package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate prazo;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "itens", referencedColumnName = "id", nullable = false)
    private Lista lista;

    public Item(ItemDtoIncluir item){
        this.name = item.name();
        this.prazo = item.prazo();
        this.completed = false;
    }

    public Item() {
    }
    public Item(Lista lista, boolean completed, LocalDate prazo, String name, Long id) {
        this.lista = lista;
        this.completed = completed;
        this.prazo = prazo;
        this.name = name;
        this.id = id;
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

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return completed == item.completed && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(prazo, item.prazo) && Objects.equals(lista, item.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prazo, completed, lista);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prazo=" + prazo +
                ", completed=" + completed +
                ", lista=" + lista +
                '}';
    }
}
