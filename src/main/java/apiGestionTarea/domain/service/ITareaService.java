package apiGestionTarea.domain.service;

import apiGestionTarea.domain.models.Tarea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITareaService {
    Tarea guardarTarea(Tarea tarea);
    Tarea  obtenerTareaPorId(Long Id);
    Page<Tarea> listarTareas(Pageable pageable);
    void  eliminarTarea(Long id);
    Tarea actualizarEstadoTarea(Long id, String nuevoEstado);
}
