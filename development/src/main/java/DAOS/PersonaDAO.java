package DAOS;

import models.*;
import resources.classUtility.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    public List<Persona> list(){
        List<Persona> personas = new ArrayList<Persona>();
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


}
