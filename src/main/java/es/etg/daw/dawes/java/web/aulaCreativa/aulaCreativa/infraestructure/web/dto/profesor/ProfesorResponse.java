package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.ProfesorId;

public record ProfesorResponse(
    ProfesorId id,
    String nombre,
    String apellido,
    String especialidad,
    LocalDateTime createdAt) {

}
