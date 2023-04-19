package repositories;

import interfaces.Convertible;
import models.*;
import resources.classUtility.ConexionDB;
import resources.classUtility.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PronosticoRepositorio implements Convertible<Pronostico> {
    /**
     *  Este metodo almacenara en un listado de pronosticos, toda la data relacionada
     * a pronosticos que provienen de un .csv (en Array de Strings).
     * @param itemsFile data de algun archivo .csv parseado a un arreglo de Strings.
     * @return Un listado de pronosticos.
     */
    @Override
    public List<Pronostico> getItems(String[] itemsFile) {
        //Inicializamos variables de entrada.
        List<Pronostico> auxPronosticos = new ArrayList<>();
        int aux = 0;

        //Iteramos los datos recibidos.
        for(int i=0; i< itemsFile.length / 5; i++){
            if(i != 0) {
                auxPronosticos.add(
                        new Pronostico(
                                new Partido(
                                        new Equipo(
                                                itemsFile[aux]
                                        ),
                                        new Equipo(
                                                itemsFile[aux + 4]
                                        )
                                ),
                                new Equipo(
                                        itemsFile[aux]
                                ),
                                Utilities.checkStadistics(itemsFile[aux + 1], itemsFile[aux + 3])
                        )
                );
            }
            aux += 5;
        }
        return auxPronosticos;
    }

}
