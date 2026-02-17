package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoUseCase {
    public final AlumnoRepository alumnoRepository;

    public void delete(AlumnoId id) {
        alumnoRepository.deleteById(id);
    }

}
