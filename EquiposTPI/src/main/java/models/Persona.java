package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {
    private String nombre;
    private int puntaje;
    private List<Pronostico> pronosticos;
    private List<Pronostico> pronosticosAcertados = new ArrayList<Pronostico>();
    private Map<Ronda,Integer> puntajePorRonda;

    public Persona(String nombre){
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }
    public Persona(){
        this.pronosticos = new ArrayList<>();
        this.puntajePorRonda = new HashMap<>();
    }

    public Persona(String nombre, List<Pronostico> pronostico) {
        this.nombre = nombre;
        this.pronosticos = pronostico;
        this.puntajePorRonda = new HashMap<>();
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
        for(Map.Entry<Ronda,Integer>entry: this.getPuntajePorRonda().entrySet()){
            rondaPuntaje+= "Ronda " + entry.getKey().getNro() +
                    ": " + entry.getValue().toString() + "\n";
        }
        return "\n*********************" +
                "\nPersona: "+this.nombre+
                "\nPronosticos: "+ this.pronosticos+
                "\nPuntaje total de aciertos: "+ this.puntaje+
                "\nPronosticos acertados: "+ this.pronosticosAcertados +
                "\n" + rondaPuntaje +
                "\n*********************";
    }
}
