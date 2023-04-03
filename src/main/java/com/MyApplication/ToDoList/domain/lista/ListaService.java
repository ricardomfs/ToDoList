package com.MyApplication.ToDoList.domain.lista;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListaService {
    private final ListaRepository listaRepository;

}
