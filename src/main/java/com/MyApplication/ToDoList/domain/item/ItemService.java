package com.MyApplication.ToDoList.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Page<ItemDtoDetalhar> findAll(Pageable page){
        List<Item> listas = itemRepository
                .findAll(page)
                .get()
                .toList();

        return new PageImpl<>(listas
                .stream()
                .map(ItemDtoDetalhar::new)
                .collect(Collectors.toList()));
    }
    public Item findByIdOrElseThrow(Long id){
        return itemRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "item do id: "+ id +" não encontrado"){
                });
    }
    @Transactional
    public void updateItemByName(ItemDtoUpdateIncluir dto) {
        Item itemToUpdate = Item.builder()
                .Id(dto.id())
                .name(dto.newName())
                .descricao(dto.descricao())
                .prazo(dto.newPrazo())
                .build();
    }
    @Transactional
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
