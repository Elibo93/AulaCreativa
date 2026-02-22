package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command) {
        return alumnoRepository.getById(command.id())
                .map(p -> { // Actualizamos los atributos del objeto
                   
                    p.setEmail(command.email());
                    return alumnoRepository.save(p);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue())); // Lo cambiamos

    }

}
