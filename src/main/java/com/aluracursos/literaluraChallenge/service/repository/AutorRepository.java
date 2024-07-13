package com.aluracursos.literaluraChallenge.service.repository;

import com.aluracursos.literaluraChallenge.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("""
    SELECT a FROM Autor a 
    WHERE a.id IN (
        SELECT MIN(a2.id) FROM Autor a2 
        GROUP BY a2.nombre, a2.anoNacimiento, a2.anoMuerte
    )""")
    List<Autor> findAutores();

    @Query("SELECT DISTINCT a FROM Autor a " +
            "WHERE :year BETWEEN a.anoNacimiento AND a.anoMuerte " +
            "AND a.id IN (SELECT MIN(a2.id) FROM Autor a2 " +
            "GROUP BY a2.nombre, a2.anoNacimiento, a2.anoMuerte)")
    List<Autor> findAutoresVivos(Integer year);
}
