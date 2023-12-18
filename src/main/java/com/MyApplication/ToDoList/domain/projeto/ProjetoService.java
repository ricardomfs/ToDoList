package com.MyApplication.ToDoList.domain.projeto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    public Projeto persistToDoList(ProjetoDtoIncluir projeto) {

        //ver se existe uma Lista com o mesmo nome e salva caso não seja encontrada
        if(projetoRepository
                .findByName(projeto.name()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Projeto de mesmo nome encontrado!");
        }
        Projeto paraSalvar = new Projeto(projeto);

        return projetoRepository.save(paraSalvar);
    }

    public Page<Projeto> findAll(Pageable page) {
        return projetoRepository.findAll(page);
    }
    public Projeto findByIdOrThrowBadRequest(Long id) {
        return projetoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "To Do List com o Id: " + id + " não encontrado") {
                        });
    }
}
