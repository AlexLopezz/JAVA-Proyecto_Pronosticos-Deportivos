import models.*;
import repositories.PersonaRepositorio;
import repositories.RondaRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entrega2 {
    public static void main(String[] args) throws IOException {
        //Inicializamos las variables de entradas.
        RondaRepositorio rd = new RondaRepositorio();
        PersonaRepositorio pr = new PersonaRepositorio();

        //Obtenemos el path de los archivos.
        String resultadosCSV = System.getProperty("user.dir")+"\\EquiposTPI\\src\\Main\\java\\resources\\files\\\\entrega2\\resultados.csv";
        String pronosticosCSV = System.getProperty("user.dir")+"\\EquiposTPI\\src\\Main\\java\\resources\\files\\\\entrega2\\pronosticos.csv";

        //Leemos y guardamos los datos leídos de los archivos de pronosticos y resultados en las variables de ronda y personas.
        ReadFilesItems rf = new ReadFilesItems(resultadosCSV);
        List<Ronda> rondas = rd.getItems(rf.getFileItems());
        rf.setRutaCSV(pronosticosCSV);
        List<Persona> personas = pr.getItems(rf.getFileItems());

        //Obtenemos el puntaje de cada persona e imprimimos las personas junto a sus pronosticos, puntaje y sus aciertos.
        pr.obtenerPuntaje(personas, rondas);
        System.out.println(personas);

         Persona persona = new Persona("Alex");
         List<Pronostico> pronosticoAlex = new ArrayList<>();
         Pronostico pronostico1 = new Pronostico(
                 new Partido (
                         new Equipo("Argentina"),
                         new Equipo("Arabia Saudita")
                 ),
                 new Equipo ("Argentina"),
                 ResultadoEnum.Ganador
         );
        Pronostico pronostico2 = new Pronostico(
                new Partido (
                        new Equipo("Polonia"),
                        new Equipo("Mexico")
                ),
                new Equipo ("Mexico"),
                ResultadoEnum.Empate
        );
        Pronostico pronostico3 = new Pronostico(
                new Partido (
                        new Equipo("Argentina"),
                        new Equipo("Mexico")
                ),
                new Equipo ("Argentina"),
                ResultadoEnum.Ganador
        );
        Pronostico pronostico4 = new Pronostico(
                new Partido (
                        new Equipo("Arabia Saudita"),
                        new Equipo("Polonia")
                ),
                new Equipo ("Arabia Saudita"),
                ResultadoEnum.Perdedor
        );
        pronosticoAlex.add(pronostico1);
        pronosticoAlex.add(pronostico2);
        pronosticoAlex.add(pronostico3);
        pronosticoAlex.add(pronostico4);
        persona.setPronostico(pronosticoAlex);

        pr.obtenerPuntaje(persona, rondas);
        System.out.println(persona);
    }
}
