package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion.DeleteInscripcionUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.InscripcionId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteInscripcionService {

    private final DeleteInscripcionUseCase deleteInscripcionUseCase;

    public void delete(InscripcionId id) {
        deleteInscripcionUseCase.delete(id);
    }
    

}
