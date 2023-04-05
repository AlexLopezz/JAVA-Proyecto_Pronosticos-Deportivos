package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ronda {
    private String nro;
    private String descripcion;
    private List<Partido> partidos;
    private Fase fase;

    public Ronda(String nro) {
        this.nro = nro;
        this.partidos = new ArrayList<>();
    }

    public Ronda(String nro, String descripcion) {
        this.nro = nro;
        this.descripcion = descripcion;
        this.partidos = new ArrayList<>();
    }

    public Ronda(String nro, String descripcion, List<Partido> partidos, Fase fase) {
        this.nro = nro;
        this.descripcion = descripcion;
        this.partidos = partidos;
        this.fase = fase;
    }

    public Ronda(String nro, List<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void addPartido(Partido partido){
        this.partidos.add(partido);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Partidos: ").append("Ronda N° ").append(this.nro).append("\n");

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
}
