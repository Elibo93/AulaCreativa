package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno.AlumnoFactory;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno.AlumnoRepositoryMockImpl;



public class AlumnoRepositoryMockImplTest {

    AlumnoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new AlumnoRepositoryMockImpl();  // inicializas el mock
    }

    @Test
    void save() {
        var alumno = AlumnoFactory.create();

        Alumno a = repository.save(alumno);

        assertAll(
                () -> assertNotNull(a),                             
                () -> assertNotNull(a.getId()),                     
                () -> assertNotNull(repository.getById(a.getId()))  
        );
    }

    @Test
    void getAll() {
        var alumnos = repository.getAll();

        assertAll(
                () -> assertNotNull(alumnos),
                () -> assertEquals(AlumnoFactory.getDemoData().size(), alumnos.size())
        );
    }
}

