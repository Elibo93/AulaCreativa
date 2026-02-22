package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;

public record EditTallerCommand(
        TallerId id,
        String nombre,
        String descripcion,
        ProfesorId profesorId,
        String horaInicio,
        String horaFin,
        int aforoMaximo) {
}
