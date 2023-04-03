package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
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
}
