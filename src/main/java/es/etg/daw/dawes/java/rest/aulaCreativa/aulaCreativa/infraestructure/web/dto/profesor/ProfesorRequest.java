package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor;

import jakarta.validation.constraints.NotBlank;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import jakarta.validation.constraints.Email;

public record ProfesorRequest(
		@NotBlank(message = "{profesor.valid.nombre.no_vacio}") String nombre,
		@NotBlank(message = "{profesor.valid.apellido.no_vacio}") String apellido,
		@NotBlank(message = "{profesor.valid.especialidad.no_vacio}") String especialidad,
		@NotBlank(message = "{profesor.valid.email.no_vacio}") @Email(message = "{common.error.email_no_valido}") String email,
		@NotBlank(message = "{profesor.valid.telefono.no_vacio}") String telefono) {

	public ProfesorRequest(Profesor p) {
		this(
				p.getNombre(),
				p.getApellido(),
				p.getEspecialidad(),
				p.getEmail(),
				p.getTelefono());
	}

}
