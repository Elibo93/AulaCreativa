package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.EditTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.EditTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditTallerService {

    private final EditTallerUseCase editTallerUseCase;

    public Taller update(EditTallerCommand command) {
        return editTallerUseCase.update(command);
    }
}
