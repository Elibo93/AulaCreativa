package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import java.util.List;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.InscripcionNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
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

    public List<Inscripcion> findByCriteria(Integer alumnoId, Integer tallerId) {
        if (alumnoId != null && tallerId != null) {
            // Intersección
            List<Inscripcion> porAlumno = inscripcionRepository.getByAlumnoId(alumnoId);
            return porAlumno.stream()
                    .filter(i -> i.getTallerId().getValue().equals(tallerId))
                    .collect(java.util.stream.Collectors.toList());
        }

        if (alumnoId != null) {
            return inscripcionRepository.getByAlumnoId(alumnoId);
        }

        if (tallerId != null) {
            return inscripcionRepository.getByTallerId(tallerId);
        }

        return findAll();
    }
}
