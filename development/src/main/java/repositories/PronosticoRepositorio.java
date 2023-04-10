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
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    @Override
    //Retorna la lista de pronosticos a partir de un array de strings.
    public List<Pronostico> getItems(String[] itemsFile) {
        //Inicializamos variables de entrada.
        List<Pronostico> auxPronosticos = new ArrayList<>();
        int aux = 0;

        //Iteramos los datos recibidos.
        for(int i=0; i< itemsFile.length - aux; i++){
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
    public List<Pronostico> getPronosticoPersona(int id){
        //Aqui almacenaremos los pronosticos de la persona.
        List<Pronostico> auxPronostico = new ArrayList<>();

        try(PreparedStatement stmt = getConnection()
                .prepareStatement("""
                        SELECT Pe.idPersona, Pe.nombre, Pr.idPronostico, Pa.idPartido, Pa.equipo1_FK, Pa.equipo2_FK, Pr.resultado
                        FROM Pronostico as Pr\s
                        inner join Partido as Pa on Pr.partido_fk = Pa.idPartido
                        inner join Persona as Pe on Pr.persona_fk = Pe.idPersona
                        where Pe.idPersona = ?
                        order by Pe.idPersona;
                        """)){
            stmt.setInt(1,id); //Cambiamos el '?' de la query por el ID de la persona.

            try(ResultSet rs = stmt.executeQuery()){ //Probamos ejecutar el query.
                while (rs.next()){ //Mientras tenga filas la tabla del query iteraremos.
                    //Rellenamos cada pronostico de la persona.
                    auxPronostico.add(
                            new Pronostico(rs.getInt("idPronostico"),
                                    new Partido(rs.getInt("idPartido"),
                                            new Equipo(rs.getString("equipo1_fk")),
                                            new Equipo(rs.getString("equipo2_fk"))),
                                    new Equipo(rs.getString("equipo1_fk")),
                                    Utilities.checkResult(rs.getString("resultado")))
                    );
                }
            }
        }catch (SQLException s){
            throw new RuntimeException(s.getMessage());
        }
        return auxPronostico;
    }

    //Retorna a partir de las columnas de pronosticos el resultado del primer equipo en cada partido.





}
