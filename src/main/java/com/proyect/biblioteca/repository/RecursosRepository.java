package com.proyect.biblioteca.repository;

import com.proyect.biblioteca.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecursosRepository extends ReactiveMongoRepository<Recurso, String> {
}
