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
    public List<Ronda> getItems(String[] itemsFile) {
        String nroRonda = "-1";
        List<Ronda> auxRonda = new ArrayList<>();
        Partido partidoActual;
        Ronda rondaActual = new Ronda("-1");
        int aux = 0;


        for (int i = 0; i < itemsFile.length / 5; i++) {
            if (itemsFile[aux].equals(nroRonda)) {
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+4],
                        itemsFile[aux+2],
                        itemsFile[aux+3]
                };
                partidoActual = Generate.generatePartido(data);
            } else {
                nroRonda = itemsFile[aux];
                rondaActual = new Ronda((nroRonda));
                auxRonda.add(rondaActual);
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+4],
                        itemsFile[aux+2],
                        itemsFile[aux+3]
                };
                partidoActual = Generate.generatePartido(data);
            }


            rondaActual.addPartido(partidoActual);
            aux += 5;
        }
        return auxRonda;
    }
}

