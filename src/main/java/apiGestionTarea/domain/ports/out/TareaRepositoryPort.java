package apiGestionTarea.domain.ports.out;

import apiGestionTarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepositoryPort {
    Tarea guardarTarea(Tarea tarea);
    Optional<Tarea>  obtenerTareaPorId(Long Id);
    List<Tarea> obtenerTareas();
    Optional<Tarea> actualizarTarea(Tarea tarea);
    boolean EliminarTarea(Long id);
}
