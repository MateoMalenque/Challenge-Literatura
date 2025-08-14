package com.alura.literatura;



import com.alura.literatura.Libro;
import com.alura.literatura.Autor;
import com.alura.literatura.GutendexService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GutendexService service = new GutendexService();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Elija la opción a través de su número:");
            System.out.println("1- buscar libro por título");
            System.out.println("2- Listar libros registrados");
            System.out.println("3- Listar autores registrados");
            System.out.println("4- Listar autores vivos en un determinado año");
            System.out.println("5- Listar libros por idioma");
            System.out.println("0- salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = sc.nextLine();
                    List<Libro> libros = service.buscarLibroPorTitulo(titulo);
                    libros.forEach(libro -> {
                        System.out.println("Título: " + libro.getTitulo());
                        System.out.println("Idioma: " + libro.getIdioma());
                        System.out.println("Descargas: " + libro.getNumeroDescargas());
                        System.out.println("Autores:");
                        libro.getAutores().forEach(a -> System.out.println(" - " + a.getNombre()));
                        System.out.println("------");
                    });

                    break;
                // Los demás casos los vas armando luego
            }

        } while (opcion != 0);
    }
}
