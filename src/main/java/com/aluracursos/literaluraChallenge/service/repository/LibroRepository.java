package com.aluracursos.literaluraChallenge.service.repository;

import com.aluracursos.literaluraChallenge.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitulo(String titulo);

    List<Libro> findByIdioma(String idioma);
}
