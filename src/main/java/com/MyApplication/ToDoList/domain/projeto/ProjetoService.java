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
    public ProjetoDtoDetalhar persistToDoList(ProjetoDtoIncluir projeto) {

        //ver se existe uma Lista com o mesmo nome e salva caso não seja encontrada
        if(projetoRepository
                .findByName(projeto.name()).isEmpty()){
            Projeto paraSalvar = new Projeto(projeto);
            projetoRepository.save(paraSalvar);
            return new ProjetoDtoDetalhar(paraSalvar);
        }
        return null;
    }

    public Page<Projeto> findAll(Pageable page) {
        return projetoRepository.findAll(page);
    }
    public Projeto findById(Long id) {
        return projetoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "To Do List com o Id: " + id + " não encontrado") {
                        });
    }
}
