package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class inscripcion {
    private InscripcionId id;
    private AlumnoId alumnoId;
    //private TallerId tallerId;
    private String fechaInscripcion;
    private boolean activo;
    private LocalDateTime createdAt;

}
