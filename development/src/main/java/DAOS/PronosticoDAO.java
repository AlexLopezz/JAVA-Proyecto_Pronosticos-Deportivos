package DAOS;

import models.Pronostico;
import resources.classUtility.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PronosticoDAO {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    public List<Pronostico> list() {
        try()
    }
}
