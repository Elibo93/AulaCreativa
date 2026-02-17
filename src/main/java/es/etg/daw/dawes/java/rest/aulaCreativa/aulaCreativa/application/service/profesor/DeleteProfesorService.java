package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor.DeleteProfesorUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProfesorService {

    // Atributos
    private final DeleteProfesorUseCase deleteProfesorUseCase;

    public void delete(ProfesorId id) {
        deleteProfesorUseCase.delete(id);
    }

}
