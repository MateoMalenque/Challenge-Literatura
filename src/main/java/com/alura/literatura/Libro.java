package com.alura.literatura;

import java.util.List;

public class Libro {
    private String titulo;
    private String idioma;
    private int numeroDescargas;
    private List<Autor> autores;

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }
    public Libro(String titulo, String idioma, int numeroDescargas, List<Autor> autores) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDescargas = numeroDescargas;
        this.autores = autores;
    }

}

