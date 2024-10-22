package apiGestionTarea.application.useCases;

import apiGestionTarea.domain.ports.in.EliminarTareaUseCase;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;

public class EliminarTareaUseCaseImpl implements EliminarTareaUseCase {

    private final TareaRepositoryPort tareaRepositoryPort;

    public EliminarTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
        this.tareaRepositoryPort = tareaRepositoryPort;
    }

    public boolean eliminarTarea(Long id){
        return tareaRepositoryPort.EliminarTarea(id);
    }


}
