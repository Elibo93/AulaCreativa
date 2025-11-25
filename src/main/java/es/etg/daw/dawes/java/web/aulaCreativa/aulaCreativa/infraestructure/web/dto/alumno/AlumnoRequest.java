package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AlumnoRequest(
     @NotBlank(message = "{Alumno.valid.dni.no_vacio}")
    String dni,

    @NotBlank(message = "{Alumno.valid.nombre.no_vacio}")
    String nombre,

    @NotBlank(message = "{Alumno.valid.apellido.no_vacio}")
    String apellido,

    @Email(message = "{Alumno.valid.email.valido}")
    String email,

    @NotBlank(message = "{Alumno.valid.telefono.no_vacio}")
    String telefono,

    @NotBlank(message = "{Alumno.valid.direccion.no_vacio}")
    String direccion,

    @NotBlank(message = "{Alumno.valid.fechaNacimiento.no_vacio}")
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
                p.getFechaNacimiento()
        );
    }
}
