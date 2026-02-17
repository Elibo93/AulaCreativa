package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor.CreateProfesorUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateProfesorService {

    // Atributos
    private final CreateProfesorUseCase createProfesorUseCase;

    public Profesor createProfesor(CreateProfesorCommand command) {
        Profesor profesor = createProfesorUseCase.create(command);
        return profesor;
    }
}