package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;

public class AlumnoFactory {

    public static final Map<AlumnoId, Alumno> getDemoData() {

        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();

        datos.put(new AlumnoId(1),
                new Alumno(
                        new AlumnoId(1),
                        "Diego",
                        "Pérez",
                        "diego@example.com",
                        "600123123",
                        "Calle Ejemplo 1",
                        "2001-05-12",
                        "2023-09-01",
                        true,
                        LocalDateTime.now()
                )
        );

        datos.put(new AlumnoId(2),
                new Alumno(
                        new AlumnoId(2),
                        "María",
                        "Gómez",
                        "maria@example.com",
                        "611456789",
                        "Avenida del Sol 22",
                        "2003-09-30",
                        "2023-09-02",
                        true,
                        LocalDateTime.now()
                )
        );

        datos.put(new AlumnoId(3),
                new Alumno(
                        new AlumnoId(3),
                        "Juan",
                        "López",
                        "juan@example.com",
                        "622987654",
                        "Plaza Mayor 10",
                        "2004-01-18",
                        "2023-09-03",
                        true,
                        LocalDateTime.now()
                )
        );

        datos.put(new AlumnoId(4),
                new Alumno(
                        new AlumnoId(4),
                        "Laura",
                        "Santos",
                        "laura@example.com",
                        "633112233",
                        "Calle Luna 45",
                        "2002-08-20",
                        "2023-09-04",
                        true,
                        LocalDateTime.now()
                )
        );

        return datos;
    }

    public static Alumno create() {

        return new Alumno(
                new AlumnoId(99),
                "AlumnoPrueba",
                "ApellidoPrueba",
                "prueba@example.com",
                "600000000",
                "Calle Prueba 123",
                "2000-01-01",
                "2023-10-01",
                true,
                LocalDateTime.now()
        );
    }

}
