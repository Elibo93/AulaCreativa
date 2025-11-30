package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.taller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.TallerEntity;

@Repository
public interface TallerEntityJpaRepository extends JpaRepository<TallerEntity, Integer> {

    public TallerEntity findByNombre(String nombre);
}
