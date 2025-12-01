package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller;

public record TallerResponse(
    int id,
    String nombre,
    String descripcion,
    int profesorId,
    String horaInicio,
    String horaFin,
    int aforoMaximo) {

}
