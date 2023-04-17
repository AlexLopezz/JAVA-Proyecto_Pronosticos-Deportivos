package exceptions;

/**
 *  Las clases Exception, fueron creadas exclusivamente
 * para lanzar excepciones personalizadas.
 *
 * En este caso, esta clase excepcion fue creada para lanzarse en
 * los metodos estaticos del Entregable N°2.
 */
public class RondaException extends Exception {
    /**
     *  Este constructor sera utilizado para lanzar justamente un mensaje
     * personalizado.
     * @param message Un String, el cual 'notificara' el error que causo la excepcion.
     */
    public RondaException(String message) {
        super(message);
    }
}
