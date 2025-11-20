package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;

public class AlumnoFactory {

    public static Map<Integer, Alumno> getDemoData() {
        Map<Integer, Alumno> datos = new LinkedHashMap<>();

        datos.put(1,
            Alumno.builder()
                .id(1)
                .nombre("Diego")
                .apellido("Pérez")
                .email("diego@example.com")
                .telefono("600123123")
                .direccion("Calle Ejemplo 1")
                .fechaNacimiento("2005-04-12")
                .createdAt(LocalDateTime.now())
                .build()
        );

        datos.put(2,
            Alumno.builder()
                .id(2)
                .nombre("María")
                .apellido("Gómez")
                .email("maria@example.com")
                .telefono("611456789")
                .direccion("Avenida del Sol 22")
                .fechaNacimiento("2003-09-30")
                .createdAt(LocalDateTime.now())
                .build()
        );

        datos.put(3,
            Alumno.builder()
                .id(3)
                .nombre("Juan")
                .apellido("López")
                .email("juan@example.com")
                .telefono("622987654")
                .direccion("Plaza Mayor 10")
                .fechaNacimiento("2004-01-18")
                .createdAt(LocalDateTime.now())
                .build()
        );

        return datos;
    }

    public static Alumno create() {
        return Alumno.builder()
            .id(99)
            .nombre("AlumnoPrueba")
            .apellido("PruebaApellido")
            .email("prueba@example.com")
            .telefono("600000000")
            .direccion("Calle Prueba 123")
            .fechaNacimiento("2000-01-01")
            .createdAt(LocalDateTime.now())
            .build();
    }
}
