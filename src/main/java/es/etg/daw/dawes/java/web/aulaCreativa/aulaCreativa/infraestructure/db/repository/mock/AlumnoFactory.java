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
                                new Alumno(new AlumnoId(1), "Nombre Alumno 1", 1.01, LocalDateTime.now()
                                                );
                datos.put(new AlumnoId(2),
                                new Alumno(new AlumnoId(2), "Nombre Alumno 2", 1.02, LocalDateTime.now(),
                                                new CategoriaId(1)));
                datos.put(new AlumnoId(3),
                                new Alumno(new AlumnoId(3), "Nombre Alumno 3", 1.03, LocalDateTime.now(),
                                                new CategoriaId(2)));
                datos.put(new AlumnoId(4),
                                new Alumno(new AlumnoId(4), "Nombre Alumno 4", 1.04, LocalDateTime.now(),
                                                new CategoriaId(2)));

                return datos;
        }
    
        public static Alumno create() {
                return new Alumno(new AlumnoId(9), "AlumnoPrueba", 9.99, LocalDateTime.now(), new CategoriaId(1));
        }


}
