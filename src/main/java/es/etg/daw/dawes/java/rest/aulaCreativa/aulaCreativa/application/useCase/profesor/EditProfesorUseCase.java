package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.ProfesorNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditProfesorUseCase {

    //Atributos
    private final ProfesorRepository profesorRepository;

    public Profesor update(EditProfesorCommand command) {
        return profesorRepository.getById(command.id())
                .map(p -> { // ACtualizamos los atributos del objeto
                    p.setEspecialidad(command.especialidad());
                    p.setEmail(command.email());
                    p.setTelefono(command.telefono());
                    return profesorRepository.save(p);
                })
                .orElseThrow(() -> new ProfesorNotFoundException(command.id().getValue()));
    }
}
