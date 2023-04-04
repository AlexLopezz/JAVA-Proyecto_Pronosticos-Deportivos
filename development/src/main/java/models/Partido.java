package models;

import java.util.Objects;

public class Partido {
    private Long id;

    private Equipo equipo1;

    private Equipo equipo2;

    private int golesEquipo1;

    private int golesEquipo2;
    private Fase fase;
    private Ronda ronda;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, Fase fase, Ronda ronda) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.fase = fase;
        this.ronda = ronda;
    }

    public Partido(Long id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, Fase fase, Ronda ronda) {
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.fase = fase;
        this.ronda = ronda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    public ResultadoEnum resultado(Equipo equipo) {
        //Retorna el resultado del equipo que se pasó como argumento solo sí el equipo pertenece al encuentro.
        if(this.equipo1.equals(equipo)){
            if(golesEquipo1 == golesEquipo2) {
                return ResultadoEnum.Empate;
            }else if(golesEquipo1 > golesEquipo2){
                return ResultadoEnum.Ganador;
            }else{
                return ResultadoEnum.Perdedor;
            }
        } else if (this.equipo2.equals(equipo)) {
            if(golesEquipo2 == golesEquipo1) {
                return ResultadoEnum.Empate;
            }else if(golesEquipo2 > golesEquipo1){
                return ResultadoEnum.Ganador;
            }else{
                return ResultadoEnum.Perdedor;
            }
        }
        return null;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Partido partido) {
            return this.equipo1.equals(partido.getEquipo1()) && this.equipo2.equals(partido.getEquipo2());
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "["+this.equipo1+"("+this.golesEquipo1+") vs ("+this.golesEquipo2+")"+this.equipo2+"]";
    }
}
