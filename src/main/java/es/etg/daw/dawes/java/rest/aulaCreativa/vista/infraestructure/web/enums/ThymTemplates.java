package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums;

/**
 * Contiene el listado de plantillas html
 */
public enum ThymTemplates {
    ALUMNO_LIST("alumnos-lista"),
    ALUMNO_LIST_PDF("pdf/alumnos-lista"),
    ALUMNO_FORM("alumno-formulario"),
    ALUMNO_FORM_DELETE("alumno-eliminar"),
    ALUMNO_DETAIL("alumnos-detalle"),
    ALUMNO_CREATED("alumno-creado"),
    ALUMNO_DELETED("alumno-eliminado"),
    ERROR_GENERIC("error/error-general");

    private final String path;

    ThymTemplates(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
