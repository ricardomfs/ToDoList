package com.MyApplication.ToDoList.domain.comentario;

import com.MyApplication.ToDoList.domain.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeCriacao;
    @ManyToOne
    @JoinColumn(name = "item_has_comentario", referencedColumnName = "id", nullable = false)
    private Item item;
}
