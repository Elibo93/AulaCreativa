package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.EditAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditAlumnoService {
  private final EditAlumnoUseCase editAlumnoUseCase;

    public Alumno update(EditAlumnoCommand comando) {
        Alumno alumno = editAlumnoUseCase.update(comando);
        return alumno;
    }  

}
