package resources.classUtility;

import models.Equipo;
import models.Partido;
import models.Pronostico;
import repositories.PronosticoRepositorio;

//Clase utilizada para generar algunos objetos de manera sencilla a partir de un array de strings.
public class Generate {

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
                              PronosticoRepositorio.checkStadistics(dataPronostico[2],
                                                      dataPronostico[3]));
    };
}