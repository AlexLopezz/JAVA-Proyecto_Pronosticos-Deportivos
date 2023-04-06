package resources.classUtility;

import models.Equipo;
import models.Partido;
import models.Pronostico;
import models.Ronda;
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

    public static Partido generatePartidoDB (int id, Equipo equipo1, Equipo equipo2,
                                             int golesEquipo1, int golesEquipo2, Ronda ronda){
        return new Partido(
                id,
                equipo1,
                equipo2,
                golesEquipo1,
                golesEquipo2,
                ronda
        );
    }
}
