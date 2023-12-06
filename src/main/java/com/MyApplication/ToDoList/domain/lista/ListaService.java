package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.item.ItemDtoIncluir;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaService {
    private final ListaRepository listaRepository;

    public Lista persistLista(ListaDtoIncluir lista) {
        Lista listaVerificar = findByName(lista.name());
        if (listaVerificar != null) {
            throw new RuntimeException("Lista com o nome: " + lista.name() + " ja existe!");
        } else {
            return listaRepository.save(new Lista(lista));
        }
    }

    public Lista findByName(String name) {
        Optional<Lista> lista = listaRepository.findByName(name);
        return lista.isPresent() ? lista.get() : null;
    }

    public Page<Lista> findAll(Pageable page) {
        return listaRepository.findAll(page);
    }

    public Lista findByIdOrElseThrowBadRequest(Long id) {
        return listaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lista de Id: " + id + "não encontrada"));
    }

    @Transactional
    public void updateLista(ListaDtoUpdateIncluir updateLista) {
        Lista lista = this.findByIdOrElseThrowBadRequest(updateLista.id());
        lista.setName(updateLista.newName());
    }
    @Transactional
    public void deleteLista(String name) {
        Lista lista = this.findByName(name);
        listaRepository.delete(lista);
    }
}
