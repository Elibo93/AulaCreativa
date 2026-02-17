package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import jakarta.validation.constraints.NotNull;

public record InscripcionRequest(

    @NotNull(message = "{Inscripcion.valid.alumnoId.no_nulo}")
    Integer alumnoId,

    @NotNull(message = "{Inscripcion.valid.tallerId.no_nulo}")
    Integer tallerId
    
) {

    // Constructor de conveniencia desde el dominio
    public InscripcionRequest(Inscripcion i) {
        this(
            i.getAlumnoId().getValue(),
            i.getTallerId().getValue()
        );
    }
}
