package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.profesor;

import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditProfesorCommand {

    //Atributos
    private ProfesorId id;
    private String nombre;
    private String apellido;
    private String especialidad;
	private String email;
	private String telefono;

}
