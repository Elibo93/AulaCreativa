package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.FindAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService {

     private final FindAlumnoUseCase findAlumnoUseCase;

    public List<Alumno> findAll() {
        return findAlumnoUseCase.findAll();
    }
}
