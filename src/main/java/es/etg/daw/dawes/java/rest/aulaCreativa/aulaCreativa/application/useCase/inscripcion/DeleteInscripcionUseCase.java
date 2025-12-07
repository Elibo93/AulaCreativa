package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteInscripcionUseCase {
    public final InscripcionRepository inscripcionRepository;

    public void delete(InscripcionId id) {
        inscripcionRepository.deleteById(id);
    }

}


