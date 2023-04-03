package com.MyApplication.ToDoList.domain.toDoList;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    public ToDoListDtoDetalhar persistToDoList(ToDoListDtoIncluir toDoList) {

        //ver se existe uma Lista com o mesmo nome e salva caso não seja encontrada
        if(toDoListRepository.findByName(toDoList.name()).isEmpty()){
            ToDoList paraSalvar = new ToDoList(toDoList);
            toDoListRepository.save(paraSalvar);
            return new ToDoListDtoDetalhar(
                    paraSalvar.getId(),
                    paraSalvar.getName(),
                    paraSalvar.getListas()
            );
        }
        return null;
    }

    public Page<ToDoList> findAll(Pageable page) {
        return toDoListRepository.findAll(page);
    }
    public ToDoList findById(Long id) {
        return toDoListRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "To Do List com o Id: " + id + " não encontrado") {
                        });
    }
}
