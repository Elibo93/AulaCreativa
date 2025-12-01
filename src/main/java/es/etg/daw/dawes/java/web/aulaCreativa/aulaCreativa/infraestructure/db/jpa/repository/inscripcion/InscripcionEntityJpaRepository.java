package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.inscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.InscripcionEntity;

@Repository
public interface InscripcionEntityJpaRepository extends JpaRepository<InscripcionEntity, Integer> {

    // // Buscar inscripciones por alumno
    // public List<InscripcionEntity> findByIdAlumno(Integer idAlumno);

    // // Buscar inscripciones por taller
    // public List<InscripcionEntity> findByIdTaller(Integer idTaller);

    // // Evitar duplicados (alumno ya inscrito en un taller)
    // public InscripcionEntity findByIdAlumnoAndIdTaller(Integer idAlumno, Integer idTaller);
}
