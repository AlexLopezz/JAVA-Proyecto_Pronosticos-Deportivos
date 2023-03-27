package repositories;

import interfaces.Convertible;
import models.*;
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

    public void obtenerPuntaje(List<Persona> personas, List<Ronda> rondas){
        for(Persona persona : personas){
            for(Ronda ronda : rondas){
                for(Pronostico personaPronostico : persona.getPronostico()){
                    persona.setPuntaje(personaPronostico.puntos(ronda.getPartidos()));
                }
            }
        }
    }

}
