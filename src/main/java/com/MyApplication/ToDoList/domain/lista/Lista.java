package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.projeto.Projeto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeCriacao;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Item> itens;
    @ManyToOne
    @JoinColumn(name = "lista_has_projeto", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Projeto projeto;

    public Lista(ListaDtoIncluir dto) {
        this.name = dto.name();
        this.itens = new ArrayList<>();
        this.dataDeCriacao = LocalDate.now();
        this.projeto = null;
    }
}
