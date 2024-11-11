package apiGestionTarea.domain.repositories;

import apiGestionTarea.domain.entities.TareaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTareaRepository extends JpaRepository<TareaEntity, Long> {
    Page<TareaEntity> findAll(Pageable pageable);

}
