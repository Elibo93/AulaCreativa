package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
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
