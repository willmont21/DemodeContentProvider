package com.example.demodecontentprovider;

public class Estudiante {

    String Nombre;
    String Carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, String carrera) {
        Nombre = nombre;
        Carrera = carrera;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }
}
