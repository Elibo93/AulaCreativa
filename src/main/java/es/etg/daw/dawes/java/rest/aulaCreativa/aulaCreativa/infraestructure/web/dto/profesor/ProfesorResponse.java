package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;

public record ProfesorResponse(
        ProfesorId id,
        String nombre,
        String apellido,
        String especialidad,
        LocalDateTime createdAt) {

}
