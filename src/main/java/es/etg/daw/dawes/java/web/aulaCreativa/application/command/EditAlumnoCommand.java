package es.etg.daw.dawes.java.web.aulaCreativa.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)

public class EditAlumnoCommand {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

}