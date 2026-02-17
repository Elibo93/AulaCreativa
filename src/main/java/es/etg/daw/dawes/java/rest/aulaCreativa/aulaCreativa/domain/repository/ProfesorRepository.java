package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.common.domain.repository.CRUDRepository;

public interface ProfesorRepository extends CRUDRepository<Profesor,ProfesorId>{

    public Optional<Profesor> getByName(String name);
    
}
