import models.Equipo;
import models.Partido;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        String[] partidosArr;
        Equipo equipo1;
        Equipo equipo2;
        Partido partido;
        Path rutaCSV = Paths.get(System.getProperty("user.dir") + "\\EquiposTPI\\src\\main\\java\\resources\\resultados.csv");

        String[] partidos = String.valueOf( Files.readAllLines(rutaCSV) )
                .replace("[", "")
                .replace("]", "")
                .split(",");

        /*
        Equipo boquita = new Equipo("Boca", "El mas grande");
        Equipo river = new Equipo("River", "El mas gallina");

        Partido partido = new Partido(boquita, river, 0, 5);

        System.out.println(partido.resultado(boquita));
        System.out.println(partido.resultado(river));

         */




        for(  String p : partidos) {
            partidosArr = p.split(";");
            equipo1 = new Equipo(partidosArr[0], "Equipo 1");
            equipo2 = new Equipo(partidosArr[3], "Equipo 2");
            partido = new Partido(equipo1, equipo2, Integer.parseInt(partidosArr[1]), Integer.parseInt(partidosArr[2]));
            System.out.println(partido);
            System.out.println(partido.resultado(equipo1));
        }
    }
}
