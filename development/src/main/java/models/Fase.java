package models;

public class Fase {
    private int idFase;
    private String descripcion;

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
}
