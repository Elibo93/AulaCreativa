package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.ProfesorEntity;

@Repository
public interface ProfesorEntityJpaRepository extends JpaRepository<ProfesorEntity, Integer> {
    
    public ProfesorEntity findByNombre(String nombre);

}
