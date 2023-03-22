package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int puntaje;
    private List<Pronostico> pronostico;

    public Persona(String nombre){
        this.nombre = nombre;
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

    public void setPuntaje() {
        int suma = 0;
        for (Pronostico pronostico : this.pronostico){
            suma += pronostico.puntos();
        }
        this.puntaje = suma;
    }

    public List<Pronostico> getPronostico() {
        return pronostico;
    }

    public void setPronostico(List<Pronostico> pronostico) {
        this.pronostico = pronostico;
    }
}
