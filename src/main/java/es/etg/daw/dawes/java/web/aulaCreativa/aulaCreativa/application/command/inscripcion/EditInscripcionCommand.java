package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.InscripcionId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditInscripcionCommand {
    private InscripcionId id;
    private AlumnoId alumnoId;
    //private TallerId tallerId;
    private String fechaInscripcion;
    private boolean estado;

}
