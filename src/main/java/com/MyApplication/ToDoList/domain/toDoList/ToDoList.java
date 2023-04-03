package com.MyApplication.ToDoList.domain.toDoList;

import com.MyApplication.ToDoList.domain.lista.Lista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "toDoList",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Lista> listas;


    public ToDoList(ToDoListDtoIncluir dto) {
        this.name = dto.name();
        this.listas = dto.listas() != null ? dto.listas() : new ArrayList<Lista>();
    }
}
