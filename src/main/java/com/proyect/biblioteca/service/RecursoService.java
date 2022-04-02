package com.proyect.biblioteca.service;

import com.proyect.biblioteca.model.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoService {
    Flux<Recurso> findAll();

    Mono<Recurso> save(Recurso recurso);

    Mono<Recurso> delete(String id);

    Mono<Recurso> update(String id, Recurso recurso);

    Mono<Recurso> findById(String id);
}

