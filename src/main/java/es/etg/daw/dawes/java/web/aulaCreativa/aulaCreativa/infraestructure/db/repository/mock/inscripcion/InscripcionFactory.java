package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.inscripcion;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;

public class InscripcionFactory {

    public static final Map<InscripcionId, Inscripcion> getDemoData() {

        Map<InscripcionId, Inscripcion> datos = new LinkedHashMap<>();

        datos.put(new InscripcionId(1),
                new Inscripcion(
                        new InscripcionId(1),
                        new AlumnoId(1),
                        new TallerId(10),
                        LocalDateTime.of(2025, 1, 10, 10, 0),
                        
                )
        );

        datos.put(new InscripcionId(2),
                new Inscripcion(
                        new InscripcionId(2),
                        new AlumnoId(2),
                        new TallerId(10),
                        LocalDateTime.of(2025, 1, 11, 11, 30),
                        
                )
        );

        datos.put(new InscripcionId(3),
                new Inscripcion(
                        new InscripcionId(3),
                        new AlumnoId(3),
                        new TallerId(11),
                        LocalDateTime.of(2025, 1, 12, 9, 45),
                        
                )
        );

        datos.put(new InscripcionId(4),
                new Inscripcion(
                        new InscripcionId(4),
                        new AlumnoId(4),
                        new TallerId(12),
                        LocalDateTime.of(2025, 1, 15, 17, 0),
                        
                )
        );

        return datos;
    }

    public static Inscripcion create() {

        return new Inscripcion(
                new InscripcionId(99),
                new AlumnoId(99),
                new TallerId(99),
                LocalDateTime.now(),
               
    }
}
