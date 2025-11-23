package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.repository.CRUDRepository;

public interface InscripcionRepository extends CRUDRepository<Inscripcion, InscripcionId> {

    //List<Inscripcion> getByAlumnoId(AlumnoId alumnoId);
    
    // List<Inscripcion> getByTallerId(TallerId tallerId);
    
    //Optional<Inscripcion> getByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId);
    
    // boolean existsByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId);
}
