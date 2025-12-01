package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion.FindInscripcionUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindInscripcionService {

    private final FindInscripcionUseCase findInscripcionUseCase;

    public List<Inscripcion> findAll() {
        return findInscripcionUseCase.findAll();
    }

    public Inscripcion findById(InscripcionId id) {
        return findInscripcionUseCase.findById(id);
    }

}
