package com.MyApplication.ToDoList.domain.item;

import com.MyApplication.ToDoList.domain.lista.Lista;
import com.MyApplication.ToDoList.domain.lista.ListaService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ListaService listaService;

    public ItemService(ItemRepository itemRepository, ListaService listaService) {
        this.itemRepository = itemRepository;
        this.listaService = listaService;
    }

    public Item findByIdOrElseThrowBadRequest(Long id) {
        return itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de Id: " + id + " não encontrado"));
    }

    public List<Item> findByLista(Long listaId) {
        return itemRepository.findByListaId(listaId);
    }

    public Item findByNameAndListaId(String name, Long listaId) {
        Optional<Item> item = itemRepository.findByNameAndListaId(name, listaId);
        return item.orElse(null);
    }

    @Transactional
    public Item save(ItemDtoIncluir dto) {
        Item item = this.findByNameAndListaId(dto.name(), dto.listaId());
        if (item != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item já existe nessa lista");
        }

        item = new Item(dto);
        Lista lista = listaService.findByIdOrElseThrowNotFound(dto.listaId());
        item.setLista(lista);
        lista
                .getItens()
                .add(item);
        return itemRepository.save(item);
    }

    public Page<Item> findAll(Pageable page) {
        return itemRepository.findAll(page);
    }

    @Transactional
    public void updateItemByName(ItemDtoUpdateIncluir itemToUpdate) {
        Item item = this.findByNameAndListaId(itemToUpdate.oldName(), itemToUpdate.idLista());

        if (!itemToUpdate
                .newName()
                .isBlank()) {
            item.setName(itemToUpdate.newName());
        }
        if (itemToUpdate
                .newPrazo() != null
        ) {
            item.setName(itemToUpdate.newName());
        }
        item.setPrazo(itemToUpdate.newPrazo());
    }
    @Transactional
    public void deleteItemByName(String name, Long listaId) {
        Item item = this.findByNameAndListaId(name, listaId);
        itemRepository.delete(item);
    }
}
