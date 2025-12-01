package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.repository.CRUDRepository;

public interface InscripcionRepository extends CRUDRepository<Inscripcion, InscripcionId> {

    List<Inscripcion> getByAlumnoId(AlumnoId alumnoId);
    
    List<Inscripcion> getByTallerId(TallerId tallerId);
    
    Optional<Inscripcion> getByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId);
    
    boolean existsByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId);
}
