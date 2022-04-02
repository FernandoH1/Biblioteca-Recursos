package com.proyect.biblioteca.service.Impl;

import com.proyect.biblioteca.model.Recurso;
import com.proyect.biblioteca.repository.RecursosRepository;
import com.proyect.biblioteca.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    RecursosRepository recursosRepository;

    @Override
    public Flux<Recurso> findAll() {
        return this.recursosRepository.findAll();
    }

    @Override
    public Mono<Recurso> save(Recurso recurso) {
        return this.recursosRepository.save(recurso);
    }

    @Override
    public Mono<Recurso> delete(String id) {
        return this.recursosRepository
                .findById(id)
                .flatMap(recurso -> this.recursosRepository.deleteById(recurso.getId()).thenReturn(recurso));

    }

    @Override
    public Mono<Recurso> update(String id, Recurso recurso) {
        return this.recursosRepository.findById(id)
                .flatMap(recurso1 -> {
                    recurso.setId(id);
                    return save(recurso);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Recurso> findById(String id) {
        return this.recursosRepository.findById(id);
    }
}
