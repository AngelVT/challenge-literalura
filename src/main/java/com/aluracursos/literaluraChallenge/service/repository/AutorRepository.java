package com.aluracursos.literaluraChallenge.service.repository;

import com.aluracursos.literaluraChallenge.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNombre(String nombre);

    @Query("""
            SELECT a FROM Autor a 
            WHERE :year BETWEEN a.anoNacimiento AND a.anoMuerte
            """)
    List<Autor> findAutoresVivos(Integer year);

    List<Autor> findByNombreContainingIgnoreCase(String nombre);

}
