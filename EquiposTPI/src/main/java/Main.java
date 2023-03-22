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

        
        int pronosticosCantidad = (pronosticos.length/6) / (resultados.length/5);
        List<Partido> partidosJugados = new ArrayList<Partido>();

        for (int i = 0; i < resultados.length/5; i++){
            Equipo equipoActual1 = new Equipo(resultados[(i * 5) + 1]);
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

        for (int j = 0; j < pronosticosCantidad; j++){
            String nombre = pronosticos[(pronosticos.length / pronosticosCantidad) * j];
            Persona persona = new Persona(nombre);
            personas.add(persona);
            List<Pronostico> pronosticoLista = new ArrayList<Pronostico>();

            for (int i = 0; i < pronosticos.length / 6 / pronosticosCantidad; i++) {

                Partido partidoActual = partidosJugados.get(i);
                Equipo equipoActual = partidoActual.getEquipo1();

                Pronostico pronosticoActual = new Pronostico(
                        partidoActual,
                        equipoActual
                );

                pronosticoActual.setResultado(
                        pronosticos[(j * (pronosticosCantidad - 1) * pronosticos.length / 6) + (i * 6) + 2],
                        pronosticos[(j * (pronosticosCantidad - 1) * pronosticos.length / 6) + (i * 6) + 3],
                        pronosticos[(j * (pronosticosCantidad - 1) * pronosticos.length / 6) + (i * 6) + 4]
                );

                pronosticoLista.add(pronosticoActual);
            }

            persona.setPronostico(pronosticoLista);
            persona.setPuntaje();
            System.out.println("Puntaje " + persona.getNombre() + ": " + persona.getPuntaje());
        }
    }
}
