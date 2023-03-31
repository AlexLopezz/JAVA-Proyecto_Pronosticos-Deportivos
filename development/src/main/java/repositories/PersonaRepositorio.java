package repositories;

import interfaces.Convertible;
import models.*;
import resources.classUtility.Generate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonaRepositorio implements Convertible<Persona> {
    @Override
    //Devuelve una lista con todas las personas del archivo.
    public List<Persona> getItems(String[] itemsFile) {
        //Inicializamos variables de entradas.
        String nombrePersona = "";
        Pronostico auxPronostico;
        Persona auxPersona = new Persona();
        List<Persona> auxPersonas = new ArrayList<>();
        int aux = 0;

        //Iteramos los datos leídos del archivo.
        for(int i=0; i < itemsFile.length / 6; i++){
            //Guardamos los datos que vamos a usar mas tarde.
            String[] data = {
                    itemsFile[aux+1],
                    itemsFile[aux+5],
                    itemsFile[aux+2],
                    itemsFile[aux+4]
            };

            //Evalúa si la iteración se trata de la misma persona.
            if (!nombrePersona.equals(itemsFile[aux])) {
                nombrePersona = itemsFile[aux];
                auxPersona = new Persona(nombrePersona);
                auxPersonas.add(auxPersona);
            }

            auxPronostico = Generate.generatePronostico(data);

            //Añade el pronostico a la lista de pronosticos de la persona.
            auxPersona.addPronostico(auxPronostico);

            aux+=6;
        }

        return auxPersonas;
    }

    //Evalua los pronosticos de las personas con los partidos, setea el puntaje y guarda los pronosticos acertados.
    public void obtenerPuntaje(List<Persona> personas, List<Ronda> rondas){
        for (Persona persona : personas){
            this.obtenerPuntaje(persona, rondas);
        }
    }
    public void obtenerPuntaje(Persona persona, List<Ronda> rondas){
        int puntaje=0;
        Map<Ronda, Integer> dict = new HashMap<>();
        for (Ronda ronda: rondas){
            boolean rondaAcertada = true;
            int puntajeRonda=0;
            for(Pronostico pronosticoPersona: persona.getPronostico()){
                Partido partidoPronostico = pronosticoPersona.obtenerPartidoPronostico(ronda.getPartidos());
                if (partidoPronostico == null){ continue;}
                switch (pronosticoPersona.puntosPartido(partidoPronostico)){
                    case 1:
                        puntajeRonda+=1;
                        persona.addPronosticosAcertados(pronosticoPersona);
                        break;
                    case -1:
                        rondaAcertada = false;
                        break;
                }
            }
            if (rondaAcertada) {
                puntajeRonda += 2;
            }
            puntaje += puntajeRonda;
            dict.put(ronda, puntajeRonda);
        }
        persona.setPuntaje(puntaje);
        persona.setPuntajePorRonda(dict);
    }
}
