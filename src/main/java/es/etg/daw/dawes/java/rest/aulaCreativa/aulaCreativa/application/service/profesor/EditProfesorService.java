package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor.EditProfesorUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProfesorService {

    //Atributos
    private final EditProfesorUseCase editProfesorUseCase;

    public Profesor update(EditProfesorCommand command) {
        Profesor profesor = editProfesorUseCase.update(command);
        return profesor;
    }
}
