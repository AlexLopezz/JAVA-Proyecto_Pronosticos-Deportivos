package repositories;

import interfaces.Convertible;
import models.Equipo;
import models.Partido;
import models.Persona;
import models.Pronostico;
import resources.classUtility.Generate;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorio implements Convertible<Persona> {
    @Override
    public List<Persona> getItems(String[] itemsFile) {
        String nombrePersona = "";
        Pronostico auxPronostico = new Pronostico();
        Persona auxPersona = new Persona();
        List<Persona> auxPersonas = new ArrayList<>();
        int aux = 0;



        for(int i=0; i < itemsFile.length / 6; i++){
            if(nombrePersona.equals(itemsFile[aux])){
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+5],
                        itemsFile[aux+2],
                        itemsFile[aux+4]
                };
                auxPronostico = Generate.generatePronostico(data);

            }else{
                nombrePersona= itemsFile[aux];
                auxPersona = new Persona(nombrePersona);
                auxPersonas.add(auxPersona);
                String[] data = {
                        itemsFile[aux+1],
                        itemsFile[aux+5],
                        itemsFile[aux+2],
                        itemsFile[aux+4]
                };

                auxPronostico = Generate.generatePronostico(data);

            }
            auxPersona.addPronostico(auxPronostico);

            aux+=6;
        }

        return auxPersonas;
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
