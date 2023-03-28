package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int puntaje;
    private List<Pronostico> pronosticos;
    private List<Pronostico> pronosticosAcertados = new ArrayList<Pronostico>();


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

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void addPronostico (Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    public List<Pronostico> getPronostico() {
        return this.pronosticos;
    }

    public void setPronostico(List<Pronostico> pronostico) {
        this.pronosticos = pronostico;
    }

    public List<Pronostico> getPronosticosAcertados() {
        return pronosticosAcertados;
    }

    public void addPronosticosAcertados(Pronostico pronosticoAcertado) {
        this.pronosticosAcertados.add(pronosticoAcertado);
    }

    @Override
    public String toString() {
        return "\n*********************" +
                "\nPersona: "+this.nombre+
                "\nPronosticos: "+ this.pronosticos+
                "\nPuntaje total de aciertos: "+ this.puntaje+
                "\nPronosticos acertados: "+ this.pronosticosAcertados +
                "\n*********************";
    }
}
