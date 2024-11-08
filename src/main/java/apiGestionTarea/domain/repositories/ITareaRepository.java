package apiGestionTarea.domain.repositories;

import apiGestionTarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface ITareaRepository {
    Tarea crearTarea(Tarea tarea);
    void eliminarTarea(Long id);
    List<Tarea>  listarTareas();
    Optional<Tarea> buscarPorId(Long id);

}
