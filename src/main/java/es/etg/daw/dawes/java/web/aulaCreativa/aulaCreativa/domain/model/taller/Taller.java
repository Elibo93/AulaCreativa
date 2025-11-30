package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Taller {

    private TallerId id;
    private String nombre;
    private String descripcion;
    private ProfesorId profesor;
    private String horaInicio;
    private String horaFin;
    private int aforoMaximo;

}
