package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor;

import java.util.List;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.ProfesorNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindProfesorUseCase {

    // Atributos
    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        List<Profesor> profesores = profesorRepository.getAll();

        if (profesores.isEmpty())
            throw new ProfesorNotFoundException();

        return profesores;
    }
}
