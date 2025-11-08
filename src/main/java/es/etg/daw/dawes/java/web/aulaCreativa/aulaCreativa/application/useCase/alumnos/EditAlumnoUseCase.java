package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;

public class EditAlumnoUseCase {
    private final AlumnoProductoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command) {
        return AlumnoRepository.getById(command.id())
                .map(p -> { // Actualizamos los atributos del objeto
                    p.setNombre(command.nombre());
                    p.setApellido(command.apellido());
                    p.setEmail(command.email());
                    return alumnoRepository.save(p);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue())); // Lo cambiamos

    }

}
