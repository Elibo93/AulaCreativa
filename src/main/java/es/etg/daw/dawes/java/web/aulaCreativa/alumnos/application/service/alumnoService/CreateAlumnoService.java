package es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.service.alumnoService;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.useCase.alumnoUseCase.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CreateAlumnoService {

    private final CreateAlumnoUseCase createAlumnoUseCase;

    public Alumno createAlumno(CreateAlumnoCommand comando) {
        Alumno alumno = createAlumnoUseCase.create(comando);
        return alumno;
        
    }


}
