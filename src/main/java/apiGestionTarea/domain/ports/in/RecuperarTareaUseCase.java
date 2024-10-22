package apiGestionTarea.domain.ports.in;

import apiGestionTarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface RecuperarTareaUseCase {
    Optional<Tarea> obtenerTareaPorId(Long Id);
    List<Tarea> obtenerTareas();


}
