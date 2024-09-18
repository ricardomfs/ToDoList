package com.MyApplication.ToDoList.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNameAndListaId(String name, Long id);
    List<Item> findByListaId(Long listaId);
}
