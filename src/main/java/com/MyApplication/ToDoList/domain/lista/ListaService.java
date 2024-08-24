package com.MyApplication.ToDoList.domain.lista;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ListaService {
    private final ListaRepository listaRepository;

    public ListaService(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public Lista findByIdOrElseThrowNotFound(Long id) {
        return listaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Id: " + id + " não encontrada"));
    }
    public Lista findByName(String name) {
        Optional<Lista> lista = listaRepository.findByName(name);
        return lista.orElse(null);
    }

    public Lista persistLista(ListaDtoIncluir dto) {
        Lista listaJaExiste = this.findByName(dto.name());
        if(listaJaExiste != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma lista com esse nome");
        }
        Lista listaToPersist = new Lista(dto);
        return listaRepository.save(listaToPersist);
    }
    public Page<Lista> findAll(Pageable page) {
        return listaRepository.findAll(page);
    }
    @Transactional
    public void updateLista(ListaDtoUpdateIncluir updateLista) {
        Lista lista = this.findByIdOrElseThrowNotFound(updateLista.id());
        lista.setName(updateLista.newName());
    }
    @Transactional
    public void deleteLista(Long id) {
        Lista lista = this.findByIdOrElseThrowNotFound(id);
        listaRepository.delete(lista);
    }
}
