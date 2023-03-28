package models;

import java.util.List;
import java.util.Objects;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo) {
        this.partido = partido;
        this.equipo = equipo;
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Pronostico(Equipo equipo, ResultadoEnum resultado) {
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Pronostico() {
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

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public int puntos(List<Partido> partidos){
        //Evalua los partidos junto a sus pronosticos y devuelve el puntaje obtenido.
        int puntos = 0;
        for(Partido partido : partidos){
            if(this.partido.equals(partido)) {
                if(this.equipo.equals(partido.getEquipo1())){
                    if(this.resultado.equals(partido.resultado(partido.getEquipo1()))){
                        puntos++;
                    }
                }else if(this.equipo.equals(partido.getEquipo2())){
                    if(this.resultado.equals(partido.resultado(partido.getEquipo2()))){
                        puntos++;
                    }
                }
            }
        }
        return puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pronostico that = (Pronostico) o;
        return Objects.equals(partido, that.partido) && Objects.equals(equipo, that.equipo) && resultado == that.resultado;
    }

    @Override
    public String toString() {
        return "partido= [" +partido.getEquipo1() +" vs " +partido.getEquipo2()+" ]"+
                "\nequipo=" + equipo +
                "\nresultado=" + resultado;
    }
}
