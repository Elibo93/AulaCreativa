package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateProfesorCommand {

    //Atributos
    private String nombre;
	private String apellido;
    private String especialidad;
	private String email;
	private String telefono;
    
}
