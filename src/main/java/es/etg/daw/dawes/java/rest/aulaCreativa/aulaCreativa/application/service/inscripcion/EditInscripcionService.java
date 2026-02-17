package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.inscripcion.EditInscripcionCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.EditInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditInscripcionService {
    private final EditInscripcionUseCase editInscripcionUseCase;

    public Inscripcion update(EditInscripcionCommand comando) {
        Inscripcion inscripcion = editInscripcionUseCase.update(comando);
        return inscripcion;
    }

}
