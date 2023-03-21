import com.opencsv.exceptions.CsvValidationException;
import models.Equipo;
import models.Partido;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        Path rutaCSV = Paths.get(System.getProperty("user.dir") + "\\EquiposTPI\\src\\Main\\java\\resources\\resultados.csv");

        String partidos = String.valueOf(Files.readAllLines(rutaCSV))
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n")
                .replace(";","\n");

        System.out.println(partidos);


        String[] resultados = partidos.split("\n");

        List<Partido> resultadosPartidos = new ArrayList<>();

        int aux=0;
        for(int i=0; i < resultados.length - aux; i++){
            resultadosPartidos.add(new Partido(
                    new Equipo(resultados[aux]),
                    new Equipo(resultados[aux+3]),
                    Integer.parseInt(resultados[aux+1]),
                    Integer.parseInt(resultados[aux+2])
            ));
            aux += 4;
        }

        resultadosPartidos.forEach(System.out::println);



    }
}
