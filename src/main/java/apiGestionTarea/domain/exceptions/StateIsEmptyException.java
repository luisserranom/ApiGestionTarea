package apiGestionTarea.domain.exceptions;

public class StateIsEmptyException extends RuntimeException {

    public StateIsEmptyException(String message) {
        super(message);
    }
}
