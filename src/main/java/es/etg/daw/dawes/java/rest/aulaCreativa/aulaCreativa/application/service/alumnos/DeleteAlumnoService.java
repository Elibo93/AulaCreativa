package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoService {
    
    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    public void delete(AlumnoId id) {
        deleteAlumnoUseCase.delete(id);
    }

}


