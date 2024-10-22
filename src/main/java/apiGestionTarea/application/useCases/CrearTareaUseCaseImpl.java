package apiGestionTarea.application.useCases;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.in.CrearTareaUseCase;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;

public class CrearTareaUseCaseImpl implements CrearTareaUseCase {

    private  final TareaRepositoryPort tareaRepositoryPort;

    public CrearTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
        this.tareaRepositoryPort = tareaRepositoryPort;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepositoryPort.guardarTarea(tarea);
    }
}
