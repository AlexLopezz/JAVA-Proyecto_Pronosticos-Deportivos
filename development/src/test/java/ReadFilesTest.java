import exceptions.SinRutaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import resources.classUtility.ReadFilesItems;
import static org.junit.jupiter.api.Assertions.*;
public class ReadFilesTest {
    ReadFilesItems rf;

    @BeforeEach
    void init(){
        rf = new ReadFilesItems();
    }
    @Test
    @DisplayName("Verificando el metodo getItemsFile() cuando no le pasamos una ruta.")
    void getFileItemsTest(){
        Exception ex = assertThrows( SinRutaException.class,
                () -> rf.getFileItems());

        String messageActual = ex.getMessage();
        String messageExpected = "No se especifico una ruta para leer el archivo.";

        assertEquals(messageExpected, messageActual);
    }
}
