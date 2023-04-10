package repositories;

import interfaces.Convertible;
import models.Fase;
import models.Ronda;
import resources.classUtility.Utilities;

import java.util.ArrayList;
import java.util.List;

public class FaseRepositorio implements Convertible<Fase> {

    @Override
    public List<Fase> getItems(String[] itemsFile) {
        int nroFase = 0, nroRonda = 0, aux = 0;
        List<Fase> fases = new ArrayList<>();
        Fase faseActual = null;
        Ronda rondaActual = null;

        for (int i = 0; i < itemsFile.length / 7; i++) {
            //Skipeamos la primer linea
            if(i != 0) {
                //Almacenamos en una variable datos que nos van a servir posteriormente.
                String[] data = {
                        itemsFile[aux + 3],
                        itemsFile[aux + 6],
                        itemsFile[aux + 4],
                        itemsFile[aux + 5]
                };

                //Evaluamos que la iteración actual se trata de la misma ronda que la anterior iteración.
                if (Integer.parseInt(itemsFile[aux]) != nroFase) {
                    nroFase = Integer.parseInt(itemsFile[aux]);
                    faseActual = new Fase(nroFase, itemsFile[aux+1]);
                    fases.add(faseActual);
                }
                if(Integer.parseInt(itemsFile[aux+2]) != nroRonda){
                    nroRonda = Integer.parseInt(itemsFile[aux+2]);
                    rondaActual = new Ronda(Integer.parseInt(itemsFile[aux+2]));
                    faseActual.addRonda(rondaActual);
                }
                rondaActual.addPartido(Utilities.generatePartido(data));
            }
            aux += 7;
        }
        return fases;
    }
}
