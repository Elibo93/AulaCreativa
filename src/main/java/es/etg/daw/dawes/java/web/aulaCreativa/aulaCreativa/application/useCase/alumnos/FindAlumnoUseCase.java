package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import java.util.List;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        List<Alumno> alumnos = alumnoRepository.getAll();

        if (alumnos.isEmpty())
            throw new AlumnoNotFoundException();

        return alumnos;
    }

}
