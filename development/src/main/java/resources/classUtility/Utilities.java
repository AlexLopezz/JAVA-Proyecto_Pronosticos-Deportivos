package resources.classUtility;
import models.*;

//Clase utilizada para generar algunos objetos de manera sencilla a partir de un array de strings.
public class Utilities {

    /**
     *  Este metodo genera un partido nuevo en base a la data recibida
     * en un array de String
     * @param dataPartido data del partido, en un array.
     * @return Un nuevo partido en base a los datos del String.
     */
    public static Partido generatePartido(String[] dataPartido) {
        return new Partido(
                new Equipo(dataPartido[0]),
                new Equipo(dataPartido[1]),
                Integer.parseInt(dataPartido[2]),
                Integer.parseInt(dataPartido[3])
        );
    }

    /**
     *  Este metodo genera un nuevo pronostico en base a la data recibida en
     * un array de Strings.
     * @param dataPronostico data del pronostico, en un array
     * @return Un nuevo pronostico en base a la data del String
     */
    public static Pronostico generatePronostico(String[] dataPronostico) {
        return new Pronostico(new Partido(new Equipo(dataPronostico[0]),
                                          new Equipo(dataPronostico[1])),
                              new Equipo(dataPronostico[0]),
                              checkStadistics(dataPronostico[2],
                                                      dataPronostico[3]));
    }

    /**
     *  Este metodo lo que hace es verificar en base al String
     * que se le envia, y retorna la data en un ResultadoEnum
     * @param resultado String a verificar.
     * @return un Enum, de ResultadoEnum.
     */
    public static ResultadoEnum checkResult(String resultado){
        return switch (resultado) {
            case "Ganador" -> ResultadoEnum.Ganador;
            case "Empate" -> ResultadoEnum.Empate;
            case "Perdedor" -> ResultadoEnum.Perdedor;
            default -> null;
        };
    }

    /**
     *  Este metodo verifica quien gano el partido en base a los parametros
     * que se le pasan.
     * @param item es la columna del 'ganador'
     * @param item2 es la columna del 'perdedor'
     * @return Un Enum, de ResultadoEnum indicando un Ganador o perdedor u empate
     */
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

