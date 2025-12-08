package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.DeleteInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteInscripcionService {

    private final DeleteInscripcionUseCase deleteInscripcionUseCase;

    public void delete(InscripcionId id) {
        deleteInscripcionUseCase.delete(id);
    }
    

}
