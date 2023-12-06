package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.comentario.Comentario;
import com.MyApplication.ToDoList.domain.lista.Lista;
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
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "lista", referencedColumnName = "id", nullable = false)
    private Lista lista;
    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private List<Comentario> comentario;

    public Item(ItemDtoIncluir item){
        this.name = item.name();
        this.prazo = item.prazo();
        this.isCompleted = false;
        this.lista = null;
        this.comentario = null;
    }
}
