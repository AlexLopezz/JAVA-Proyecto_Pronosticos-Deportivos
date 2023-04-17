package models;

import java.util.Objects;

public class Equipo {
    // Atributos
    private String nombre;
    private String descripcion;

    //Constructores
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    //Geterrs y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //Sobreescritura metodos clase Object
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
