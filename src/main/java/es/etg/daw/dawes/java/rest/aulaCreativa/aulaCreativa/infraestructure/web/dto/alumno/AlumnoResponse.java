package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno;

import java.time.LocalDateTime;

public record AlumnoResponse(
        int id,
        String dni,
        String nombre,
        String apellido,
        String email,
        String telefono,
        String direccion,
        String fechaNacimiento,
        LocalDateTime createdAt
)       {
        
}
