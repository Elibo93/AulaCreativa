package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import java.util.List;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
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

    public Alumno findById(AlumnoId id) {
        return alumnoRepository.getById(id).orElseThrow(() -> new AlumnoNotFoundException());
    }

}
