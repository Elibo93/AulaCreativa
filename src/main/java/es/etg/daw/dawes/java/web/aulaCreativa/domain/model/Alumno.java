package es.etg.daw.dawes.java.web.aulaCreativa.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Alumno {
	
	// Atributos
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String direccion;
	private LocalDateTime createdAt;
}
