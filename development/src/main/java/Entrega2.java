import exceptions.RondaException;
import models.*;
import repositories.PersonaRepositorio;
import repositories.RondaRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase es la segunda de las tres (2/3) clases principales, las cuales sirven para mostrar
 *entregables, acorde al enunciado del practico integrador.
 * @author alexdev
 * @version 1.0
 */
public class Entrega2 {
    /**
     * @param args No se utilizan parametros de entrada.
     * @throws IOException Ocurre una excepcion si no se pasa por parametro una ruta especifica donde se encuentra el archivo .csv
     * El entregable utiliza:
     *  -> 2 clases utilitarias: {@link ReadFilesItems} - {@link Utilities}
     *  -> 2 clases repositorios: {@link RondaRepositorio} - {@link PersonaRepositorio}
     */
    public static void main(String[] args) throws IOException {
        //Inicializamos los repositorios y la clase ReadFiles para la lectura de los csv.
        RondaRepositorio rd = new RondaRepositorio();
        PersonaRepositorio pr = new PersonaRepositorio();
        ReadFilesItems rf = new ReadFilesItems();

        //Almacenamos en Strings las rutas acorde al .csv que tendriamos que leer:
        String resultadosCSV = System.getProperty("user.dir")+"\\development\\src\\Main\\java\\resources\\files\\entrega2\\resultados.csv";
        String pronosticosCSV = System.getProperty("user.dir")+"\\development\\src\\Main\\java\\resources\\files\\entrega2\\pronosticos.csv";

        // Seteamos la ruta al objeto rf, para que podamos leer los resultados de los partidos del .csv
        rf.setRutaCSV(resultadosCSV);
        //Esos resultados de partidos lo almacenaremos en un listado de rondas, para ello utilizaremos el repositorio de Rondas:
        List<Ronda> rondas = rd.getItems(rf.getFileItems());

        //Seteamos la ruta al objeto rf para leer,esta vez el .csv de los pronosticos de las personas.
        rf.setRutaCSV(pronosticosCSV);
        //Almacenamos en un listado de personas, la informacion de las personas y ademas sus pronosticos.
        List<Persona> personas = pr.getItems(rf.getFileItems());

        //Obtenemos los puntajes de cada una de las personas:
        getScore(personas, rondas);

        //Visualizamos las personas y toda su informacion.
        System.out.println(personas);
    }

    /**
     *  Este metodo, permite calcular los puntajes con aciertos de un listado de personas,
     * para ello tambien se le debe indicar el listado de rondas donde provienen los partidos.
     * @param personas un listado de personas.
     * @param rondas un listado de rondas.
     *
     */
    static void getScore(List<Persona> personas, List<Ronda> rondas){
        for (Persona persona : personas){
            getScore(persona, rondas);
        }
    }

    /**
     *  Este metodo es similar a {@link #getScore(List, List)} pero con la particularidad, que ahora
     *  le pasariamos un solo objeto Persona, y un listado de Rondas, por lo cual comprobaria todos los aciertos
     *  de una sola Persona.
     * @param persona un objeto de tipo Persona
     * @param rondas un listado de Rondas
     */
    static void getScore(Persona persona, List<Ronda> rondas){
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

    /**
     *  Esta clase fue unica y exclusivamente creada para realizar los Test, y responder a el entregable
     * donde nos pide la puntuacion de dos rondas consecutivas, en este caso le damos la posibilidad de
     * sumar almenos una, y como maximo la cantidad de rondas disponibles.
     *
     * @param rondas Un listado de rondas
     * @param cantRondas Un numero indicando la cantidad de rondas que queremos ver los puntajes.
     * @param persona Una Persona
     * @return Un numero entero, el cual nos indica los puntos totales de acuerdo a la cantidad de rondas especificada.
     * @throws RondaException Debido a que si la cant. de rondas es menor a 0 u mayor a la cantidad de rondas totales, no podremos
     * realizar la sumatoria.
     */
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
}
/*
  Este entregable estaba pensado en tomar en cuenta las rondas, y ademas las personas. Por lo cual
  se tomo en cuenta los repositorios acordes (Persona y Ronda) para la correcta lectura de los datos que
  provienen de los archivos .csv, lo cual, creemos que el desarrollo es correcto y cumple con su enunciado
  correspondiente.
  * Observacion:
    ->Quizas lo que nos falto es mostrar a traves de la salida, cuando una persona acierta todos
    los resultados de una ronda(ya que ello, conlleva puntos extras).
        * Eso NO quita que la logica cuando una persona acierta una ronda, no fue desarrollada. Se agrega
        los puntos correspondientes, pero no se muestra en la salida del programa cuando esto ocurre.
 */
