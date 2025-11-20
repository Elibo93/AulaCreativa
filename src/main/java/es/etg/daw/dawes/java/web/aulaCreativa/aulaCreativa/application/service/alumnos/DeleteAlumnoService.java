package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoService {
    
    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    public void delete(AlumnoId id) {
        deleteAlumnoUseCase.delete(id);

    }

}


