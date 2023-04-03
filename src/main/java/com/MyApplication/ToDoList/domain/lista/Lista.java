package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.toDoList.ToDoList;
import com.MyApplication.ToDoList.domain.toDoList.ToDoListDtoIncluir;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itens;
    @ManyToOne()
    @JoinColumn(name = "to_do_list", referencedColumnName = "id", nullable = false)
    private ToDoList toDoList;

    public Lista(ToDoListDtoIncluir toDoList) {
        this.name = "Lista em branco";
        this.itens = null;
        this.toDoList = new ToDoList(toDoList);
    }
}
