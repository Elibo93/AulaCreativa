package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;

public class AlumnoFactory {

        public static final Map<AlumnoId, Alumno> getDemoData() {

                Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();

                datos.put(new AlumnoId(1),
                                new Alumno(
                                                new AlumnoId(1),
                                                "12345678A",
                                                "Diego",
                                                "Pérez",
                                                "diego@example.com",
                                                "600123123",
                                                "Calle Ejemplo 1",
                                                "2001-05-12",
                                                LocalDateTime.now()));

                datos.put(new AlumnoId(2),
                                new Alumno(
                                                new AlumnoId(2),
                                                "23456789B",
                                                "María",
                                                "Gómez",
                                                "maria@example.com",
                                                "611456789",
                                                "Avenida del Sol 22",
                                                "2003-09-30",
                                                LocalDateTime.now()));

                datos.put(new AlumnoId(3),
                                new Alumno(
                                                new AlumnoId(3),
                                                "34567890C",
                                                "Juan",
                                                "López",
                                                "juan@example.com",
                                                "622987654",
                                                "Plaza Mayor 10",
                                                "2004-01-18",
                                                LocalDateTime.now()));

                datos.put(new AlumnoId(4),
                                new Alumno(
                                                new AlumnoId(4),
                                                "45678901D",
                                                "Laura",
                                                "Santos",
                                                "laura@example.com",
                                                "633112233",
                                                "Calle Luna 45",
                                                "2002-08-20",
                                                LocalDateTime.now()));

                return datos;
        }

        public static Alumno create() {

                return new Alumno(
                                new AlumnoId(5),
                                "00000000Z",
                                "AlumnoPrueba",
                                "ApellidoPrueba",
                                "prueba@example.com",
                                "600000000",
                                "Calle Prueba 123",
                                "2000-01-01",
                                LocalDateTime.now());
        }
}
