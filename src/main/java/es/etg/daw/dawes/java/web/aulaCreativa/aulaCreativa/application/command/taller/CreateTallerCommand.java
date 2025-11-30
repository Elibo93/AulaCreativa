package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.taller;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateTallerCommand {

    //Atributos
    private String nombre;
    private String descripcion;
    private ProfesorId profesorId;
    private String horaInicio;
    private String horaFin;
    private int aforoMaximo;
}
