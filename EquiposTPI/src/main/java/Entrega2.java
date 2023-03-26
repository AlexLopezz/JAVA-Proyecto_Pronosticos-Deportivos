import models.Persona;
import models.Ronda;
import repositories.PersonaRepositorio;
import repositories.RondaRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.List;

public class Entrega2 {
    public static void main(String[] args) throws IOException {
        RondaRepositorio rd = new RondaRepositorio();
        String resultadosCSV = System.getProperty("user.dir")+"\\EquiposTPI\\src\\Main\\java\\resources\\files\\\\entrega2\\resultados.csv";
        ReadFilesItems rf = new ReadFilesItems(resultadosCSV);

        List<Ronda> rondas = rd.getItems(rf.getFileItems());
        System.out.println(rondas);

        PersonaRepositorio pr = new PersonaRepositorio();
        String pronosticosCSV = System.getProperty("user.dir")+"\\EquiposTPI\\src\\Main\\java\\resources\\files\\\\entrega2\\pronosticos.csv";
        rf.setRutaCSV(pronosticosCSV);

        /* Aun no funciona :(
        List<Persona> personas = pr.getItems(rf.getFileItems());
        System.out.println(personas);
         */
    }
}
