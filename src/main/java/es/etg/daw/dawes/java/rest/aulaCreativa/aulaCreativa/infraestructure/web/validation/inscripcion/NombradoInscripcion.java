package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.validation.inscripcion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoInscripcionValidator.class)
@Documented
public @interface NombradoInscripcion {

    // Mensaje por defecto
    String message() default "{es.etg.daw.dawes.java.aulaCreativa.infraestructure.web.validation.NombradoInscripcion}";

    // Permite agrupar validaciones (igual que en profesor)
    Class<?>[] groups() default {};

    // Permite definir metadatos adicionales en la validación
    Class<? extends Payload>[] payload() default {};
}
