package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int puntaje;
<<<<<<< HEAD
    private List<Pronostico> pronostico;
=======
    private List<Pronostico> pronosticos;
>>>>>>> alex

    public Persona(String nombre){
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }
    public Persona(){
        this.pronosticos = new ArrayList<>();
    }

    public Persona(String nombre, List<Pronostico> pronostico) {
        this.nombre = nombre;
        this.pronosticos = pronostico;
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

<<<<<<< HEAD
    public void setPuntaje() {
        int suma = 0;
        for (Pronostico pronostico : this.pronostico){
            suma += pronostico.puntos();
        }
        this.puntaje = suma;
=======
    public void setPronostico(List<Pronostico> pronostico) {
        this.pronosticos = pronostico;
    }

    public void addPronostico (Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", pronosticos=" + pronosticos +
                '}';
>>>>>>> alex
    }

    public List<Pronostico> getPronostico() {
        return pronostico;
    }

    public void setPronostico(List<Pronostico> pronostico) {
        this.pronostico = pronostico;
    }
}
