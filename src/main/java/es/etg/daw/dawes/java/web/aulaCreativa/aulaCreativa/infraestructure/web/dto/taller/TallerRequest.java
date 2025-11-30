package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller;

public record TallerRequest(
    String nombre, 
    String descripcion, 
    int profesorId, 
    String horaIncio, 
    String horaFin, 
    int aforoMaximo) {

}
