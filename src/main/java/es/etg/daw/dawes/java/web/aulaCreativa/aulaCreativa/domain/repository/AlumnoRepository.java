package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.repository.CRUDRepository;

public interface AlumnoRepository extends CRUDRepository<Alumno,AlumnoId> {

    public Optional<Alumno> getByName(String name);

}
