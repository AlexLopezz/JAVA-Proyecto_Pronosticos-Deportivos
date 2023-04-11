import exceptions.RondaException;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import repositories.PersonaRepositorio;
import repositories.RondaRepositorio;
import resources.classUtility.ReadFilesItems;
import resources.classUtility.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RondaTest {
    Persona persona;
    List<Pronostico> pronosticosPersona;
    PersonaRepositorio pr;
    ReadFilesItems rf;
    RondaRepositorio rd;
    List<Ronda> rondas;


    @BeforeAll
    static void initializeTest() {
        System.out.println("Inicializando periodo de pruebas- Testing equipo 7.");
    }

    @AfterAll
    static void finalizeTest() {
        System.out.println("Finalizando periodo de pruebas- Testing equipo 7.");
    }

    @BeforeEach
    void init() throws IOException {
        persona = new Persona("Alex");
        pronosticosPersona = new ArrayList<>();
        pr = new PersonaRepositorio();
        rf = new ReadFilesItems(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\files\\entrega2\\resultados.csv");
        rd = new RondaRepositorio();
        rondas = rd.getItems(rf.getFileItems());

        Pronostico pronostico1 = new Pronostico(
                new Partido(
                        new Equipo("Argentina"),
                        new Equipo("Arabia Saudita")
                ),
                new Equipo("Argentina"),
                ResultadoEnum.Ganador
        );
        Pronostico pronostico2 = new Pronostico(
                new Partido(
                        new Equipo("Polonia"),
                        new Equipo("Mexico")
                ),
                new Equipo("Mexico"),
                ResultadoEnum.Empate
        );
        Pronostico pronostico3 = new Pronostico(
                new Partido(
                        new Equipo("Argentina"),
                        new Equipo("Mexico")
                ),
                new Equipo("Argentina"),
                ResultadoEnum.Ganador
        );
        Pronostico pronostico4 = new Pronostico(
                new Partido(
                        new Equipo("Arabia Saudita"),
                        new Equipo("Polonia")
                ),
                new Equipo("Arabia Saudita"),
                ResultadoEnum.Perdedor
        );

        pronosticosPersona.add(pronostico1);
        pronosticosPersona.add(pronostico2);
        pronosticosPersona.add(pronostico3);
        pronosticosPersona.add(pronostico4);

        persona.setPronostico(pronosticosPersona);
    }


    @Nested
    class testCalcularPuntaje {

        @Test
        void calcularPuntajeTest() throws RondaException {
            int puntajeRonda = Utilities.getScore(rondas, 2, persona); // Tendria que dar 5 puntos, ya que acerto 2(4 por el plus) de la ronda 1, y 1 de la ronda 2.
            assertEquals(5, puntajeRonda);
        }

        @Test
        @DisplayName("Validando cantidad de rondas negativas")
        void calcularPuntajeTest2() {
            //Verificamos si las excepiones funciona de manera correcta: Si se le pasa una cantidad de rondas negativas, debera tirar excepcion.
            Exception ex = assertThrows(RondaException.class, () ->
                    Utilities.getScore(rondas, -10, persona));

            String messageActual = ex.getMessage();
            String messageExpected = "Debe indicar almenos una(1) ronda.";

            assertEquals(messageExpected, messageActual);
        }
        @Test
        @DisplayName("Validando cantidad de rondas no sobrepase al total de rondas")
        void calcularPuntajeTest3(){
            //Verificamos si la excepcion funcionaa de manera correcta: Si le indicamos una cantidad de ronda mayor a las rondas totales, debera tirar excepcion.
            Exception ex = assertThrows(RondaException.class, () ->
                    Utilities.getScore(rondas, 350, persona));

            String messageActual = ex.getMessage();
            String messageExpected = "La cantidad de rondas especificada sobrepasa las rondas actuales.";

            assertEquals(messageExpected, messageActual);
        }
    }
}
