import models.*;
import repositories.PartidoRepositorio;
import repositories.PronosticoRepositorio;
import resources.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.List;

public class Entrega1 {
    public static void main(String[] args) throws IOException {
        //Variables de entrada:
        String rutaCSV = System.getProperty("user.dir") + "\\EquiposTPI\\src\\Main\\java\\resources\\files\\entrega1\\resultados.csv";
        PartidoRepositorio partidoRepo = new PartidoRepositorio();


        //Instanciamos un objeto de readFiles() para leer el archivo csv, hay que indicarle la ruta para que no dee excepciones:
        ReadFilesItems rf = new ReadFilesItems(rutaCSV);

        //Obtenemos todos los elementos del archivo csv en un arreglo de strings.
        String[] getFileItems = rf.getFileItems();

        //Almacenamos la lista de partidos a traves del repositorio:
        List<Partido> partidosResultados = partidoRepo.getItems(getFileItems);
        partidosResultados.forEach(System.out::println);


        //Variables de entrada:
        String rutaPronostico = System.getProperty("user.dir") + "\\EquiposTPI\\src\\Main\\java\\resources\\files\\entrega1\\pronostico.csv";
        PronosticoRepositorio pronosticoRepo = new PronosticoRepositorio();

        //Modificamos la rutaCSV para obtener los datos de otro archivo
        rf.setRutaCSV(rutaPronostico);

        List<Pronostico> pronosticoFile = pronosticoRepo.getItems(rf.getFileItems());

        pronosticoFile.forEach(System.out::println);
        
        int puntosTotales = pronosticoRepo.puntajePronostico(pronosticoFile, partidosResultados);

        System.out.println("Puntos totales obtenidos por el acierto de los pronosticos: "+ puntosTotales);

        /*
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

            System.out.println(pronosticoActual.puntos());
            pronosticosArr.add(pronosticoActual);
            auxResultados += 4;
            auxPronostico += 5;
        }

        Persona tino = new Persona("Tino");
        tino.setPuntaje(pronosticosArr);
        System.out.println(tino.getPuntaje());
    }

         */
    }
}
