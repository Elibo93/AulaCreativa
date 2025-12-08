package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.CreateTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateTallerService {

    //Atributos
    private final CreateTallerUseCase createTallerUseCase;

    public Taller createTaller(CreateTallerCommand command) {
        Taller taller = createTallerUseCase.create(command);
        return taller;
    }
}
