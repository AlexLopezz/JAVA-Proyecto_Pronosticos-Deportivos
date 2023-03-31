import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RondaTest {
    @BeforeAll
    static void initializeTest(){
        System.out.println("Inicializando periodo de pruebas- Testing equipo 7.");
    }
    @AfterAll
    static void finalizeTest(){
        System.out.println("Finalizando periodo de pruebas- Testing equipo 7.");
    }

    @BeforeEach
    void init(){

    }

    @Test
    void calcularPuntaje(){

    }
}
