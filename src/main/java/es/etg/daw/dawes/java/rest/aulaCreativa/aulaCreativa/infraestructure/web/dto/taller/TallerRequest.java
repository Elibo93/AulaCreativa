package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;

public record TallerRequest(
    String nombre, 
    String descripcion, 
    int profesorId, 
    String horaInicio, 
    String horaFin, 
    int aforoMaximo) {

    public TallerRequest(Taller t) {
        this(
            t.getNombre(),
            t.getDescripcion(),
            t.getProfesor().getValue(),
            t.getHoraInicio(),
            t.getHoraFin(),
            t.getAforoMaximo()
        );
    }
}
