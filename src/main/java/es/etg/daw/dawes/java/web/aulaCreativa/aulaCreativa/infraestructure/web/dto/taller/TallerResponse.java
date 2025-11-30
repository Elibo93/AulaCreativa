package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;

public record TallerResponse(
    TallerId tallerId,
    String nombre,
    String descripcion,
    ProfesorId profesorId,
    String horaInicio,
    String horaFin,
    int aforoMaximo) {

}
