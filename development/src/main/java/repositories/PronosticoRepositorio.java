package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;
import models.Pronostico;
import models.ResultadoEnum;

import java.util.ArrayList;
import java.util.List;

public class PronosticoRepositorio implements Convertible<Pronostico> {
    @Override
    //Retorna la lista de pronosticos a partir de un array de strings.
    public List<Pronostico> getItems(String[] itemsFile) {
        //Inicializamos variables de entrada.
        List<Pronostico> auxPronosticos = new ArrayList<>();
        int aux = 0;

        //Iteramos los datos recibidos.
        for(int i=0; i< itemsFile.length - aux; i++){
            auxPronosticos.add(
                    new Pronostico(
                            new Partido(
                                    new Equipo(
                                            itemsFile[aux]
                                    ),
                                    new Equipo(
                                            itemsFile[aux+4]
                                    )
                            ),
                            new Equipo(
                                    itemsFile[aux]
                            ),
                            checkStadistics(itemsFile[aux+1], itemsFile[aux+3])
                    )
            );
            aux+=5;
        }
        return auxPronosticos;
    }

    //Retorna a partir de las columnas de pronosticos el resultado del primer equipo en cada partido.
    public static ResultadoEnum checkStadistics (String item, String item2){
        if(item.equalsIgnoreCase("X")){
            return ResultadoEnum.Ganador;
        }else if(item2.equalsIgnoreCase("X")){
            return ResultadoEnum.Perdedor;
        }else{
            return ResultadoEnum.Empate;
        }
    }

    //(Se usa entrega 1) retorna el puntaje obtenido por los pronosticos.
    public int puntajePronostico(List<Pronostico> pronosticos, List<Partido> partidos){
       int puntos = 0;
        for( Pronostico p : pronosticos){
            puntos += p.puntos(partidos);
        }
        return puntos;
    }

}
