package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.inscripcion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.InscripcionEntity;

@Repository
public interface InscripcionEntityJpaRepository extends JpaRepository<InscripcionEntity, Integer> {

    // Buscar inscripciones por alumno
    public List<InscripcionEntity> findByAlumnoId(Integer idAlumno);

    // Buscar inscripciones por taller
    public List<InscripcionEntity> findByTallerId(Integer idTaller);

    // // Evitar duplicados (alumno ya inscrito en un taller)
    // public InscripcionEntity findByIdAlumnoAndIdTaller(Integer idAlumno, Integer
    // idTaller);
}
