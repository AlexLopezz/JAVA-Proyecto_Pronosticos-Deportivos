import resources.classUtility.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Entrega3 {
    public static void main(String[] args) {
        /* Es importante automatizar las conexiones para que luego de ocuparlas, se cierren automaticamente. Esto se logra
        con el try-catch. Podemos optar por tratar cada clase (Connection, Statement y ResultSet) o lo que es lo mismo, tratarlas
        a todas estas en una misma clase, por lo que optamos por tratar a todas dentro de un mismo try. Esto debido a evitar tener
        muchos try-catch y que el codigo se vea muy engorroso.
         */
        try (Connection connection = ConexionDB.getInstance(); //Obtenemos la conexion a la BD.
             Statement stmt = connection.createStatement(); //Se utiliza para ejecutar sentencias SQL sin parametros.
             ResultSet resultado = stmt.executeQuery("SELECT * FROM Partido;")) { //Con ResultSet almacenaremos lo que se ejecutara en el query.

            System.out.println("Listando partidos de la base de datos: ");

            while (resultado.next()){ //Mientras que el query tenga una fila para iterar, .next() dara siempre true.
                //Es importante que si se va traer informacion de la BD, debe ser del mismo tipo de dato. Si no, nos arrojara una excepcion (SQLExcepton)
                System.out.print(resultado.getInt("idPartido") + " - ");
                System.out.print(resultado.getString("equipo1_FK") + " - ");
                System.out.print(resultado.getString("equipo2_FK") + " - ");
                System.out.print(resultado.getInt("golesEquipo1") + " - ");
                System.out.print(resultado.getInt("golesEquipo2") + " - ");
                System.out.print(resultado.getInt("fase_FK") + " - ");
                System.out.println(resultado.getInt("ronda_FK"));
            }
        } catch (SQLException s) {
            throw new RuntimeException("Ocurrio el siguiente error: " + s.getMessage());
        }
    }

}
