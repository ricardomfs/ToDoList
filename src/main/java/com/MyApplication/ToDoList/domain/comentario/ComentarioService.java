package com.MyApplication.ToDoList.domain.comentario;

import com.MyApplication.ToDoList.domain.item.Item;
import com.MyApplication.ToDoList.domain.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final ItemService itemService;

    public Comentario findByIdOrElseThrowBadRequest(Long id) {
        return comentarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentario de Id:" + id + "não encontrado!"));
    }
    @Transactional
    public Comentario persistComentario(ComentarioDtoIncluir dto) {
        Item item = itemService.findByIdOrElseThrowBadRequest(dto.item());

        Comentario comentarioToPersist = new Comentario(dto);
        comentarioToPersist.setItem(item);

        return comentarioRepository.save(comentarioToPersist);
    }
    @Transactional
    public void removeComentarioById(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Transactional
    public void updateComentario(ComentarioDtoUpdate dto) {
        Comentario comentarioToUpdate = this.findByIdOrElseThrowBadRequest(dto.id());
        comentarioToUpdate.setDescricao(dto.descricao());
    }
}
