import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        /*
        Equipo boquita = new Equipo("Boca", "El mas grande");
        Equipo river = new Equipo("River", "El mas gallina");

        Partido partido = new Partido(boquita, river, 0, 5);

        System.out.println(partido.resultado(boquita));
        System.out.println(partido.resultado(river));

         */

        Path rutaCSV = Paths.get("C:\\Users\\alexdev\\Documents\\resultados.csv");

        String[] partidos = String.valueOf( Files.readAllLines(rutaCSV) )
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .split(",");

        String[] iterar;
        for(  String p : partidos){
            iterar = p.split(";");

        }






    }
}
