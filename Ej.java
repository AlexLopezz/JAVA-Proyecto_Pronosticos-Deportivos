package org.alexdev.solution;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ej {
    public static void main(String[] args) throws IOException {
        //Localiza la rutaArchivo de un archivo en el sistema de archivos del SO(Sistema operativo), indicandole la rutaArchivo.
        Path rutaArchivo = Paths.get("C:\\Users\\alexdev\\Documents\\JAVA\\archivo.txt");

        //De esta forma podemos mostrar el path relativo donde se encuentra el archivo en String.
        System.out.println(rutaArchivo.toAbsolutePath());

        //Con exists() verificamos si la rutaArchivo que indicamos en el path existe o no. Puede servir para evitar excepciones.
        System.out.println("¿La rutaArchivo indicada existe? "+ Files.exists(rutaArchivo));

        if(!Files.exists(rutaArchivo)){
            //Creamos un archivo en esa rutaArchivo si es que no existe
            Files.createFile(rutaArchivo); //Nos creara un archivo, que por defecto es de .txt con el nombre 'archivo'
        }
        //Verificamos de nuevo si existe:
        System.out.println("¿La rutaArchivo indicada existe? "+ Files.exists(rutaArchivo));

        //De esta forma creamos un archivo temporal, que se almacena en la carpeta 'Temp' del SO, nos servira para realizar pruebas con archivos.
        Path archivoTemp = Files.createTempFile("archivoTemp",".txt");
        //Verificamos donde se encuentra:
        System.out.println(archivoTemp.toAbsolutePath());

        //Verifica si es un directorio/carpeta, en este caso es False por que no lo es. Pero si preguntamos por una carpeta si.
        System.out.println("¿Es un directorio lo que anteriormente creamos? "+ Files.isDirectory(archivoTemp));

        //De esta forma nos dara true, es similar a Files.exists() pero en este caso evaluara por si es o no un directorio.
        Path directorioTemp = Files.createTempDirectory("directorioTemp");
        System.out.println("¿Es un directorio lo que anteriormente creamos? "+ Files.isDirectory(directorioTemp));


        // Files.copy() para copiar string y pegar en el archivo.
        String textoArchivo = "Hola como estas, todo bien?"; //Creamos un String de prueba que se escribira en el archivo:
        InputStream textBytes = new ByteArrayInputStream(textoArchivo.getBytes()); //Obtenemos el texto en forma de bytes. (getBytes)

        //Copiamos el texto en bytes y lo pegamos en la rutaArchivo del archivo especificado.

        Files.copy(textBytes, rutaArchivo, StandardCopyOption.REPLACE_EXISTING); //IMPORTANTE: Si el archivo existe, es importante indicar StandardCopyOption.REPLACE_EXISTING si no, dara excepcion.


        //Otra cosa que podemos hacer es: Copiar el contenido de un archivo y pegarlo en otro archivo:
        Path rutaArchivo2 = Paths.get("C:\\Users\\alexdev\\Documents\\JAVA\\archivo2.txt"); //Especficamos la ruta del archivo a pegar el contenido
        Files.copy(rutaArchivo, rutaArchivo2, StandardCopyOption.REPLACE_EXISTING); //Pegamos el contenido del archivo a el archivo 2. Si existe el archivo, va pisar  el contenido que tenia antes... Muy importante esa observacion.



        //move() lo que hace es mover el contenido de un archivo1 a otro archivo2 con la diferencia de que el archivo1 dejara de existir(se elimina) quedando todo el contenido que tenia antes en el archivo2.
        Files.move(rutaArchivo2, Paths.get("C:\\Users\\alexdev\\Documents\\JAVA\\archivo3.txt"), StandardCopyOption.REPLACE_EXISTING);

    }
}
