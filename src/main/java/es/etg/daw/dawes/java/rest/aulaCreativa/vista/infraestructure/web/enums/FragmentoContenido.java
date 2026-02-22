package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums;

public enum FragmentoContenido {

    ALUMNO_LIST("fragments/content/alumnos-lista"),
    ALUMNO_FORM("fragments/content/alumno-formulario"),
    ALUMNO_CREATED("fragments/content/alumno-creado"),

    PROFESOR_LIST("fragments/content/profesores-lista"),
    PROFESOR_FORM("fragments/content/profesor-formulario"),

    TALLER_LIST("fragments/content/talleres-lista"),
    TALLER_FORM("fragments/content/taller-formulario"),

    INSCRIPCION_LIST("fragments/content/inscripciones-lista"),
    INSCRIPCION_FORM("fragments/content/inscripcion-formulario"),

    HOME_VIEW("fragments/content/index");

    private final String path;

    FragmentoContenido(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
