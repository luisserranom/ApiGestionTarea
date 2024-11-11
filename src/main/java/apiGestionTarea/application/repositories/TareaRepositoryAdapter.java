package apiGestionTarea.application.repositories;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.repositories.ITareaRepository;
import apiGestionTarea.domain.entities.TareaEntity;
import apiGestionTarea.domain.repositories.JpaTareaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TareaRepositoryAdapter implements ITareaRepository {

    private final JpaTareaRepository jpaTareaRepository;

    public TareaRepositoryAdapter(JpaTareaRepository jpaTareaRepository) {
        this.jpaTareaRepository = jpaTareaRepository;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        TareaEntity tareaEntity =  TareaEntity.fromDomainModel(tarea);
        TareaEntity savedEntity = jpaTareaRepository.save(tareaEntity);
        return savedEntity.toDomainModel();
    }

    @Override
    public void eliminarTarea(Long id) {

       jpaTareaRepository.deleteById(id);
    }

    @Override
    public Page<Tarea> listarTareas(Pageable pageable) {

        Page<TareaEntity> tareaEntities = jpaTareaRepository.findAll(pageable);
        return tareaEntities.map(TareaEntity::toDomainModel);
    }


    @Override
    public Optional<Tarea> buscarPorId(Long id) {
        return jpaTareaRepository.findById(id).map(TareaEntity::toDomainModel);
    }

    @Override
    public Tarea actualizarEstadoTarea(Long id, String nuevoEstado) {
        TareaEntity tareaEntity = jpaTareaRepository.findById(id).orElseThrow();
        tareaEntity.setEstado(nuevoEstado);
        TareaEntity savedEntity = jpaTareaRepository.save(tareaEntity);
        return savedEntity.toDomainModel();

    }
}
