package apiGestionTarea.infrastructure.service;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.repositories.ITareaRepository;
import apiGestionTarea.domain.service.ITareaService;
import apiGestionTarea.infrastructure.exceptions.ResourceNotFoundException;
import apiGestionTarea.infrastructure.exceptions.StateIsEmptyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements ITareaService {
    private final ITareaRepository tareaRepository;


    public TareaServiceImpl(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    private Tarea buscarTarea(Long id) {
        return tareaRepository.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));
    }




    @Override
    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.crearTarea(tarea);
    }

    @Override
    public Tarea obtenerTareaPorId(Long id) {
        return buscarTarea(id);
    }

    @Override
    public Page<Tarea> listarTareas(Pageable pageable) {
        return tareaRepository.listarTareas(pageable);
    }


    @Override
    public void eliminarTarea(Long id) {
        buscarTarea(id);
        tareaRepository.eliminarTarea(id);
    }


    @Override
    public Tarea actualizarEstadoTarea(Long id, String nuevoEstado) {
        buscarTarea(id);
        if (nuevoEstado != null && !nuevoEstado.isEmpty() && !nuevoEstado.isBlank())  {
            tareaRepository.actualizarEstadoTarea(id, nuevoEstado);
            return  buscarTarea(id);
        }
         throw new StateIsEmptyException("Estado vacio");

    }

}
