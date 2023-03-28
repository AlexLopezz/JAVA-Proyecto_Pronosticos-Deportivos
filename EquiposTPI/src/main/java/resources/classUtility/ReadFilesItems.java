package resources.classUtility;

import exceptions.SinRutaException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Clase creada para leer los archivos y limpiarlos.
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

    //Retorna el archivo leído dentro de un array de strings.
    public String[] getFileItems() throws IOException {
        if(rutaCSV != null){
            //Para que la ruta me lea correctamente en sistemas operativos linux, debemos formatear la ruta.
            if(System.getProperty("os.name").equals("Linux")){
                this.rutaCSV = this.rutaCSV.replace("\\","/")
                        .replace("Main","main");
            }
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
