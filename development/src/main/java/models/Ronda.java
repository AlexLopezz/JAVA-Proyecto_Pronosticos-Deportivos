package models;

import java.util.ArrayList;
import java.util.List;


public class Ronda implements Comparable {
    //Atributos
    private int id;
    private String descripcion;
    private List<Partido> partidos;
    private Fase fase;

    //Constructores
    public Ronda(int id) {
        this.id = id;
        this.partidos = new ArrayList<>();
    }

    public Ronda(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.partidos = new ArrayList<>();
    }

    public Ronda(int id, String descripcion, List<Partido> partidos, Fase fase) {
        this.id = id;
        this.descripcion = descripcion;
        this.partidos = partidos;
        this.fase = fase;
    }

    public Ronda(int id, List<Partido> partidos) {
        this.id = id;
        this.partidos = partidos;
    }

    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    //Comportamientos
    public void addPartido(Partido partido){
        this.partidos.add(partido);
    }

    //Sobreescritura metodos clase Object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Partidos: ").append("Ronda N° ").append(this.id).append("\n");

        for(Partido p : this.partidos){
            sb.append(p)
                    .append(" Resultado: ")
                    .append(p.getGolesEquipo1())
                    .append(" - ")
                    .append(p.getGolesEquipo2())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Ronda ronda = (Ronda) o;
        String rondaPropia = String.valueOf(this.getId());
        String rondaAjena = String.valueOf(ronda.getId());
        return rondaPropia.compareTo(rondaAjena);
    }
}
