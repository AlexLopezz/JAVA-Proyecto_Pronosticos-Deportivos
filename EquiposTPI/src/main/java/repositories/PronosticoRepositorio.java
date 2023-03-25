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
    public List<Pronostico> getItems(String[] itemsFile) {
        List<Pronostico> auxPronosticos = new ArrayList<>();
        int aux = 0;

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

    private ResultadoEnum checkStadistics (String item, String item2){
        if(item.equalsIgnoreCase("X")){
            return ResultadoEnum.Ganador;
        }else if(item2.equalsIgnoreCase("X")){
            return ResultadoEnum.Perdedor;
        }else{
            return ResultadoEnum.Empate;
        }
    }

    public int puntajePronostico(List<Pronostico> pronosticos, List<Partido> partidos){
       int puntos = 0;
        for( Pronostico p : pronosticos){
            puntos += p.puntos(partidos);
        }
        return puntos;
    }

}
