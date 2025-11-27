
package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;

    public Alumno create(CreateAlumnoCommand comando) {
        Alumno alumno = Alumno.builder()
                .dni(comando.dni())
                .nombre(comando.nombre())
                .apellido(comando.apellido())
                .email(comando.email())
                .createdAt(LocalDateTime.now())
                .build();
        alumnoRepository.save(alumno);
        return alumno;
        
    }

}
