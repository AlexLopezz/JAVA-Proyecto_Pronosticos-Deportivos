
import models.Fase;
import models.Persona;
import models.Pronostico;
import models.Ronda;
import repositories.FaseRepositorio;
import repositories.PersonaRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class Entrega3 {
    public static void main(String[] args) throws SQLException, IOException {

        String csvRuta = System.getProperty("user.dir") + "\\development\\src\\main\\java\\resources\\files\\entrega3\\csv\\resultados.csv";
        ReadFilesItems rf = new ReadFilesItems(csvRuta);

        FaseRepositorio fr = new FaseRepositorio();
        List<Fase> fases =  fr.getItems(rf.getFileItems());
        System.out.println(fases);

        PersonaRepositorio pr = new PersonaRepositorio();
        List<Persona> personasDB = pr.allPersonasDB();
        Utilities.setPuntajePersona(personasDB, fases);
        System.out.println(personasDB);

        Utilities.rankingParticipantes(personasDB);
    }
}


