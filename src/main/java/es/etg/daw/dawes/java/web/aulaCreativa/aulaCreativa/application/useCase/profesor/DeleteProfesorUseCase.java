package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProfesorUseCase {

    //Atributos
    private final ProfesorRepository profesorRepository;

    public void delete(ProfesorId id) {
        profesorRepository.deleteById(id);
    }
    
}
