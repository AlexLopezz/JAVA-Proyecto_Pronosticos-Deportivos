package resources.classUtility;

import exceptions.RondaException;
import models.*;
import repositories.PronosticoRepositorio;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase utilizada para generar algunos objetos de manera sencilla a partir de un array de strings.
public class Utilities {

    //Generar un partido.
    public static Partido generatePartido(String[] dataPartido) {
        return new Partido(
                new Equipo(dataPartido[0]),
                new Equipo(dataPartido[1]),
                Integer.parseInt(dataPartido[2]),
                Integer.parseInt(dataPartido[3])
        );
    }

    //Generar un pronostico.
    public static Pronostico generatePronostico(String[] dataPronostico) {
        return new Pronostico(new Partido(new Equipo(dataPronostico[0]),
                                          new Equipo(dataPronostico[1])),
                              new Equipo(dataPronostico[0]),
                              checkStadistics(dataPronostico[2],
                                                      dataPronostico[3]));
    };
    public static HashMap<String, Integer> getScoring(String[] fileItems) throws IOException {
        HashMap<String, Integer> scoring = new HashMap<>();

        scoring.put("Puntaje por Resultado", Integer.parseInt(fileItems[3]));
        scoring.put("Puntaje por Ronda", Integer.parseInt(fileItems[4]));
        scoring.put("Puntaje por Fase", Integer.parseInt(fileItems[5]));

        return scoring;
    }
    public static void getScore(Persona persona, List<Ronda> rondas){
        int puntaje=0;
        Map<Ronda, Integer> dict = new HashMap<>();
        for (Ronda ronda: rondas){
            boolean rondaAcertada = true;
            int puntajeRonda=0;
            for(Pronostico pronosticoPersona: persona.getPronostico()){
                Partido partidoPronostico = pronosticoPersona.obtenerPartidoPronostico(ronda.getPartidos());
                if (partidoPronostico == null){ continue;}
                switch (pronosticoPersona.puntosPartido(partidoPronostico)){
                    case 1:
                        puntajeRonda+=1;
                        persona.addPronosticosAcertados(pronosticoPersona);
                        break;
                    case -1:
                        rondaAcertada = false;
                        break;
                }
            }
            if (rondaAcertada) {
                puntajeRonda += 2;
            }
            puntaje += puntajeRonda;
            dict.put(ronda, puntajeRonda);
        }
        persona.setPuntaje(puntaje);
        persona.setPuntajePorRonda(dict);
    }
    public static void getScore(List<Persona> personas, List<Ronda> rondas){
        for (Persona persona : personas){
            getScore(persona, rondas);
        }
    }
    public static int getScore(List<Ronda> rondas, int cantRondas, Persona persona) throws RondaException {
        //Verificamos si la cantidad de rondas no es negativa.
        if(cantRondas > 0) {
            //Obtenemos el puntaje total de las personas. Esto servira para que tambien obtengamos todos los puntajes por rondas.
            getScore(persona, rondas);
            int puntajeRonda = 0;

            //La cant de rondas es menor o igual que las rondas totales, entonces iteraremos...
            if( cantRondas <= persona.getPuntajePorRonda().size() ) {
                for (Map.Entry<Ronda, Integer> map : persona.getPuntajePorRonda().entrySet()) {
                    //Aca verificamos que se itere hasta la cantidad de rondas especificadas...
                    if (map.getKey().getId() <= cantRondas) {
                        puntajeRonda += map.getValue(); //Rellenamos los puntos por ronda hasta la ronda especificada.
                    } else {
                        break;
                    }
                }
            }else{
                throw new RondaException("La cantidad de rondas especificada sobrepasa las rondas actuales.");
            }
            return puntajeRonda; //Si salio como se esperaba devolveremos, los puntos totales hasta la ronda especificada.
        }else {
            throw new RondaException("Debe indicar almenos una(1) ronda.");
        }
    }


    public static ResultadoEnum checkResult(String resultado){
        return switch (resultado) {
            case "Ganador" -> ResultadoEnum.Ganador;
            case "Empate" -> ResultadoEnum.Empate;
            case "Perdedor" -> ResultadoEnum.Perdedor;
            default -> null;
        };
    }
    public static ResultadoEnum checkStadistics (String item, String item2){
        if(item.equalsIgnoreCase("X")){
            return ResultadoEnum.Ganador;
        }else if(item2.equalsIgnoreCase("X")){
            return ResultadoEnum.Perdedor;
        }else{
            return ResultadoEnum.Empate;
        }
    }
    //(Se usa entrega 1) retorna el puntaje obtenido por los pronosticos.
    public static int puntajePronostico(List<Pronostico> pronosticos, List<Partido> partidos){
        int puntos = 0;
        for( Pronostico p : pronosticos){
            puntos += p.puntos(partidos);
        }
        return puntos;
    }

    public static void setPuntajePersona(List<Persona> personas, List<Fase> fases){
        for (Persona p : personas){
            getScoreDB(p, fases);
        }
        /*
        for(Persona persona : personas){
            for (Pronostico pronosticoActual : persona.getPronostico()){
                Fase faseActual = fases.stream().filter(
                        fase -> fase.getIdFase() == pronosticoActual.getIdFase()
                ).findFirst().get();
                Ronda rondaActual = faseActual.getRondas().stream().filter(
                        ronda -> ronda.getId() == pronosticoActual.getIdRonda()
                ).findFirst().get();
                Partido partidoActual = rondaActual.getPartidos().stream().filter(
                        partido -> partido.getId() == pronosticoActual.getPartido().getId()
                ).findFirst().get();
            }*/
    }

    public static void getScoreDB(Persona persona, List<Fase> fases) {
        int puntaje = 0;
        Map<Ronda, Integer> dict = new HashMap<>();
        for (Fase fase : fases) {
            boolean faseAcertada = true;
            for (Ronda ronda : fase.getRondas()) {
                boolean rondaAcertada = true;
                int puntajeRonda = 0;
                for (Pronostico pronosticoPersona : persona.getPronostico()) {
                    Partido partidoPronostico = pronosticoPersona.obtenerPartidoPronostico(ronda.getPartidos());
                    if (partidoPronostico == null) {
                        continue;
                    }
                    switch (pronosticoPersona.puntosPartido(partidoPronostico)) {
                        case 1:
                            puntajeRonda += 1;
                            persona.addPronosticosAcertados(pronosticoPersona);
                            break;
                        case -1:
                            rondaAcertada = false;
                            faseAcertada = false;
                            break;
                    }
                }
                if (rondaAcertada) {
                    puntajeRonda += 2;
                }
                puntaje += puntajeRonda;
                dict.put(ronda, puntajeRonda);
            }
            if (faseAcertada){
                puntaje += 2;
            }
        }
        persona.setPuntaje(puntaje);
        persona.setPuntajePorRonda(dict);
    }
}

