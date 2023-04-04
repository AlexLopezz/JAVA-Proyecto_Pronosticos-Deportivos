package resources.classUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Primero debemos obtener el URL, User y Pass de mysql a donde vamos a conectarnos:
    static final String urlMySQL = "jdbc:mysql://root:FI3Ct9MPoTNd0VnZQmMy@containers-us-west-50.railway.app:6492/railway";
    static final String userMySQL = "root";
    static final String passMySQL = "FI3Ct9MPoTNd0VnZQmMy";
    //Aqui guardaremos la conexion. Una vez realizada la conexion, siempre obtendremos la misma conexion. (Singlenton)
    static Connection connection;
    //Para lograr obtener siempre una misma conexion, debemos modificar el acceso al constructor, es decir ponerlo en privado.
    private ConexionDB() {}

    //A traves de este metodo de clase, obtendermos siempre la misma conexion.
    public static Connection getInstance() throws SQLException {
        return connection != null ? connection : DriverManager.getConnection(urlMySQL, userMySQL, passMySQL);
    }

}
