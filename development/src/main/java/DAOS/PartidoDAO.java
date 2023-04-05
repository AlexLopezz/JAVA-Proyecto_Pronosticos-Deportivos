package DAOS;

import interfaces.Crudable;
import models.Equipo;
import models.Fase;
import models.Partido;
import models.Ronda;
import resources.classUtility.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartidoDAO implements Crudable<Partido> {
    Optional<Partido> partidoAux;
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }


    @Override
    public List<Partido> list() {
        List<Partido> partidosDB = new ArrayList<>(); //Preparamos la lista que vamos a retornar.

        try(Statement stmt = getConnection().createStatement(); //Creamos el statement para ejecutar una query.
            //Ejecutamos el siguiente query para listar todos los partidos que hay en BD:
            ResultSet rs = stmt.executeQuery(""" 
                    SELECT idPartido, P.equipo1_FK, P.equipo2_FK, P.golesEquipo1, P.golesEquipo2,
                    F.idFase, F.descripcion as descripcionFase, R.idRonda, R.descripcion as descripcionRonda from Partido as P
                    INNER JOIN Fase as F\s
                    INNER JOIN Ronda as R\s
                    WHERE P.fase_FK = F.idFase AND P.ronda_FK = R.idRonda;""")){

            //Vamos a iterar todas las filas de la query:
            while (rs.next()){
                //Por cada fila, extraemos de cada campo, los datos y lo almacenamos en la lista de partidos.
                partidosDB.add(
                        new Partido(
                                new Equipo(rs.getString("equipo1_FK")),
                                new Equipo(rs.getString("equipo2_FK")),
                                rs.getInt("golesEquipo1"),
                                rs.getInt("golesEquipo2"),
                                new Fase(rs.getInt("idFase"), rs.getString("descripcionFase")),
                                new Ronda(rs.getString("idRonda"), rs.getString("descripcionRonda"))
                        )
                );
            }
        }catch (SQLException s){
            throw new RuntimeException("Ocurrio el siguiente error: "+s.getMessage());
        }
        //Si salio bien, retornaremos todos los partidos. De lo contrario, retornaremos una lista nulla.
        return partidosDB;
    }

    @Override
    public Optional<Partido> search(int id) {
        try(PreparedStatement stmt = getConnection()
                .prepareStatement("""
                        SELECT idPartido, P.equipo1_FK, P.equipo2_FK, P.golesEquipo1, P.golesEquipo2,
                        F.idFase, F.descripcion as descripcionFase, R.idRonda, R.descripcion as descripcionRonda from Partido as P
                        INNER JOIN Fase as F
                        INNER JOIN Ronda as R
                        WHERE P.fase_FK = F.idFase AND P.ronda_FK = R.idRonda AND idPartido = ?;
                        """)){
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {

                    partidoAux = Optional.of(new Partido(
                            new Equipo(rs.getString("equipo1_FK")),
                            new Equipo(rs.getString("equipo2_FK")),
                            rs.getInt("golesEquipo1"),
                            rs.getInt("golesEquipo2"),
                            new Fase(rs.getInt("idFase"), rs.getString("descripcionFase")),
                            new Ronda(rs.getString("idRonda"), rs.getString("descripcionRonda")))
                    );

                }
            }catch (SQLException s){
                throw new RuntimeException(s.getMessage());
            }

        }catch (SQLException s){
            throw new RuntimeException("Ocurrio el siguiente error: "+s.getMessage());
        }

        return partidoAux; //Retornara el partido buscddo(si lo encuentra). Es necesario validar si el obj partido esta presente.
    }

}
