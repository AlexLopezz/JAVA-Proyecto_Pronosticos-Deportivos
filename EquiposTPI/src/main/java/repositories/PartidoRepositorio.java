package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoRepositorio implements Convertible<Partido> {
    @Override
    public List<Partido> getItems(String[] itemsFile) {
        List<Partido> auxPartido = new ArrayList<>();
        int aux=0;
        for(int i=0; i < itemsFile.length - aux; i++) {
            auxPartido.add(
                    new Partido(
                            new Equipo(itemsFile[aux]),
                            new Equipo(itemsFile[aux + 3]),
                            Integer.parseInt(itemsFile[aux + 1]),
                            Integer.parseInt(itemsFile[aux + 2])
                    )
            );
            aux+=4;
        }
        return auxPartido;
    }

}
