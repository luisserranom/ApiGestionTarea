package apiGestionTarea.infrastructure.repositories;

import apiGestionTarea.infrastructure.entities.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTareaRepository extends JpaRepository<TareaEntity, Long> {

}
