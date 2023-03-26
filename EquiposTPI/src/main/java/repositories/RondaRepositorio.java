package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;
import models.Ronda;

import java.util.ArrayList;
import java.util.List;

public class RondaRepositorio implements Convertible<Ronda> {
    @Override
    public List<Ronda> getItems(String[] itemsFile) {
        String nroRonda = itemsFile[0];
        List<Ronda> auxRonda = new ArrayList<>();
        List<Partido> auxPartidos = new ArrayList<>();
        int aux = 0;


        for (int i = 0; i < itemsFile.length - aux; i++) {
            if (itemsFile[aux].equals(nroRonda)) {
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+4],
                        itemsFile[aux+2],
                        itemsFile[aux+3]
                };
                addPartidoList(auxPartidos, data);
                auxRonda.add(
                        new Ronda(
                                nroRonda, auxPartidos.toArray(new Partido[0]))
                );
            } else {
                nroRonda = itemsFile[aux];
                auxPartidos.clear();
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+4],
                        itemsFile[aux+2],
                        itemsFile[aux+3]
                };
                addPartidoList(auxPartidos, data);
                auxRonda.add(
                        new Ronda(
                                nroRonda,  auxPartidos.toArray(new Partido[0]))
                );
            }
            aux += 5;
        }
        return auxRonda;
    }

    private void addPartidoList (List<Partido> auxPartidos, String[] dataPartido ){
        auxPartidos.add(
                new Partido(
                    new Equipo(dataPartido[0]),
                    new Equipo(dataPartido[1]),
                    Integer.parseInt(dataPartido[2]),
                    Integer.parseInt(dataPartido[3])
                )
        );
    }
}

