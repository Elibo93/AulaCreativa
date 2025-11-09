package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error;

import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.error.EntityNotFoundException;

public class ProfesorNotFoundException extends EntityNotFoundException{

    //Atributos
    public static final String ENTIDAD = "profesor";

    public ProfesorNotFoundException() {
        super(ENTIDAD);
    }

    public ProfesorNotFoundException(int id) {
        super(ENTIDAD, id);
    }

}
