package repositories;

import interfaces.Convertible;
import models.*;
import resources.classUtility.ConexionDB;
import resources.classUtility.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorio implements Convertible<Persona> {
    //Importante obtener la conexion a DB para realizar consultas.
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    /**
     *  Este metodo almacenara en un listado de Personas, toda la data que
     * provenga de un archivo .csv (en Array de String)
     * @param itemsFile data de algun archivo .csv parseado a un arreglo de Strings.
     * @return Un listado de personas en base a la data del .csv
     */
    @Override
    public List<Persona> getItems(String[] itemsFile) {
        //Inicializamos variables de entradas.
        String nombrePersona = "";
        Pronostico auxPronostico;
        Persona auxPersona = new Persona();
        List<Persona> auxPersonas = new ArrayList<>();
        int aux = 0;

        //Iteramos los datos leídos del archivo.
        for(int i=0; i < itemsFile.length / 6; i++){
            //Skipeamos la primer linea, ya que solo nos da informacion de los distintos campos del archivo.
            if(i != 0) {
                //Guardamos los datos que vamos a usar mas tarde.
                String[] data = {
                        itemsFile[aux + 1],
                        itemsFile[aux + 5],
                        itemsFile[aux + 2],
                        itemsFile[aux + 4]
                };

                //Evalúa si la iteración se trata de la misma persona.
                if (!nombrePersona.equals(itemsFile[aux])) {
                    nombrePersona = itemsFile[aux];
                    auxPersona = new Persona(nombrePersona);
                    auxPersonas.add(auxPersona);
                }

                auxPronostico = Utilities.generatePronostico(data);

                //Añade el pronostico a la lista de pronosticos de la persona.
                auxPersona.addPronostico(auxPronostico);
            }
            aux+=6;
        }

        return auxPersonas;
    }

    /**
     *  Este metodo almcenara en un listado de personas, toda la data de
     * la tabla 'Personas' la cual, proviene de la DB configurada.
     * @return Un listado de personas.
     * @throws SQLException lanzara esta excepcion si se escribio mal algun query u
     * errores relacionados a SQL.
     */
    public List<Persona> allPersonasDB () throws SQLException {
        List<Persona> personas = new ArrayList<>();
        int idPersona = 0;
        Persona persona = null;
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
                """
                        SELECT Pe.idPersona, Pe.nombre, Pr.idPronostico, Pa.idPartido, Pa.equipo1_FK, Pa.equipo2_FK, Pr.resultado, R.idRonda, R.fase_fk
                                                FROM Pronostico as Pr
                                                inner join Partido as Pa on Pr.partido_fk = Pa.idPartido
                                                inner join Persona as Pe on Pr.persona_fk = Pe.idPersona
                                                inner join Ronda as R on Pa.ronda_fk = R.idRonda 
                                                order by idPronostico;
                        """)){
            while (rs.next()){
                if(rs.getInt("idPersona") != idPersona){
                    idPersona = rs.getInt("idPersona");
                    persona = new Persona(idPersona, rs.getString("nombre"));
                    personas.add(persona);
                }
                persona.addPronostico(
                        new Pronostico(
                                rs.getInt("idPronostico"),
                                new Partido(
                                        rs.getInt("idPartido"),
                                        new Equipo(rs.getString("equipo1_FK")),
                                        new Equipo(rs.getString("equipo2_FK"))
                                ),
                                new Equipo(rs.getString("equipo1_FK")),
                                Utilities.checkResult(rs.getString("resultado")),
                                rs.getInt("idRonda"),
                                rs.getInt("fase_fk")
                        )
                );
            }
        }
        return personas;
    }
}
