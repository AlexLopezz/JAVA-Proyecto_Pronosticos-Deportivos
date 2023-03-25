package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int puntaje;
    private Pronostico[] pronostico;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public Persona(String nombre, Pronostico[] pronostico) {
        this.nombre = nombre;
        this.pronostico = pronostico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPronostico(Pronostico[] pronostico) {
        this.pronostico = pronostico;
    }
}
