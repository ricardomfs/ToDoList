package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    private String name;
    private LocalDate prazo;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "itens", referencedColumnName = "id", nullable = false)
    private Lista lista;

}
