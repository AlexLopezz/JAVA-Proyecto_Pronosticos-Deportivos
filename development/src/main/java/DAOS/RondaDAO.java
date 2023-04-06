package DAOS;

import models.Equipo;
import models.Partido;
import models.Ronda;
import resources.classUtility.ConexionDB;
import resources.classUtility.Generate;

import java.awt.geom.GeneralPath;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RondaDAO {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    public List<Ronda> list() throws SQLException {
        //Variables de entrada
        List<Ronda> rondas = new ArrayList<>();
        int numeroRonda = 0;
        Ronda rondaActual = new Ronda(-1);
        Partido partidoActual;

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("""
                    SELECT r.idRonda, r.descripcion as descripcionRonda, f.idFase, f.descripcion as descripcionFase,
                    par.idPartido, par.equipo1_FK, par.equipo2_FK,
                    par.golesEquipo1, par.golesEquipo2
                    FROM Partido as par
                    INNER JOIN Ronda as r
                    ON par.ronda_fk = r.idRonda
                    INNER JOIN Fase as f
                    ON r.fase_fk = f.idFase
                    ORDER BY r.idRonda
                    """)
        ){
            while (rs.next()){
                    if(numeroRonda != rs.getInt("idRonda")){
                    numeroRonda = rs.getInt("idRonda");

                    //Obtenemos la info de la DB sobre la ronda actual de la query
                    rondaActual = new Ronda(
                            numeroRonda,
                            rs.getString("descripcionRonda")
                    );
                    rondas.add(rondaActual); //Agregamos la ronda nueva.
                    //Obtenemos la info de la DB sobre el partido actual de la query.
                    partidoActual = Generate.generatePartidoDB(
                            rs.getInt("idPartido"),
                            new Equipo(rs.getString("equipo1_FK")),
                            new Equipo(rs.getString("equipo2_FK")),
                            rs.getInt("golesEquipo1"),
                            rs.getInt("golesEquipo2"),
                            rondaActual
                    );
                }else{

                    partidoActual = Generate.generatePartidoDB(
                            rs.getInt("idPartido"),
                            new Equipo(rs.getString("equipo1_FK")),
                            new Equipo(rs.getString("equipo2_FK")),
                            rs.getInt("golesEquipo1"),
                            rs.getInt("golesEquipo2"),
                            rondaActual
                    );
                }

                rondaActual.addPartido(partidoActual);
            }
        }
        return rondas;
    }
}
