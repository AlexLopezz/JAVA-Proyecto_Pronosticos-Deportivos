package resources.classUtility;
import models.*;

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
}

