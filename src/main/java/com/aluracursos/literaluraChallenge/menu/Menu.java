package com.aluracursos.literaluraChallenge.menu;

import com.aluracursos.literaluraChallenge.service.APIConsumer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Menu {
    private static final Scanner userInput = new Scanner(System.in);

    public void showMainMenu() throws UnsupportedEncodingException {
        boolean isRunning = true;
        int option;

        String menu = """
                *---------------------------------------------------*
                | Introduce el numero de la opcion deseada:         |
                |     1.- Buscar libro por titulo (Desde API)       |
                |     2.- Listar libros registrados                 |
                |     3.- Listar autores registrados                |
                |     4.- Listar autores vivos de un año especifico |
                |     5.- Listar libros por idioma                  |
                |     0.- Salir                                     |
                *---------------------------------------------------*""";
        while (isRunning) {
            System.out.println(menu);

            try {
                option = userInput.nextInt();
            } catch (Exception e) {
                option = -1;
            }
            userInput.nextLine();

            switch (option) {
                case 1:
                    getLibroFromAPI();
                    break;
                case 2:
                    System.out.println("\nConsultando libros en DB ...\n");
                    break;
                case 3:
                    System.out.println("\nConsultando autores en DB ...\n");
                    break;
                case 4:
                    System.out.println("\nConsultando autores vivos en DB ...\n");
                    break;
                case 5:
                    System.out.println("\nConsultando libros por idioma en DB ...\n");
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nLa Opcion introducida no es valida.\n");
                    break;
            }
        }
    }

    public static void getLibroFromAPI() throws UnsupportedEncodingException {
        String urlAPI = "https://gutendex.com/books/";
        System.out.println("Intoduce el nombre del libro o autor");
        String busqueda = userInput.nextLine();

        busqueda = URLEncoder.encode(busqueda, StandardCharsets.UTF_8);

        System.out.println("\nBuscando ...\n");

        var response = APIConsumer.getDataFrom(urlAPI + "?search=" + busqueda);

        System.out.println(response);
    }
}
