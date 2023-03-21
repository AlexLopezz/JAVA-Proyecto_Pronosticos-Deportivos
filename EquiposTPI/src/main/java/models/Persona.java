package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int puntaje;

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

    public void setPuntaje(List<Pronostico> pronosticos) {
        int suma = 0;
        for (Pronostico pronostico : pronosticos){
            suma += pronostico.puntos();
        }
        this.puntaje = suma;
    }
}
