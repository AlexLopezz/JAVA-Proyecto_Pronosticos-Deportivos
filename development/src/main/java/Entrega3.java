import DAOS.PersonaDAO;
import DAOS.RondaDAO;
import models.Persona;
import models.Ronda;
import repositories.PersonaRepositorio;
import java.sql.SQLException;
import java.util.List;


public class Entrega3 {
    public static void main(String[] args) throws SQLException {
        //Variables de entrada:
        PersonaRepositorio pr = new PersonaRepositorio();
        RondaDAO rondaDAO = new RondaDAO();
        PersonaDAO personaDAO = new PersonaDAO();

        //Obtenemos las personas de la base de datos.
        List<Persona> personasDB =  personaDAO.list();
        //Agregamos sus respectivos pronosticos.
        personaDAO.addingForecastToPeoples(personasDB);

        //Obtenemos todas las rondas de la BD.
        List<Ronda> rondas = rondaDAO.list();

        //Para que la salida del programa no sea tan extenso podriamos probar, a una sola persona de la lista de la BD.
        Persona personaPrueba = personasDB.get(1);
        //Rellenamos los aciertos y los puntos por ronda.
        pr.obtenerPuntaje(personaPrueba, rondas);

        //Verificamos:
        System.out.println(personaPrueba);


    }
}


