package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.AlumnoEntity;

@Repository
public interface AlumnoEntityJpaRepository extends JpaRepository<AlumnoEntity, Integer> {

    public AlumnoEntity findByNombre(String nombre);
}
