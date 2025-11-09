package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.error;

public class AlumnoNotFoundException extends EntityNotFoundException{

    //Atributos
    public static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }

}

