import models.*;
import repositories.FaseRepositorio;
import repositories.PersonaRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase es la ultima (3/3) de las clases principales, las cuales sirven para mostrar
 * entregables, acorde al enunciado del practico integrador.
 * @author alexdev
 * @version 1.0
 * El entregable utiliza:
 *      *  -> 1 clase utilitaria: {@link ReadFilesItems}
 *      *  -> 2 clases repositorios: {@link FaseRepositorio} - {@link PersonaRepositorio}
 */
public class Entrega3 {
    public static void main(String[] args) throws SQLException, IOException {
        // Inicializamos los repositorios
        FaseRepositorio fr = new FaseRepositorio();
        PersonaRepositorio pr = new PersonaRepositorio();

        //Almacenamos en un String la ruta donde se encuentra el .csv de los resultado de partidos.
        String resultadosCSV = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega3\\csv\\resultados.csv";
        //Instanciamos un objeto y le pasamos por parametro el string el cual contiene la ruta csv que leera todos los partidos.
        ReadFilesItems rf = new ReadFilesItems(resultadosCSV);

        //Leemos todas los resultados de partidos y lo almcenamos en un listado de fases(ya que se contemplaran las fases)
        List<Fase> fases =  fr.getItems(rf.getFileItems());
        //Visualizamos el listado de fases para ver la correcta lectura de la informacion provista por el csv.
        System.out.println(fases);

        //Luego leemos todas las personas con su informacion correspondiente, lo cual incluye sus pronosticos.
        List<Persona> personasDB = pr.allPersonasDB(); //Leera toda la informacion de personas que esta contenida en la base de datos

        getScore(personasDB, fases);
        //Visualizamos que los puntajes de cada persona, se setearon de manera correcta mostrando sus puntajes correspondientes.
        System.out.println(personasDB);

        //[EXTRA]. Mostramos una especie de ranking que ira de mayor a menor, mostrando todos los puntos totales que saco cada persona.
        rankingParticipantes(personasDB);
    }

    /**
     *  Este metodo lee un arreglo de String,y retorna en un HashMap toda esa informacion acerca
     *  de los puntajes de los aciertos y puntos extras.
     *
     * @param fileItems Un string, con los datos que provengan de un .csv
     * @return Un HashMap, el cual tendra los puntos por acierto, por ronda y fase.
     *
     */
    static HashMap<String, Integer> getScoringCSV(String[] fileItems) {
        HashMap<String, Integer> scoring = new HashMap<>();

        scoring.put("Puntaje por Resultado", Integer.parseInt(fileItems[3]));
        scoring.put("Puntaje por Ronda", Integer.parseInt(fileItems[4]));
        scoring.put("Puntaje por Fase", Integer.parseInt(fileItems[5]));

        return scoring;
    }

    /**
     *
     * @param personas Un listado de personas
     * @param fases Un listado de fases
     * @throws IOException debido a que getScore puede lanzar esta excepcion si no se le pasa una ruta CSV.
     *
     */
    static void getScore(List<Persona> personas, List<Fase> fases) throws IOException {
        for (Persona p : personas){
            getScore(p, fases);
        }
    }

    /**
     *
     * @param persona
     * @param fases
     * @throws IOException
     */
    static void getScore(Persona persona, List<Fase> fases) throws IOException {
        String path = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega3\\csv\\puntaje-ronda.csv";
        ReadFilesItems rf = new ReadFilesItems(path);

        HashMap<String, Integer> valorPuntaje = getScoringCSV(rf.getFileItems());

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
                            puntajeRonda += valorPuntaje.get("Puntaje por Resultado");
                            persona.addPronosticosAcertados(pronosticoPersona);
                            break;
                        case -1:
                            rondaAcertada = false;
                            faseAcertada = false;
                            break;
                    }
                }
                if (rondaAcertada) {
                    puntajeRonda += valorPuntaje.get("Puntaje por Ronda");
                }
                puntaje += puntajeRonda;
                dict.put(ronda, puntajeRonda);
            }
            if (faseAcertada){
                puntaje += valorPuntaje.get("Puntaje por Fase");
            }
        }
        persona.setPuntaje(puntaje);
        persona.setPuntajePorRonda(dict);
    }

    /**
     *
     * @param personas
     */
    static void rankingParticipantes(List<Persona> personas) {
        List<Persona> personasOrdenadas = personas.stream().sorted().toList();
        System.out.println("Ranking de participantes:");
        for (Persona person : personasOrdenadas){
            System.out.println(person.getNombre() + ": " + person.getPuntaje());
        }
    }
}
/*
    Este entregable basicamente, se divide en dos partes a la hora de leer la informacion externa.
    Por un lado, los resultados de los partidos se leeran a traves de un archivo .csv, mientras que
    los pronosticos de las personas se leeran a traves de una base de datos MYSQL.

    Esto se logra a traves de los repositorios (Fase y Persona). los cuales leeran la informacion externa
    y lo 'parsearan' correctamente para almmacenar un listado, tanto de fases como de personas.

    Tambien se contemplara los puntos extras si:
     -> Acierta a los partidos de una ronda.
     -> Acierta a las rondas de una fase.

     Ademas de ello se agregaron la posibilidad de configurar los puntos extras y los
     puntos de aciertos, tambien la conexion a base de datos.

     En conclusion, consideramos que responde a lo que nos pide el enunciado de la ultima entrega.
 */


