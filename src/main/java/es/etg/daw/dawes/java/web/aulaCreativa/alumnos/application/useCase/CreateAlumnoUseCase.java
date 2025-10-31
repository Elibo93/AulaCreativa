package es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.useCase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;

    public Alumno create(CreateAlumnoCommand comando) {
        Alumno alumno = Alumno.builder()
                .nombre(comando.nombre())
                .apellido(comando.apellido())
                .email(comando.email())
                .createdAt(LocalDateTime.now())
                .build();
        alumnoRepository.save(alumno);
        return alumno;
        
    }


}
