package com.alura.literatura;


public class Autor {
    private String nombre;
    private int anioNacimiento;
    private int anioMuerte;

    public Autor(String nombre, int anioNacimiento, int anioMuerte) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioMuerte = anioMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public int getAnioMuerte() {
        return anioMuerte;
    }

    @Override
    public String toString() {
        return nombre + " (" + anioNacimiento + " - " + anioMuerte + ")";

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public void setAnioMuerte(int anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

}

