package models;

import java.util.Objects;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo) {
        this.partido = partido;
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(String resultado1, String resultado2, String resultado3) {
        if (resultado1.equals("X")){
            this.resultado = ResultadoEnum.Ganador;
        } else if (resultado2.equals("X")){
            this.resultado = ResultadoEnum.Empate;
        } else {
            this.resultado = ResultadoEnum.Perdedor;
        }
    }
    public int puntos(){
        return partido.resultado(this.equipo) == this.resultado ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pronostico that = (Pronostico) o;
        return Objects.equals(partido, that.partido) && Objects.equals(equipo, that.equipo) && resultado == that.resultado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partido, equipo, resultado);
    }
}
