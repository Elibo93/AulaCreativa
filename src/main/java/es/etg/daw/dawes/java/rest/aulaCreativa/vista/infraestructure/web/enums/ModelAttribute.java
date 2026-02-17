package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums;

/**
 * Representa los posibles atributos que podemos usar
 * en los modelos de la vista
 */
public enum ModelAttribute {
    ALUMNO_LIST("alumnos"),
    PROFESOR_LIST("profesores"),
    TALLER_LIST("talleres"),
    INSCRIPCION_LIST("inscripciones"),

    AULA_CREATIVA("Aula Creativa"),

    SINGLE_ALUMNO("alumno"),
    SINGLE_PROFESOR("profesor"),
    SINGLE_TALLER("taller"),
    SINGLE_INSCRIPCION("inscripcion"),

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
