import models.*;
import repositories.PartidoRepositorio;
import repositories.PronosticoRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.List;

public class Entrega1 {
    public static void main(String[] args) throws IOException {
        //Variables de entrada:
        String rutaCSV = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega1\\resultados.csv";
        PartidoRepositorio partidoRepo = new PartidoRepositorio();

        //Instanciamos un objeto de readFiles() para leer el archivo csv, hay que indicarle la ruta para que no dee excepciones:
        ReadFilesItems rf = new ReadFilesItems(rutaCSV);

        //Obtenemos todos los elementos del archivo csv en un arreglo de strings.
        String[] getFileItems = rf.getFileItems();

        //Almacenamos la lista de partidos a traves del repositorio:
        List<Partido> partidosResultados = partidoRepo.getItems(getFileItems);
        System.out.println("* Resultado de los partidos - archivo .csv: ");
        partidosResultados.forEach(System.out::println);


        //Variables de entrada:
        String rutaPronostico = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega1\\pronostico.csv";
        PronosticoRepositorio pronosticoRepo = new PronosticoRepositorio();

        //Modificamos la rutaCSV para obtener los datos de otro archivo.
        rf.setRutaCSV(rutaPronostico);

        //Obtenemos los pronosticos del archivo csv.
        List<Pronostico> pronosticoFile = pronosticoRepo.getItems(rf.getFileItems());

        //Imprimimos los pronosticos del archivo.
        System.out.println("\n*Pronosticos - Archivo .csv: ");
        pronosticoFile.forEach(System.out::println);

        //Calculamos los puntos totales obtenidos por los pronósticos.
        int puntosTotales = pronosticoRepo.puntajePronostico(pronosticoFile, partidosResultados);

        //Visualizamos el total de puntajes obtenidos.
        System.out.println("> Puntos totales obtenidos por el acierto de los pronosticos: "+ puntosTotales);
    }
}
