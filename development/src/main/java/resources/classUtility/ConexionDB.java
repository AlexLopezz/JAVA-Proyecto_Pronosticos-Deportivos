package resources.classUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Primero debemos obtener el URL, User y Pass de mysql a donde vamos a conectarnos:
    static final String urlMySQL = "jdbc:mysql://mysql-alexdev.alwaysdata.net/alexdev_sports_diagnostics";
    static final String userMySQL = "alexdev";
    static final String passMySQL = "045195@Lex";
    //Aqui guardaremos la conexion. Una vez realizada la conexion, siempre obtendremos la misma conexion. (Singlenton)
    static Connection connection;
    //Para lograr obtener siempre una misma conexion, debemos modificar el acceso al constructor, es decir ponerlo en privado.
    private ConexionDB() {}

    //A traves de este metodo de clase, obtendermos siempre la misma conexion.
    public static Connection getInstance() throws SQLException {
        return connection != null ? connection : DriverManager.getConnection(urlMySQL, userMySQL, passMySQL);
    }

}
