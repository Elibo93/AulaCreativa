package es.etg.daw.dawes.java.web.aulaCreativa.domain.repository;

import java.util.Optional;
import es.etg.daw.dawes.java.web.aulaCreativa.domain.model.Alumno;

public interface AlumnoRepository extends CRUDRepository<Alumno, String> {

    public Optional<Alumno> getByName(String name);

}
