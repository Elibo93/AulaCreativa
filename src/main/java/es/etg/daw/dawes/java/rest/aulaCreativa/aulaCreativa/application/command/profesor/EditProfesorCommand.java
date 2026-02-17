package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditProfesorCommand {

    //Atributos
    private ProfesorId id;
    private String especialidad;
	private String email;
	private String telefono;

}
