package com.MyApplication.ToDoList.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item save(Item item){
        return itemRepository.save(item);
    }
    public Page<Item> findAll(Pageable page){
        return itemRepository.findAll(page);
    }
    public Item findById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(()-> new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "item do id: "+ id +" não encontrado"){
                });
    }
}
