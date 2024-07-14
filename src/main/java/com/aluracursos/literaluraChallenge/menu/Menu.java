package com.aluracursos.literaluraChallenge.menu;

import com.aluracursos.literaluraChallenge.controllers.MenuController;
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
                |     6.- Buscar Autores por nombre                 |
                |     7.- VerTop 10 libros mas descargados          |
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
                    MenuController.getLibroFromAPI();
                    break;
                case 2:
                    MenuController.getLibros();
                    break;
                case 3:
                    MenuController.getAutores();
                    break;
                case 4:
                    MenuController.getAutoresVivos();
                    break;
                case 5:
                    MenuController.getLibrosIdioma();
                    break;

                case 6:
                    MenuController.getAutoresPorNombre();
                    break;
                case 7:
                    MenuController.getTop10Libros();
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
}
