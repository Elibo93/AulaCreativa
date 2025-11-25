package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
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