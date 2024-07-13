package com.aluracursos.literaluraChallenge.controllers;

import com.aluracursos.literaluraChallenge.models.dto.BookResultados;
import com.aluracursos.literaluraChallenge.service.APIConsumer;
import com.aluracursos.literaluraChallenge.service.JSONToClass;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MenuController {
    private static final Scanner userInput = new Scanner(System.in);

    private static JSONToClass parser = new JSONToClass();

    public static void getLibroFromAPI() throws UnsupportedEncodingException {
        String urlAPI = "https://gutendex.com/books/";
        System.out.println("Intoduce el nombre del libro: ");
        String busqueda = userInput.nextLine();

        busqueda = URLEncoder.encode(busqueda, StandardCharsets.UTF_8);

        System.out.println("\nBuscando ...\n");

        var response = APIConsumer.getDataFrom(urlAPI + "?search=" + busqueda);

        var resultados = parser.parseTo(response, BookResultados.class);

        if(resultados.books().isEmpty()) {
            System.out.println("\nLibro no encontrado\n");
            return;
        }

        DBcontroller.guardar(resultados);
    }

    public static void getAutores() {
        var autores = DBcontroller.getAutores();

        if (autores.isEmpty()) {
            System.out.println("\nNo hay autores registrados\n");
            return;
        }

        autores.forEach(System.out::println);
    }

    public static void getLibros() {
        var libros = DBcontroller.getLibros();

        if (libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados\n");
            return;
        }

        libros.forEach(System.out::println);
    }

    public static void getAutoresVivos() {
        System.out.println("Intoduce año deseado: ");
        Integer year = userInput.nextInt();
        userInput.nextLine();
        var autoresVivos = DBcontroller.getAutoresVivos(year);

        if (autoresVivos.isEmpty()) {
            System.out.println("\nNo hay autores registrados que vivieran durante el año " + year + "\n");
            return;
        }

        autoresVivos.forEach(System.out::println);
    }

    public static void getLibrosIdioma() {
        System.out.println("Intoduce el idioma deseado por ejemplo \"en\"");
        String idioma = userInput.nextLine();
        var librosIdioma = DBcontroller.getLibrosByIdioma(idioma);

        if (librosIdioma.isEmpty()) {
            System.out.println("\nNo hay libros registarados con el idioma" + idioma +"\n");
            return;
        }

        librosIdioma.forEach(System.out::println);
    }
}
