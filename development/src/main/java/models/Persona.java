package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {
    private int id;
    private String nombre;
    private int puntaje;
    private List<Pronostico> pronosticos = new ArrayList<>();
    private List<Pronostico> pronosticosAcertados = new ArrayList<>();
    private Map<Ronda, Integer> puntajePorRonda = new HashMap<>();

    public Persona(String nombre){
        this.nombre = nombre;
    }
    public Persona(){
    }

    public Persona(String nombre, List<Pronostico> pronostico) {
        this.nombre = nombre;
        this.pronosticos = pronostico;
    }

    public Persona(int id, String nombre) {
        this.id = id;
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

    public Map<Ronda, Integer> getPuntajePorRonda() {
        return puntajePorRonda;
    }

    public void setPuntajePorRonda(Map<Ronda, Integer> puntajePorRonda) {
        this.puntajePorRonda = puntajePorRonda;
    }

    @Override
    public String toString() {
        String rondaPuntaje ="";
        for(Map.Entry<Ronda, Integer> entry: this.getPuntajePorRonda().entrySet()){
            rondaPuntaje+= "Ronda N°" + entry.getKey().getId() +
                    " - Puntaje: " + entry.getValue().toString() + "\n";
        }
        return "\n*********************" +
                "\n-> Persona: "+this.nombre+
                "\n-> Pronosticos: "+ this.pronosticos+
                "\n-> Puntaje total de aciertos: "+ this.puntaje+
                "\n-> Pronosticos acertados: "+ this.pronosticosAcertados +
                "\n" + rondaPuntaje +
                "\n*********************";
    }
}
