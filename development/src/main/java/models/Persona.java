package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Persona implements Comparable {
    // Atributos
    private int id;
    private String nombre;
    private int puntaje;
    private List<Pronostico> pronosticos = new ArrayList<>();
    private final List<Pronostico> pronosticosAcertados = new ArrayList<>();
    private Map<Ronda, Integer> puntajePorRonda = new HashMap<>();

    //Constructores
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

    //Getters y setters
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

    public Map<Ronda, Integer> getPuntajePorRonda() {
        return puntajePorRonda;
    }

    public void setPuntajePorRonda(Map<Ronda, Integer> puntajePorRonda) {
        this.puntajePorRonda = puntajePorRonda;
    }

    //Comportamientos
    public void addPronosticosAcertados(Pronostico pronosticoAcertado) {
        this.pronosticosAcertados.add(pronosticoAcertado);
    }

    //Sobreescritura metodos clase Object
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
            if (entry.getValue() == 0){continue;}
            dict_keys.add(entry.getKey());
        }

        List<Ronda> sortedDict_keys = dict_keys.stream().sorted().toList();

        for (Ronda sortedDictKey : sortedDict_keys) {
            sb.append("Ronda N°= ").append(sortedDictKey.getId())
                    .append(" - ").append("Puntaje: ").append(this.getPuntajePorRonda().get(sortedDictKey)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Persona otro = (Persona) o;
        String puntajePropio = String.valueOf(this.getPuntaje());
        String puntajeOtro = String.valueOf(otro.getPuntaje());
        return puntajeOtro.compareTo(puntajePropio);
    }
}
