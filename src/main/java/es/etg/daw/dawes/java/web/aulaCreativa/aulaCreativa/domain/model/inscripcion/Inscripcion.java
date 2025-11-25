package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Inscripcion {
    private InscripcionId id;
    private AlumnoId alumnoId;
    private TallerId tallerId;
    private String fechaInscripcion;
    private LocalDateTime createdAt;

}
