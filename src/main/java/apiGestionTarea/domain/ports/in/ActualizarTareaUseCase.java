package apiGestionTarea.domain.ports.in;

import apiGestionTarea.domain.models.Tarea;

import java.util.Optional;

public interface ActualizarTareaUseCase {
    Optional<Tarea> actualizarTarea(Long id, Tarea actualizarTarea);
}
