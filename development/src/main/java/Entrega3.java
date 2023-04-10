
import models.Fase;
import models.Persona;
import models.Pronostico;
import models.Ronda;
import repositories.FaseRepositorio;
import repositories.PersonaRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class Entrega3 {
    public static void main(String[] args) throws SQLException, IOException {

        String csvRuta = "C:\\Users\\alexdev\\Documents\\GitHub\\JAVA-Proyecto_Pronosticos-Deportivos\\development\\src\\main\\java\\resources\\files\\entrega3\\csv\\resultados.csv";
        FaseRepositorio fr = new FaseRepositorio();
        ReadFilesItems rf = new ReadFilesItems(csvRuta);
        List<Fase> fases =  fr.getItems(rf.getFileItems());
        System.out.println(fases);

/*
        PersonaRepositorio pr = new PersonaRepositorio();
        List<Persona> personasDB = pr.allPersonasDB();
        System.out.println(personasDB);
 */
    }
}


