package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void addPuntaje(int puntaje){
        this.puntaje += puntaje;
    }

    public void addPronostico (Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        StringBuilder sb = new StringBuilder();

        sb.append("->Persona: ").append(this.nombre).append("\n")
                .append("-> Pronosticos: \n");
        this.pronosticos.forEach(sb::append);
        sb.append("\n");
        sb.append("-> Puntaje total de aciertos: ").append(this.puntaje).append("\n");
        sb.append("-> Pronosticos acertados: \n");
        this.pronosticosAcertados.forEach(sb::append);

        List<Ronda> dict_keys = new ArrayList<>();

        for(Map.Entry<Ronda, Integer> entry : this.getPuntajePorRonda().entrySet()){
            dict_keys.add(entry.getKey());
        }

        List<Ronda> sortedDict_keys = dict_keys.stream().sorted().toList();

        for (Ronda sortedDictKey : sortedDict_keys) {
            sb.append("Ronda N°= ").append(sortedDictKey.getId())
                    .append(" - ").append("Puntaje: ").append(this.getPuntajePorRonda().get(sortedDictKey)).append("\n");
        }
/*
        String rondaPuntaje ="";
        for(Map.Entry<Ronda, Integer> entry: this.getPuntajePorRonda().entrySet()){
            rondaPuntaje += "Ronda N°" + entry.getKey().getId() +
                    " - Puntaje: " + entry.getValue().toString() + "\n";
        }
        "\n-> Persona: "+this.nombre+
                "\n-> Pronosticos: \n"+ this.pronosticos+
                "\n-> Puntaje total de aciertos: "+ this.puntaje+
                "\n-> Pronosticos acertados: "+ this.pronosticosAcertados +
                "\n" + rondaPuntaje +
                "\n*********************";

 */
        return sb.toString();
    }
}
