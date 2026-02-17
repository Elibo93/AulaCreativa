package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditAlumnoService {
  private final EditAlumnoUseCase editAlumnoUseCase;

  
    public Alumno update(EditAlumnoCommand comando) {
        Alumno alumno = editAlumnoUseCase.update(comando);
        return alumno;
    }  

}
