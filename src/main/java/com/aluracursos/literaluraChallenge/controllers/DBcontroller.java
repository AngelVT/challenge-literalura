package com.aluracursos.literaluraChallenge.controllers;

import com.aluracursos.literaluraChallenge.models.Autor;
import com.aluracursos.literaluraChallenge.models.Libro;
import com.aluracursos.literaluraChallenge.models.dto.AutorFromResponse;
import com.aluracursos.literaluraChallenge.models.dto.BookResultados;
import com.aluracursos.literaluraChallenge.models.dto.LibrosFromResponse;
import com.aluracursos.literaluraChallenge.service.repository.AutorRepository;
import com.aluracursos.literaluraChallenge.service.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DBcontroller {
    private static LibroRepository libroRepository;
    private static AutorRepository autorRepository;

    @Autowired
    public DBcontroller(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public static void guardar(BookResultados resultados) {
        var libro = new Libro(resultados.books().get(0));
        var autor = new Autor(resultados.books().get(0).autores().get(0));

        if(!libroRepository.findByTitulo(libro.getTitulo()).isEmpty()) {
            System.out.println("\nEste Libro ya existe\n");
            return;
        }

        libro.setAutores(autor);
        autor.setLibro(libro);

        libroRepository.save(libro);
        autorRepository.save(autor);

        System.out.println("Libro guardado");
        System.out.println(libro);
    }

    public static List<Autor> getAutores() {
        return autorRepository.findAutores();
    }

    public static List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public static List<Autor> getAutoresVivos(Integer year) {
        return autorRepository.findAutoresVivos(year);
    }

    public static List<Libro> getLibrosByIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
