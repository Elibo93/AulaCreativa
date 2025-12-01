package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.inscripcion;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion.EditInscripcionCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error.InscripcionNotFoundException;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditInscripcionUseCase {
    private final InscripcionRepository inscripcionRepository;

   public Inscripcion update(EditInscripcionCommand command) {
       return inscripcionRepository.getById(command.id())
               .map(p -> { // Actualizamos los atributos del objeto
                   p.setTallerId(command.tallerId());
                   p.setAlumnoId(command.alumnoId());
                   return inscripcionRepository.save(p);
               })
               .orElseThrow(() -> new InscripcionNotFoundException(command.id().getValue())); // Lo cambiamos

   }

}
