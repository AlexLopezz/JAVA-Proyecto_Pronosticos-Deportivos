package resources.classUtility;

import exceptions.SinRutaException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *  Esta clase fue creada unica y exclusivamente para leer archivos .csv
 * y 'parsearlos' a un array de String con toda la data almacenada.
 */
public class ReadFilesItems {
    private String rutaCSV;

    public ReadFilesItems(String rutaCSV) {
        this.rutaCSV = rutaCSV;
    }

    public ReadFilesItems() {
    }

    public String getRutaCSV() {
        return rutaCSV;
    }

    public void setRutaCSV(String rutaCSV) {
        this.rutaCSV = rutaCSV;
    }

    /**
     *  Este metodo lo unico que hace es retornar la data del .csv
     * pero en un array de Strings.
     * @return Un array de strings
     * @throws IOException lanza excepcion si no se le envia el 'path' o ruta para leer la data.
     */
    public String[] getFileItems() throws IOException {
        if (rutaCSV != null) {
            //Para que la ruta me lea correctamente en sistemas operativos linux, debemos formatear la ruta.
            if (System.getProperty("os.name").equals("Linux")) {
                this.rutaCSV = this.rutaCSV.replace("\\", "/")
                        .replace("Main", "main");
            }
            return String.valueOf(Files.readAllLines(Paths.get(rutaCSV)))
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n")
                    .replace(";", "\n")
                    .split("\n");
        } else {
            throw new SinRutaException("No se especifico una ruta para leer el archivo.");
        }
    }
}
