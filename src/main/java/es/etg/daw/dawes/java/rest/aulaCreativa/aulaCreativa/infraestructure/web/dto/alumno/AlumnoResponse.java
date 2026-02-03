package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlumnoResponse(
        @Schema(description = "ID único del producto", example = "23")
        int id,

        @Schema(description = "Número del DNI del alumno", example = "12345678A")
        String dni,

        @Schema(description = "Nombre del alumno", example = "Juan")
        String nombre,

        @Schema(description = "Apellido del alumno", example = "Rodriguez")
        String apellido,

        @Schema(description = "Email del alumno", example = "alumno@email.com")
        String email,

        @Schema(description = "Número de teléfono del alumno", example = "123456789")
        String telefono,

        @Schema(description = "Dirección del alumno", example = "C/ El Pinar 34")
        String direccion,

        @Schema(description = "Fecha de nacimiento del alumno", example = "26/05/1993")
        String fechaNacimiento,

        @Schema(description = "Fecha de creación del alumno", example = "03/02/2026")
        LocalDateTime createdAt
)       {
        
}
