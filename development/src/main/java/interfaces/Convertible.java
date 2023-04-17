package interfaces;

import java.util.List;

/**
 *  Esta interfaz sera utilizada generalmente en la mayoria
 * de los repositorios.
 * @param <T> Un tipo de dato, el cual sera generico.
 */
public interface Convertible <T>{
    /**
     *  La idea de este metodo, es 'convertir' o 'parsear'
     * la data que viene de un arreglo de String de acuerdo al repositorio que
     * lo utilice.
     * @param itemsFile data de algun archivo .csv parseado a un arreglo de Strings.
     * @return una lista, del tipo de dato generico especificado.
     */
    List<T> getItems(String[] itemsFile);
}
