package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error;

import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.error.EntityNotFoundException;

public class TallerNotFoundException extends EntityNotFoundException{

    //Atributos
    public static final String ENTIDAD = "taller";

    public TallerNotFoundException() {
        super(ENTIDAD);
    }

    public TallerNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}
