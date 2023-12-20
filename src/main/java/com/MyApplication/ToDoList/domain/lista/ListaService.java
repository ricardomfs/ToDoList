package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.projeto.Projeto;
import com.MyApplication.ToDoList.domain.projeto.ProjetoService;
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
public class ListaService {
    private final ListaRepository listaRepository;
    private final ProjetoService projetoService;

    public Lista persistLista(ListaDtoIncluir lista) {
        Projeto projeto = projetoService.findByIdOrThrowBadRequest(lista.projeto());
        Lista listaVerificar = this.findByName(lista.name());
        if (listaVerificar != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma lista com esse nome!");
        }
        Lista listaToSave = new Lista(lista);
        listaToSave.setProjeto(projeto);
        projeto
                .getListas()
                .add(listaToSave);

        return listaRepository.save(listaToSave);
    }

    public Lista findByName(String name) {
        Optional<Lista> lista = listaRepository.findByName(name);

        return lista.orElse(null);
    }

    public Page<ListaDtoDetalhar> findAll(Pageable page) {
        List<Lista> listas = listaRepository
                .findAll(page)
                .get()
                .toList();

        return new PageImpl<>(listas
                .stream()
                .map(ListaDtoDetalhar::new)
                .collect(Collectors.toList()));
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
