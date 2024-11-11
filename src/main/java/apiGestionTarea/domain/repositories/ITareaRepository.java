package apiGestionTarea.domain.repositories;

import apiGestionTarea.domain.models.Tarea;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ITareaRepository {
    Tarea crearTarea(Tarea tarea);
    void eliminarTarea(Long id);
    Page<Tarea> listarTareas(Pageable pageable);
    Optional<Tarea> buscarPorId(Long id);
    Tarea actualizarEstadoTarea(Long id, String nuevoEstado);
}
