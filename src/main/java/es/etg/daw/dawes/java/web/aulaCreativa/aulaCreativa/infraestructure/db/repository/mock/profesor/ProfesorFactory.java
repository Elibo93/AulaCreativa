package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.profesor;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;

public class ProfesorFactory {

    public static final Map<ProfesorId, Profesor> getDemoData(){
        Map<ProfesorId, Profesor> datos = new LinkedHashMap<>();

        datos.put(
            new ProfesorId(1),
            new Profesor(
                new ProfesorId(1),
                "Laura",
                "García",
                "Dibujo",
                "laura.garcia@aulacreativa.com", 
                "612345678",
                LocalDateTime.now()
            )
        );

        datos.put(
            new ProfesorId(2),
            new Profesor(
                new ProfesorId(2),
                "Miguel",
                "Fernández",
                "Música",
                "miguel.fernandez@aulacreativa.com",
                "622334455",
                LocalDateTime.now()
            )
        );

        datos.put(
            new ProfesorId(3),
            new Profesor(
                new ProfesorId(3),
                "Sara",
                "López",
                "Teatro",
                "sara.lopez@aulacreativa.com",
                "633221144",
                LocalDateTime.now()
            )
        );

        datos.put(
            new ProfesorId(4),
            new Profesor(
                new ProfesorId(4),
                "Álvaro",
                "Martínez",
                "Pintura",
                "alvaro.martinez@aulacreativa.com",
                "644556677",
                LocalDateTime.now()
            )
        );

        return datos;
    }

    public static Profesor create() {
        return new Profesor(
                new ProfesorId(5),
                "Andrés",
                "Carmelo",
                "Diseño",
                "andres.carmelo@aulacreativa.com",
                "654256672",
                LocalDateTime.now());
    }
}
