package DAOS;

import models.*;
import resources.classUtility.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static models.ResultadoEnum.Ganador;

public class PersonaDAO {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    //Obtenemos el listado de personas que tenemos en la base de datos.
    public List<Persona> list(){
        List<Persona> personas = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("""
                                            SELECT idPersona, nombre FROM Persona""")){

            while (rs.next()){
                personas.add(
                        new Persona(rs.getInt("idPersona"),
                                    rs.getString("nombre")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return personas;
    }

    public void addingForecastToPeoples(List<Persona> personas){
        for(Persona p : personas){
            p.setPronostico(addPronosticoPersona(p));
        }
    }

    private List<Pronostico> addPronosticoPersona(Persona p){
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
            stmt.setInt(1,p.getId());

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){

                    auxPronostico.add(
                            new Pronostico(rs.getInt("idPronostico"),
                                    new Partido(rs.getInt("idPartido"),
                                            new Equipo(rs.getString("equipo1_fk")),
                                            new Equipo(rs.getString("equipo2_fk"))),
                                    new Equipo(rs.getString("equipo1_fk")),
                                    checkResult(rs.getString("resultado")))
                    );
                }
            }
        }catch (SQLException s){
            throw new RuntimeException(s.getMessage());
        }
        return auxPronostico;
    }
    private ResultadoEnum checkResult(String resultado){
        return switch (resultado) {
            case "Ganador" -> ResultadoEnum.Ganador;
            case "Empate" -> ResultadoEnum.Empate;
            case "Perdedor" -> ResultadoEnum.Perdedor;
            default -> null;
        };
    }


}
