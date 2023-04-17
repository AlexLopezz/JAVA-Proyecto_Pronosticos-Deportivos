package models;

import java.util.List;
import java.util.Objects;


public class Pronostico {
    //Atributos
    private int id;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private int idRonda;
    private int idFase;

    //Constructores

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

    public Pronostico(int id, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.id = id;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Pronostico(int id, Partido partido, Equipo equipo, ResultadoEnum resultado, int idRonda, int idFase) {
        this.id = id;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.idRonda = idRonda;
        this.idFase = idFase;
    }

    public Pronostico() {
    }

    //Getters y setters
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

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    //Comportamientos
    public int puntos(List<Partido> partidos){
        //Evalua los partidos junto a sus pronosticos y devuelve el puntaje obtenido.
        int puntos = 0;
        Partido partidoEncontrado = this.obtenerPartidoPronostico(partidos);

        if (partidoEncontrado != null){
            if(this.pronosticoAcertado(partidoEncontrado)){
                puntos++;
            }
        }

        return puntos;
    }

    public int puntosPartido(Partido partido){
        if(this.pronosticoAcertado(partido)){
            return 1;
        } else {
            return -1;
        }
    }

    public Partido obtenerPartidoPronostico (List <Partido> partidos){
        return partidos.stream().filter(
                        p -> p.equals(this.partido))
                .findAny().orElse(null);
    }

    public boolean pronosticoAcertado (Partido partido){
        return this.resultado.equals(partido.resultado(partido.getEquipo1()));
    }

    //Sobreescritura metodos clase Object
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pronostico that = (Pronostico) o;
        return Objects.equals(partido, that.partido) && Objects.equals(equipo, that.equipo) && resultado == that.resultado;
    }

    @Override
    public String toString() {
        return "[*Partido: " +partido.getEquipo1() +" vs " +partido.getEquipo2()+
                "\n*Equipo: " + equipo +
                "\n*Resultado: " + resultado+"]\n";
    }
}
