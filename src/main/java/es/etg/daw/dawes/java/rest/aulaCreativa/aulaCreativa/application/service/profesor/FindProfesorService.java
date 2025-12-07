package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor.FindProfesorUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindProfesorService {

    private final FindProfesorUseCase findProfesorUseCase;

    public List<Profesor> findAll() {
        return findProfesorUseCase.findAll();
    }
}
