import models.*;
import repositories.PartidoRepositorio;
import repositories.PronosticoRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.util.List;

/**
 *
 * Esta clase es uno de las tres (1/3) clases principales, las cuales sirven para mostrar
 * entregables, acorde al enunciado del practico integrador.
 * @author alexdev
 * @version 1.0
 *
 */
public class Entrega1 {
    /**
     * @param args No se utilizan parametros de entrada.
     * @throws IOException Puede ocurrir una excepcion (IOException) si no se encuentra el archivo especificado.
     * Utiliza:
     *  -> {@link ReadFilesItems} - {@link ReadFilesItems#getFileItems()}
     *  -> 2 repositorios: {@link PartidoRepositorio}, {@link PronosticoRepositorio}.
     *  -> Un metodo estatico de la clase: {@link Entrega1#getScore(List, List)}
     */
    public static void main(String[] args) throws IOException {
        // Inicializamos los repositorios y ademas la clase que se encargara de leer los .csv
        PronosticoRepositorio pronosticoRepo = new PronosticoRepositorio();
        PartidoRepositorio partidoRepo = new PartidoRepositorio();
        ReadFilesItems rf = new ReadFilesItems();

        //Almacenamos en Strings la rutas hacia el .csv de resultados de partidos y pronosticos:
        String rutaCSV = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega1\\resultados.csv";
        String rutaPronostico = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega1\\pronostico.csv";

        //para leer el archivo csv, hay que indicarle al objeto rf la ruta donde se encuentra el .csv para que no dee excepciones:
        rf.setRutaCSV(rutaCSV);

        //Obtenemos todos los elementos del archivo .csv en un arreglo de strings.
        String[] getFileItems = rf.getFileItems();

        //Almacenamos en un listado de partidos, toda la informacion que provenga del csv a traves del repostiorio de partidos.
        List<Partido> partidosResultados = partidoRepo.getItems(getFileItems);
        // Visualizamos para demostrar que realmente leer los archivos y almacena de manera correcta cada partido.
        System.out.println("* Resultado de los partidos - archivo .csv: ");
        partidosResultados.forEach(System.out::println);

        //Modificamos la rutaCSV para obtener los datos del archivo .csv de pronosticos.
        rf.setRutaCSV(rutaPronostico);

        //Obtenemos los pronosticos del archivo csv y lo almacenamos en un listado de pronosticos.
        List<Pronostico> pronosticoFile = pronosticoRepo.getItems(rf.getFileItems());

        //Imprimimos los pronosticos del archivo.
        System.out.println("\n*Pronosticos - Archivo .csv: ");
        pronosticoFile.forEach(System.out::println);

        //Calculamos los puntos totales obtenidos por los pronósticos.
        int puntosTotales = getScore(pronosticoFile, partidosResultados);

        //Visualizamos el total de puntajes obtenidos de acuerdo a los aciertos:
        System.out.println("> Puntos totales obtenidos por el acierto de los pronosticos: "+ puntosTotales);
    }

    /**
     *  Este metodo sirve para denotar los puntos totales por la cantidad de aciertos
     * de los pronosticos.
     * 
     * @param pronosticos recibe una lista de pronosticos.
     * @param partidos recibe una lista de partidos.
     * @return un entero, el cual almacena los puntos totales acertados por los pronosticos 
     */
    static int getScore(List<Pronostico> pronosticos, List<Partido> partidos){
        int puntos = 0;
        for( Pronostico p : pronosticos){
            puntos += p.puntos(partidos);
        }
        return puntos;
    }
}
/*
  Este entregable estaba pensado en solo leer los resultados de los partidos y el pronostico en base a esos partidos,
  por lo cual no se tomaran en cuenta personas ni las rondas, lo cual, creemos que la logica que se realizo para el calculo
  de puntajes, es correcta y cumple con su cometido.
 */
