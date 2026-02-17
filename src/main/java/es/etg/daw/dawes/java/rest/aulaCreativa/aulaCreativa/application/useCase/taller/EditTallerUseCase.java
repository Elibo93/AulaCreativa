package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.EditTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.TallerNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditTallerUseCase {

    private final TallerRepository tallerRepository;

    public Taller update(EditTallerCommand command) {
        return tallerRepository.getById(command.id())
                .map(t -> {
                    t.setNombre(command.nombre());
                    t.setDescripcion(command.descripcion());
                    t.setProfesor(command.profesorId());
                    t.setHoraInicio(command.horaInicio());
                    t.setHoraFin(command.horaFin());
                    t.setAforoMaximo(command.aforoMaximo());
                    return tallerRepository.save(t);
                })
                .orElseThrow(() -> new TallerNotFoundException(command.id().getValue()));
    }
}
