package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateInscripcionUseCase {
    private final InscripcionRepository inscripcionRepository;

    public Inscripcion create(CreateInscripcionCommand comando) {
        Inscripcion inscripcion = Inscripcion.builder()
                .alumnoId(comando.alumnoId())
                .tallerId(comando.tallerId())
                .createdAt(LocalDateTime.now())
                .build();

        return inscripcionRepository.save(inscripcion);
    }
}
