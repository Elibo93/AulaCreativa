package es.etg.daw.dawes.java.web.aulaCreativa.application.service.alumnoService;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.application.useCase.alumnoUseCase.CreateAlumnoUseCase;
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
