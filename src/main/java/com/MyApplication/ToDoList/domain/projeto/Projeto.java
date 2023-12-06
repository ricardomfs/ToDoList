package com.MyApplication.ToDoList.domain.projeto;

import com.MyApplication.ToDoList.domain.lista.Lista;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descricao;
    @OneToMany(mappedBy = "toDoList",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lista> listas;


    public Projeto(ProjetoDtoIncluir dto) {
        this.name = dto.name();
        this.descricao = dto.descricao();
        this.listas = new ArrayList<>();
    }
}
