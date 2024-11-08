package apiGestionTarea.domain.service;

import apiGestionTarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface ITareaService {
    Tarea guardarTarea(Tarea tarea);
    Tarea  obtenerTareaPorId(Long Id);
    List<Tarea> listarTareas();
    void  eliminarTarea(Long id);
}
