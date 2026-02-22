package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.DeleteTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteTallerService {

    private final DeleteTallerUseCase deleteTallerUseCase;

    public void delete(TallerId id) {
        deleteTallerUseCase.delete(id);
    }
}
