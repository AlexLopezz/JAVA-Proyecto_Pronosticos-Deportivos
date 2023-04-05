package DAOS;

import models.*;
import resources.classUtility.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PronosticoDAO {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    public List<Pronostico> list() {
        List<Pronostico> pronosticos = new ArrayList<Pronostico>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("""
                                            SELECT idPronostico, idPartido, equipo1_FK, equipo2_FK, Pr.resultado
                                            FROM Pronostico as Pr 
                                            inner join Partido as Pa on Pr.partido_fk = Pa.idPartido 
                                            order by idPronostico""")){

            while (rs.next()){
                ResultadoEnum resultado = null;
                switch (rs.getString("resultado")){
                    case "Ganador":
                        resultado = ResultadoEnum.Ganador;
                        break;
                    case "Empate":
                        resultado = ResultadoEnum.Empate;
                        break;
                    case "Perdedor":
                        resultado = ResultadoEnum.Perdedor;
                        break;
                }
                pronosticos.add(
                        new Pronostico(rs.getInt("idPronostico"),
                                new Partido(rs.getInt("idPartido"),
                                        new Equipo(rs.getString("equipo1_fk")),
                                        new Equipo(rs.getString("equipo2_fk"))),
                                new Equipo(rs.getString("equipo1_fk")),
                                resultado));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return pronosticos;
    }

    public void actualizarPronosticoPersonas(List<Persona> personas){

    }
}
