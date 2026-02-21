package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums;

/**
 * Contiene el listado de plantillas html
 */
public enum ThymTemplates {

    ALUMNO_LIST("alumnos-lista"),
    ALUMNO_LIST_PDF("pdf/alumnos-lista"),
    ALUMNO_FORM("alumno-formulario"),
    ALUMNO_DETAIL("alumnos-detalle"),
    ALUMNO_CREATED("alumno-creado"),

    PROFESOR_LIST("profesores-lista"),
    PROFESOR_LIST_PDF("pdf/profesores-lista"),
    PROFESOR_FORM("profesor-formulario"),

    TALLER_LIST("talleres-lista"),
    TALLER_LIST_PDF("pdf/talleres-lista"),
    TALLER_FORM("taller-formulario"),

    INSCRIPCION_LIST("inscripciones-lista"),
    INSCRIPCION_LIST_PDF("pdf/inscripciones-lista"),
    INSCRIPCION_FORM("inscripcion-formulario"),

    HOME_VIEW("index"),
    MAIN_LAYOUT("main-layout"),
    ERROR_GENERIC("error/error-general");

    private final String path;

    ThymTemplates(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
