package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.FindTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindTallerService {

    private final FindTallerUseCase findTallerUseCase;

    public List<Taller> findAll() {
        return findTallerUseCase.findAll();
    }

    public Taller findById(TallerId id) {
        return findTallerUseCase.findById(id);
    }
}
