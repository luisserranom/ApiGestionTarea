package apiGestionTarea.domain.ports.in;

import apiGestionTarea.domain.models.Tarea;

public interface CrearTareaUseCase {
    Tarea crearTarea(Tarea tarea);
}
