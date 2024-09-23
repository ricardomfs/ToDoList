package com.MyApplication.ToDoList.domain.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNameAndListaId(String name, Long id);
    Page<Item> findByListaId(Long listaId, Pageable pageable);
}
