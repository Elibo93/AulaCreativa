package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto;

import java.time.LocalDateTime;

public record AlumnoResponse(
        int id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        String direccion,
        String fechaNacimiento,
        String fechaAlta,
        boolean activo,
        LocalDateTime createdAt
) {}

