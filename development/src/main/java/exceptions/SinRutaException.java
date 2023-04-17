package exceptions;

/**
 *  Las clases Exception, fueron creadas exclusivamente
 * para lanzar excepciones personalizadas.
 *
 *  En este caso, esta excepcion sera lanzada en la clase
 *  ReadFilesItems.
 */
public class SinRutaException extends RuntimeException{
    /**
     * Este constructor sera utilizado para lanzar justamente un mensaje
     * personalizado.
     * @param message Un String, el cual 'notificara' el error que causo la excepcion.
     */
    public SinRutaException(String message) {
        super(message);
    }
}
