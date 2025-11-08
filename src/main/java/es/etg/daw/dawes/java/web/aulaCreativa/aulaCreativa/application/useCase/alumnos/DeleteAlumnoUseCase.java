package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoUseCase {
    public final AlumnoRepository alumnoRepository;

    public void delete(AlumnoId id) {
        alumnoRepository.deleteById(id);
    }

}
