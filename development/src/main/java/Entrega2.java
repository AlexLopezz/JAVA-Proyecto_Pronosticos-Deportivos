import models.*;
import repositories.PersonaRepositorio;
import repositories.RondaRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Utilities.getScore(personas, rondas);

        //Visualizamos las personas y toda su informacion.
        System.out.println(personas);
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
