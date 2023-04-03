package com.MyApplication.ToDoList.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item save(Item item){
        if(findByName(item.getName())==null){
            return itemRepository.save(item);
        }
        return null;
    }
    public Item findByName(String name){
        Optional<Item> item = itemRepository.findByName(name);
        return item.orElse(null);
    }
    public Page<Item> findAll(Pageable page){
        return itemRepository.findAll(page);
    }
    public Item findById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "item do id: "+ id +" não encontrado"){
                });
    }

    public Item updateItemByName(ItemDtoUpdateIncluir itemToUpdate) {
        Item item = this.findByName(itemToUpdate.oldName());

        if (itemToUpdate.newName().isBlank()) {
            item.setPrazo(itemToUpdate.newPrazo());
        } else {
            item.setName(itemToUpdate.newName());
        }
        item.setPrazo(itemToUpdate.newPrazo());
        return save(item);
    }
    public Item deleteItemByName(String name) {
        Item item = this.findByName(name);
        itemRepository.delete(item);
        return item;
    }
}
