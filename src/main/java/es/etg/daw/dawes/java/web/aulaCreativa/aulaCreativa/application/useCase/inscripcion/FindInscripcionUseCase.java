package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import java.util.List;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error.InscripcionNotFoundException;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindInscripcionUseCase {

    private final InscripcionRepository inscripcionRepository;

    public List<Inscripcion> findAll() {
        List<Inscripcion> inscripciones = inscripcionRepository.getAll();

        if (inscripciones.isEmpty())
            throw new InscripcionNotFoundException();

        return inscripciones;
    }

    public Inscripcion findById(InscripcionId id) {
        return inscripcionRepository.getById(id).orElseThrow(() -> new InscripcionNotFoundException(id.getValue()));
    }
}
