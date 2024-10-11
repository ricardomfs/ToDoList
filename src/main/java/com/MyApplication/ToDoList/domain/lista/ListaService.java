package com.MyApplication.ToDoList.domain.lista;

import com.MyApplication.ToDoList.domain.lista.dtos.ListaDtoIncluir;
import com.MyApplication.ToDoList.domain.lista.dtos.ListaDtoUpdateIncluir;
import com.MyApplication.ToDoList.domain.myUser.MyUser;
import com.MyApplication.ToDoList.domain.myUser.MyUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {
    private final ListaRepository listaRepository;
    private final MyUserService myUserService;

    public ListaService(ListaRepository listaRepository, MyUserService myUserService) {
        this.listaRepository = listaRepository;
        this.myUserService = myUserService;
    }

    public Lista findByIdOrElseThrowNotFound(Long id) {
        return listaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Id: " + id + " não encontrada"));
    }

    public Lista findByName(String name, Long userId) {
        Optional<Lista> lista = listaRepository.findByNameAndMyUserId(name, userId);
        return lista.orElse(null);
    }

    @Transactional
    public Lista persistLista(ListaDtoIncluir dto) {
        String loggedUsername = myUserService
                .findBySecurityContext()
                .getUsername();
        //PRECISO INICIALIZAR UMA SESSION NO HIBERNATE
        MyUser byName = myUserService.findByUsername(loggedUsername);
        boolean listaJaExiste = this.findByName(dto.name(), byName.getId()) != null;
        if (listaJaExiste) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma lista com esse nome");
        }
        List<Lista> collectionListaDoUsuario = byName
                .getLista();
        Lista listaToPersist = new Lista(dto);
        listaToPersist.setMyUser(byName);
        collectionListaDoUsuario
                .add(listaToPersist);
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
        Lista listaToDelete = this.findByIdOrElseThrowNotFound(id);
        boolean listaUserIsEqualToLoggedUser = listaToDelete
                .getMyUser()
                .getUsername()
                .equals(myUserService
                        .findBySecurityContext()
                        .getUsername());
        if (!listaUserIsEqualToLoggedUser) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A lista de id: " + id + " não pertence a esse usuário");
        }
        listaRepository.delete(listaToDelete);
    }
}
