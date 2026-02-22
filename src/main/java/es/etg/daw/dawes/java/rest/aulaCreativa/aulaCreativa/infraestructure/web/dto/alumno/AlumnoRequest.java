package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.validation.alumno.NombradoAlumno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AlumnoRequest(
        @NotBlank(message = "{Alumno.valid.dni.no_vacio}") String dni,

        @NotBlank(message = "{Alumno.valid.nombre.no_vacio}") @NombradoAlumno(message = "{producto.valid.nombre.nombrado_validation}") String nombre,

        @NotBlank(message = "{Alumno.valid.apellido.no_vacio}") String apellido,

        @Email(message = "{Alumno.valid.email.valido}") String email,

        @NotBlank(message = "{Alumno.valid.telefono.no_vacio}") String telefono,

        String direccion,

        String fechaNacimiento


    

) {

    // Constructor de conveniencia para crear un request desde el dominio
    public AlumnoRequest(Alumno p) {
        this(
                p.getDni(),
                p.getNombre(),
                p.getApellido(),
                p.getEmail(),
                p.getTelefono(),
                p.getDireccion(),
                p.getFechaNacimiento());
    }
}
