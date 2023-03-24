package resources.classUtility;

import exceptions.SinRutaException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFilesItems {
    private String rutaCSV;

    public ReadFilesItems(String rutaCSV) {
        this.rutaCSV = rutaCSV;
    }

    public String getRutaCSV() {
        return rutaCSV;
    }

    public void setRutaCSV(String rutaCSV) {
        this.rutaCSV = rutaCSV;
    }

    public String[] getFileItems() throws IOException {
        if(rutaCSV != null){
            return  String.valueOf(Files.readAllLines(Paths.get(rutaCSV)))
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n")
                    .replace(";","\n")
                    .split("\n");
        }else{
            throw new SinRutaException("No se especifico una ruta para leer el archivo.");
        }
    }
}
