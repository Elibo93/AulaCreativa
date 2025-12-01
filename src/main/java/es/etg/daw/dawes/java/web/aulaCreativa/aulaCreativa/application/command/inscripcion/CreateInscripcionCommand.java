package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateInscripcionCommand {
    private AlumnoId alumnoId;
    private TallerId tallerId;
    
}
