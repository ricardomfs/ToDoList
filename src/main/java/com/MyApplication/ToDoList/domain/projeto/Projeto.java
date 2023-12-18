package com.MyApplication.ToDoList.domain.projeto;

import com.MyApplication.ToDoList.domain.lista.Lista;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    @OneToMany(mappedBy = "projeto",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Lista> listas;

    public Projeto(ProjetoDtoIncluir dto) {
        this.name = dto.name();
        this.descricao = dto.descricao();
        this.listas = new ArrayList<>();
    }
}
