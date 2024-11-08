package apiGestionTarea.infrastructure.service;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.repositories.ITareaRepository;
import apiGestionTarea.domain.service.ITareaService;
import apiGestionTarea.infrastructure.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements ITareaService {
    private final ITareaRepository tareaRepository;



    public TareaServiceImpl(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    private Tarea buscarTarea(Long id) {
        return tareaRepository.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea No Encontrada"));
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
    public List<Tarea> listarTareas() {
        return tareaRepository.listarTareas();
    }


    @Override
    public void eliminarTarea(Long id) {
        buscarTarea(id);
        tareaRepository.eliminarTarea(id);
    }



}
