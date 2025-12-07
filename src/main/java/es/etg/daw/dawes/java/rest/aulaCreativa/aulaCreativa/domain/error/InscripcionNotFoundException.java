package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.error;

import es.etg.daw.dawes.java.rest.aulaCreativa.common.domain.error.EntityNotFoundException;

public class InscripcionNotFoundException extends EntityNotFoundException{

    //Atributos
    public static final String ENTIDAD = "inscripcion";

    public InscripcionNotFoundException() {
        super(ENTIDAD);
    }

    public InscripcionNotFoundException(int id) {
        super(ENTIDAD, id);
    }


}
