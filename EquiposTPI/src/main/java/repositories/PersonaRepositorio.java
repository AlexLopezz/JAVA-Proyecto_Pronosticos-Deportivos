package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;
import models.Persona;
import models.Pronostico;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorio implements Convertible<Persona> {
    @Override
    public List<Persona> getItems(String[] itemsFile) {
        List<Persona> personaPronosticos = new ArrayList<>();
        int aux = 0;

        for(int i=0; i < itemsFile.length - aux; i++){
            personaPronosticos.add(
                    addPersonaPronostico(itemsFile, aux)
            );
        }




        /*
        //[1] Equipo 1, [5] Equipo2, [2] Gana, [3] Empate, [4] Pierde
        for(int i= 0; i< itemsFile.length - aux; i++){
            if(nombrePersona.equals(itemsFile[aux])){
                auxPersona.setNombre(nombrePersona);

                while(itemsFile[aux].equals(nombrePersona)) {
                    auxPersona.addPronostico(
                            new Pronostico(
                                    new Partido(
                                            new Equipo(itemsFile[aux + 1]),
                                            new Equipo(itemsFile[aux + 5])
                                    ),
                                    new Equipo(
                                            itemsFile[aux + 1]
                                    ),
                                    PronosticoRepositorio.checkStadistics(itemsFile[aux + 2], itemsFile[aux + 4])
                            )
                    );
                    aux+=6;
                }
                aux-=6;
                personaPronosticos.add(auxPersona);
            }else {
                nombrePersona = itemsFile[aux];
                auxPersona = new Persona();
            }
            aux+=6;
        }

         */

        return personaPronosticos;
    }
    public Persona addPersonaPronostico (String[] itemsFile, int aux){
        Persona auxPersona = new Persona();
        auxPersona.setNombre(itemsFile[aux]);

        while(itemsFile[aux].equals(auxPersona.getNombre())){
            auxPersona.addPronostico(
                    new Pronostico(
                            new Partido(
                                    new Equipo(itemsFile[aux + 1]),
                                    new Equipo(itemsFile[aux + 5])
                            ),
                            new Equipo(
                                    itemsFile[aux + 1]
                            ),
                            PronosticoRepositorio.checkStadistics(itemsFile[aux + 2], itemsFile[aux + 4])
                    )
            );
            aux+=6;
        }
        return auxPersona;
    }
}
