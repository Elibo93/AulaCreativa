package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor;

public record ProfesorRequest(
	String nombre,
    String especialidad,
	String apellido,
	String email,
	String telefono) {

}
