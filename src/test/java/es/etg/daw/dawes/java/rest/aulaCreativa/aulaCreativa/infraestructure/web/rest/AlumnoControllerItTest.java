package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.rest;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno.AlumnoFactory;

@SpringBootTest
public class AlumnoControllerItTest {

    @Autowired
    private AlumnoController controller;

    @Test
    public void When_AllAlumnos_Expect_Lista() {

        int numAlumnos = AlumnoFactory.getDemoData().values().size();

        var lista = controller.allAlumnos();

        assertAll(
                () -> assertNotNull(lista),
                () -> assertEquals(numAlumnos, lista.size())
        );
    }
}
