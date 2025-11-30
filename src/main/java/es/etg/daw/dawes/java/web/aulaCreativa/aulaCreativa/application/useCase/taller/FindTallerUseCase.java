package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.taller;

import java.util.List;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error.TallerNotFoundException;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindTallerUseCase {

    private final TallerRepository tallerRepository;

    public List<Taller> findAll() {
        List<Taller> talleres = tallerRepository.getAll();

        if (talleres.isEmpty()) {
            throw new TallerNotFoundException();
        }
        return talleres;
    }
}
