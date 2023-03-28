package models;

import java.util.Objects;

public class Equipo {

    private String nombre;
    private String descripcion;
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Equipo equipo) {
            return Objects.equals(nombre, equipo.nombre);
        }else {
            return false;
        }
    }
}
