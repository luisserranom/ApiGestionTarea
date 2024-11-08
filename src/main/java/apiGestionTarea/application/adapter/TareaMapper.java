package apiGestionTarea.application.adapter;

import apiGestionTarea.domain.dto.response.TareaResponse;
import apiGestionTarea.domain.models.Tarea;
import org.springframework.stereotype.Component;

@Component
public class TareaMapper {

    public TareaResponse tareaResponse(Tarea tarea) {
        return new TareaResponse(
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getNombrePersonal(),
                tarea.getPrimerApellidoPersonal(),
                tarea.getSegundoApellidoPersonal(),
                tarea.getFechaCreacion(),
                tarea.isActivo(),
                tarea.getEstado());
    }
}
