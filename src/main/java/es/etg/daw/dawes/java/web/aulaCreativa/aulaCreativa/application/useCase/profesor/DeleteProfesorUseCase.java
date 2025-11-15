package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.ProfesorId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProfesorUseCase {

    //Atributos
    private final ProfesorRepository profesorRepository;

    public void delete(ProfesorId id) {
        profesorRepository.deleteById(id);
    }
    
}
