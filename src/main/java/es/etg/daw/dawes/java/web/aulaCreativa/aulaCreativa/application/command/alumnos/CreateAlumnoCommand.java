package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateAlumnoCommand {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    
}
