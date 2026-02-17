package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.common.domain.repository.CRUDRepository;

public interface AlumnoRepository extends CRUDRepository<Alumno,AlumnoId> {

    public Optional<Alumno> getByName(String name);

}
