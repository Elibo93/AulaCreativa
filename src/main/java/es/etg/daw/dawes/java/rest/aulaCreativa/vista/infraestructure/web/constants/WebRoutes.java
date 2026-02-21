package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants;

/**
 * Contiene las rutas de acceso desde el navegador
 */
public interface WebRoutes {
    public static final String HOME = "/web/home";
    public static final String ALUMNOS_BASE = "/web/alumnos";
    public static final String ALUMNOS_NUEVO = "/web/alumnos/nuevo";
    public static final String ALUMNOS_PDF = "/web/alumnos/pdf";
    public static final String ALUMNOS_ELIMINAR = "/web/alumnos/{id}/borrar";
    public static final String PROFESORES_BASE = "/web/profesores";
    public static final String PROFESORES_NUEVO = "/web/profesores/nuevo";
    public static final String PROFESORES_EDITAR = "/web/profesores/{id}/editar";
    public static final String PROFESORES_PDF = "/web/profesores/pdf";
    public static final String PROFESORES_ELIMINAR = "/web/profesores/{id}/borrar";
    public static final String TALLERES_BASE = "/web/talleres";
    public static final String TALLERES_NUEVO = "/web/talleres/nuevo";
    public static final String TALLERES_PDF = "/web/talleres/pdf";
    public static final String TALLERES_ELIMINAR = "/web/talleres/{id}/borrar";
    public static final String INSCRIPCIONES_BASE = "/web/inscripciones";
    public static final String INSCRIPCIONES_NUEVA = "/web/inscripciones/nueva";
    public static final String INSCRIPCIONES_ELIMINAR = "/web/inscripciones/{id}/borrar";
    public static final String INSCRIPCIONES_PDF = "/web/inscripciones/pdf";
}
