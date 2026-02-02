package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums;

/**
 * Representa los posibles atributos que podemos usar
 * en los modelos de la vista
 */
public enum ModelAttribute {
    ALUMNO_LIST("alumnos"),
    SINGLE_ALUMNO("alumno"),
    ERROR_MESSAGE("errorMsg"),
    SUCCESS_MESSAGE("successMsg");

    private final String name;

    ModelAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
