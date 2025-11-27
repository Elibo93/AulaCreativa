package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion;

import java.time.LocalDateTime;

public record InscripcionResponse() {
        int id,
        int alumnoId,
        int tallerId,
        LocalDateTime createdAt

}
