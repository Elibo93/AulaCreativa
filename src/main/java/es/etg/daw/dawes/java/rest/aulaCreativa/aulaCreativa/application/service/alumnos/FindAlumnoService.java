package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService {

    private final FindAlumnoUseCase findAlumnoUseCase;

    public List<Alumno> findAll() {
        return findAlumnoUseCase.findAll();
    }

    public Alumno findById(AlumnoId id) {
        return findAlumnoUseCase.findById(id);
    }
}
