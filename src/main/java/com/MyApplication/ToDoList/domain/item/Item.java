package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.comentario.Comentario;
import com.MyApplication.ToDoList.domain.lista.Lista;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "itens")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank
    private String name;
    @Temporal(TemporalType.DATE)
    private LocalDate prazo;
    private String descricao;
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "item_has_lista", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Lista lista;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Comentario> comentario;

    public Item(ItemDtoIncluir item){
        this.name = item.name();
        this.prazo = item.prazo();
        this.isCompleted = false;
        this.descricao = item.descricao();
        this.lista = null;
        this.comentario = null;
    }
}
