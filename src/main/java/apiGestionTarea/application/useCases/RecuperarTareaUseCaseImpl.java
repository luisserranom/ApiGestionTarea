package apiGestionTarea.application.useCases;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.in.RecuperarTareaUseCase;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RecuperarTareaUseCaseImpl implements RecuperarTareaUseCase {
    private final TareaRepositoryPort tareaRepositoryPort;


    public RecuperarTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
        this.tareaRepositoryPort = tareaRepositoryPort;
    }

    @Override
    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepositoryPort.obtenerTareaPorId(id);
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return tareaRepositoryPort.obtenerTareas();
    }
}
