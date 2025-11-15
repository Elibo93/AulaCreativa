package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Profesor;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.ProfesorId;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.repository.CRUDRepository;

public interface ProfesorRepository extends CRUDRepository<Profesor,ProfesorId>{

    public Optional<Profesor> getByName(String name);
    
}
