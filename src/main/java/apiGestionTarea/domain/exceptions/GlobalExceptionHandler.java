package apiGestionTarea.domain.exceptions;

import apiGestionTarea.domain.dto.response.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RespuestaError> handleResourceNotFound(ResourceNotFoundException ex) {
        RespuestaError respuestaError = new RespuestaError(ex.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuestaError);
    }

    @ExceptionHandler(StateIsEmptyException.class)
    public ResponseEntity<RespuestaError> handleResourceNotFound(StateIsEmptyException ex) {
        RespuestaError respuestaError = new RespuestaError(ex.getMessage(), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaError);
    }



}
