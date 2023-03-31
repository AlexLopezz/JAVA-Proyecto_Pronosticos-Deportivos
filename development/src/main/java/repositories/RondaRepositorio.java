package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;
import models.Ronda;
import resources.classUtility.Generate;

import java.util.ArrayList;
import java.util.List;

public class RondaRepositorio implements Convertible<Ronda> {
    @Override
    //Retorna las rondas jugadas a partir de los datos obtenidos.
    public List<Ronda> getItems(String[] itemsFile) {
        //Inicializamos variables de entrada.
        String nroRonda = "-1";
        List<Ronda> auxRonda = new ArrayList<>();
        Partido partidoActual;
        Ronda rondaActual = new Ronda("-1");
        int aux = 0;

        //Iteramos los datos del archivo.
        for (int i = 0; i < itemsFile.length / 5; i++) {
            //Almacenamos en una variable datos que nos van a servir posteriormente.
            String[] data = {
                    itemsFile[aux+1],
                    itemsFile[aux+4],
                    itemsFile[aux+2],
                    itemsFile[aux+3]
            };

            //Evaluamos que la iteración actual se trata de la misma ronda que la anterior iteración.
            if (itemsFile[aux].equals(nroRonda)) {
                partidoActual = Generate.generatePartido(data);
            } else {
                nroRonda = itemsFile[aux];
                rondaActual = new Ronda((nroRonda));
                auxRonda.add(rondaActual);
                partidoActual = Generate.generatePartido(data);
            }

            //Añadimos el partido dentro de la ronda.
            rondaActual.addPartido(partidoActual);
            aux += 5;
        }
        return auxRonda;
    }

}

