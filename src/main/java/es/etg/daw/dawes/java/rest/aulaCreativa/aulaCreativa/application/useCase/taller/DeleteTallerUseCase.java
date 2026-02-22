package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTallerUseCase {

    private final TallerRepository tallerRepository;

    public void delete(TallerId id) {
        tallerRepository.deleteById(id);
    }
}
