import models.Fase;
import models.Persona;
import models.Pronostico;
import models.Ronda;
import repositories.FaseRepositorio;
import repositories.PersonaRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * Esta clase es la ultima (3/3) de las clases principales, las cuales sirven para mostrar
 * entregables, acorde al enunciado del practico integrador.
 * @author alexdev
 * @version 1.0
 * El entregable utiliza:
 *      *  -> 2 clases utilitarias: {@link ReadFilesItems} - {@link Utilities}
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

        Utilities.setPuntajePersona(personasDB, fases);
        //Visualizamos que los puntajes de cada persona, se setearon de manera correcta mostrando sus puntajes correspondientes.
        System.out.println(personasDB);

        //[EXTRA]. Mostramos una especie de ranking que ira de mayor a menor, mostrando todos los puntos totales que saco cada persona.
        Utilities.rankingParticipantes(personasDB);
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


