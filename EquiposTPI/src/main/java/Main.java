import models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path rutaCSV = Paths.get(System.getProperty("user.dir") + "\\EquiposTPI\\src\\Main\\java\\resources\\resultados.csv");
        Path rutaPronostico = Paths.get(System.getProperty("user.dir") + "\\EquiposTPI\\src\\Main\\java\\resources\\pronostico.csv");

        int auxResultados = 0;
        int auxPronostico = 0;

        List<Pronostico> pronosticosArr = new ArrayList<>();

        String archivoResultados = String.valueOf(Files.readAllLines(rutaCSV))
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n")
                .replace(";","\n");
        String[] resultados = archivoResultados.split("\n");

        String archivoPronostico= String.valueOf(Files.readAllLines(rutaPronostico))
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n")
                .replace(";","\n");
        String[] pronosticos = archivoPronostico.split("\n");

        /*
        for(int i=0; i < resultados.length - auxResultados; i++){
            Equipo equipoActual1 = new Equipo(resultados[auxResultados]);
            Equipo equipoActual2 = new Equipo(resultados[auxResultados+3]);
            Partido partidoActual = new Partido(
                    equipoActual1,
                    equipoActual2,
                    Integer.parseInt(resultados[auxResultados+1]),
                    Integer.parseInt(resultados[auxResultados+2])
            );

            Pronostico pronosticoActual = new Pronostico(
                    partidoActual,
                    equipoActual1
            );

            pronosticoActual.setResultado(
                    pronosticos[auxPronostico + 1],
                    pronosticos[auxPronostico + 2],
                    pronosticos[auxPronostico + 3]
            );

            pronosticosArr.add(pronosticoActual);
            auxResultados += 4;
            auxPronostico += 5;
        }

        Persona tino = new Persona("Tino");
        tino.setPuntaje(pronosticosArr);
         */
        int pronosticosCantidad = (pronosticos.length/6) / (resultados.length/5);
        List<Partido> partidosJugados = new ArrayList<Partido>();

        for (int i = 0; i < resultados.length/5; i++){
            Equipo equipoActual1 = new Equipo(resultados[auxResultados + 1]);
            Equipo equipoActual2 = new Equipo(resultados[(i * 5)+4]);
            Partido partidoActual = new Partido(
                    equipoActual1,
                    equipoActual2,
                    Integer.parseInt(resultados[(i * 5)+2]),
                    Integer.parseInt(resultados[(i * 5)+3])
            );

            partidosJugados.add(partidoActual);
        }

        List<Persona> personas = new ArrayList<Persona>();
        String nombre = "";

        for (int i = 0; i < pronosticos.length/6; i++){
            if (!nombre.equals("Kevin")){
                nombre = "Kevin";
                Persona persona = new Persona(nombre);
                personas.add(persona);
            }

            Partido partidoActual = partidosJugados.get(i);
            Equipo equipoActual = partidoActual.getEquipo1();

            Pronostico pronosticoActual = new Pronostico(
                    partidoActual,
                    equipoActual
            );

            pronosticoActual.setResultado(
                    pronosticos[(i * 6) + 2],
                    pronosticos[(i * 6) + 3],
                    pronosticos[(i * 6) + 4]
            );

            
        }
    }
}
