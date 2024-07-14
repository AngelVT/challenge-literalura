package com.aluracursos.literaluraChallenge.controllers;

import com.aluracursos.literaluraChallenge.models.Autor;
import com.aluracursos.literaluraChallenge.models.Libro;
import com.aluracursos.literaluraChallenge.models.dto.BookResultados;
import com.aluracursos.literaluraChallenge.service.repository.AutorRepository;
import com.aluracursos.literaluraChallenge.service.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DBcontroller {
    private static LibroRepository libroRepository;
    private static AutorRepository autorRepository;

    @Autowired
    public DBcontroller(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    public static void guardar(BookResultados resultados) {
        var libroReq = resultados.books().get(0);
        var autorReq = resultados.books().get(0).autores().get(0);

        var libroDB = libroRepository.findByTitulo(libroReq.titulo());
        var autorDB = autorRepository.findByNombre(autorReq.nombre());

        System.out.println("xd");
        System.out.println(resultados.books().get(0).idiomas());

        if (!libroDB.isEmpty() && !autorDB.isEmpty()) {
            System.out.println("\nEl libro ya existe\n");
            return;
        }

        if (!autorDB.isEmpty()) {
            var autor = autorDB.get(0);

            for (String i : resultados.books().get(0).idiomas())  {
                var libro = new Libro(libroReq, i);
                autor.setLibro(libro);
                libro.setAutores(autor);
                libroRepository.save(libro);

                showSavedBook(libro);
            }
        } else {
            var autor = new Autor(autorReq);

            autorRepository.save(autor);
            for (String i : resultados.books().get(0).idiomas())  {
                var libro = new Libro(libroReq, i);
                libro.setAutores(autor);
                autor.setLibro(libro);
                libroRepository.save(libro);

                showSavedBook(libro);
            }
        }
    }

    public static List<Autor> getAutores() {
        return autorRepository.findAll();
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

    public static void showSavedBook(Libro libro) {
        System.out.println("\nLibro guardado\n");
        System.out.println(libro);
    }

    public static List<Autor> searchAutoresByName(String nombre) {
        return autorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
