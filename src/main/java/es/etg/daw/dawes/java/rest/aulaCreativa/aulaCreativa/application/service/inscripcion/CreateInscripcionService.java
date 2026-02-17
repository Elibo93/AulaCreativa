package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.CreateInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateInscripcionService {

    private final CreateInscripcionUseCase createInscripcionUseCase;

    public Inscripcion createInscripcion(CreateInscripcionCommand comando) {
        Inscripcion inscripcion = createInscripcionUseCase.create(comando);
        return inscripcion;
        
    }

}
