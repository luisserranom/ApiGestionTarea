package apiGestionTarea.application.useCases;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.in.ActualizarTareaUseCase;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;

import java.util.Optional;

public class ActualizarTareaUseCaseImpl implements ActualizarTareaUseCase {

    private final TareaRepositoryPort tareaRepositoryPort;

    public ActualizarTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
        this.tareaRepositoryPort = tareaRepositoryPort;
    }

    @Override
    public Optional<Tarea> actualizarTarea(Long id, Tarea actualizarTarea) {
        return tareaRepositoryPort.actualizarTarea(actualizarTarea);
    }
}
