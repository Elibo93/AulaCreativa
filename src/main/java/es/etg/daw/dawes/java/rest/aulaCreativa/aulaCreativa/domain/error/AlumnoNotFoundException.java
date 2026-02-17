package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error;

import es.etg.daw.dawes.java.rest.aulaCreativa.common.domain.error.EntityNotFoundException;

public class AlumnoNotFoundException extends EntityNotFoundException {

    // Atributos
    public static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }

}
