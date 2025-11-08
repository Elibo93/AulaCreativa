package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Profesor {
	
	// Atributos
	private idProfesor id;
	private String nombre;
    private String especialidad;
	private String apellido;
	private String email;
	private String telefono;
	private LocalDateTime createdAt;
}
