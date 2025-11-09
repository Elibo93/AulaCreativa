package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoUseCase {
    public final AlumnoRepository alumnoRepository;

    public void delete(AlumnoId id) {
        alumnoRepository.deleteById(id);
    }

}
