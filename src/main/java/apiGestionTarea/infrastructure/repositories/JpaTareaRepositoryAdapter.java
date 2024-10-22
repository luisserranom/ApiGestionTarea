package apiGestionTarea.infrastructure.repositories;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;
import apiGestionTarea.infrastructure.entities.TareaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTareaRepositoryAdapter implements TareaRepositoryPort {

    private final JpaTareaRepository jpaTareaRepository;

    public JpaTareaRepositoryAdapter(JpaTareaRepository jpaTareaRepository) {
        this.jpaTareaRepository = jpaTareaRepository;
    }

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        TareaEntity tareaEntity = TareaEntity.fromDomainModel(tarea);
        TareaEntity guardarTareaEntity = jpaTareaRepository.save(tareaEntity);
        return guardarTareaEntity.toDomainModel();
    }

    @Override
    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return jpaTareaRepository.findById(id).map(TareaEntity::toDomainModel);
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return jpaTareaRepository.findAll().stream()
                .map(TareaEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tarea> actualizarTarea(Tarea tarea) {
        if (jpaTareaRepository.existsById(tarea.getId())){
            TareaEntity tareaEntity = TareaEntity.fromDomainModel(tarea);
            TareaEntity actualizarTareaEntity = jpaTareaRepository.save(tareaEntity);
            return Optional.of(actualizarTareaEntity.toDomainModel());
        };
        return  Optional.empty();
    }

    @Override
    public boolean EliminarTarea(Long id) {
        if (jpaTareaRepository.existsById(id)){
            jpaTareaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
