package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;

public interface ProfesorRepository extends CRUDrepository<Profesor,ProfesorId>{

    public Optional<Alumno> getByName(String name);
    
}
