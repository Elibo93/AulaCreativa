package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteInscripcionUseCase {
    public final InscripcionRepository inscripcionRepository;

    public void delete(InscripcionId id) {
        inscripcionRepository.deleteById(id);
    }

}


