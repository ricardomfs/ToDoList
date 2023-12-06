package com.MyApplication.ToDoList.domain.item;

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
    @Temporal(TemporalType.DATE)
    private LocalDate prazo;
    @NotNull
    private short completed;
    @ManyToOne
    @JoinColumn(name = "lista", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Lista lista;

    public Item(ItemDtoIncluir item){
        this.name = item.name();
        this.prazo = item.prazo();
        this.completed = 0;
    }
}
