package models;

import java.util.ArrayList;
import java.util.List;

public class Fase {
    private int idFase;
    private String descripcion;
    private List<Ronda> rondas = new ArrayList<>();

    public Fase(int idFase, String descripcion) {
        this.idFase = idFase;
        this.descripcion = descripcion;
    }

    public Fase() {
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }
    public void addRonda(Ronda ronda){
        this.rondas.add(ronda);
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "*Fase N° = ").append(this.idFase).append("\n")
                .append("Descripcion = ").append(this.descripcion).append("\n")
                .append("Rondas: ").append("\n");
        this.rondas.forEach(sb::append);

        return sb.toString();
    }
}
