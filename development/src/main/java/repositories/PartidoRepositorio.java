package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoRepositorio implements Convertible<Partido> {
    /**
     *  Ese metodo 'parseara' toda la data que provenga de un .csv (en
     *  Array de String) y lo almacenara cada data en un listado de Partidos.
     * @param itemsFile data de algun archivo .csv parseado a un arreglo de Strings.
     * @return Un listado de Partidos.
     */
    @Override
    public List<Partido> getItems(String[] itemsFile) {
        List<Partido> auxPartido = new ArrayList<>();
        int aux=0;

        for(int i=0; i < itemsFile.length - aux; i++) {
            if( i != 0) {
                auxPartido.add(
                        new Partido(
                                new Equipo(itemsFile[aux]),
                                new Equipo(itemsFile[aux + 3]),
                                Integer.parseInt(itemsFile[aux + 1]),
                                Integer.parseInt(itemsFile[aux + 2])
                        )
                );
            }
            aux += 4;
        }
        return auxPartido;
    }

}
