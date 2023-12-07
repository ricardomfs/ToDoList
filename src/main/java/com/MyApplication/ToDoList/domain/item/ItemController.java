package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.item.ItemDtoIncluir;
import com.MyApplication.ToDoList.domain.item.ItemDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.item.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDtoDetalhar> persistItem(@RequestBody @Valid ItemDtoIncluir itemDto) {
        return ResponseEntity.ok(new ItemDtoDetalhar(itemService.save(new Item(itemDto))));
    }

    @GetMapping(path = "/")
    public ResponseEntity<Page<ItemDtoDetalhar>> findAll(Pageable page) {
        return ResponseEntity.ok((itemService.findAll(page)));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemDtoDetalhar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ItemDtoDetalhar(itemService.findByIdOrElseThrow(id)));
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<ItemDtoDetalhar> updateItem(@RequestBody @Valid ItemDtoUpdateIncluir itemToUpdate) {
        itemService.updateItemByName(itemToUpdate);
        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<ItemDtoDetalhar> deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
