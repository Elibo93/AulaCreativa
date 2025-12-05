package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.alumno.AlumnoEntityJpaRepository;

@DataJpaTest(showSql = true)

public class AlumnoEntityJpaRepositoryTest {

    @Autowired

    private AlumnoEntityJpaRepository repository;

   @Test
   @Order(1)
   
   void findAll(){

    var alumnos = repository.findAll();

    assertAll(
        () -> assertNotNull(alumnos),
        () -> assertTrue(alumnos.isEmpty()));
   }

   @Test
   @Order(2)

   void findById() {
        update(); 
        var p = AlumnoFactory.create(); 

        var alumno = repository.findById(p.getId().getValue()).get();

        assertAll(
                () -> assertNotNull(alumno),
                () -> assertEquals(alumno.getId(), p.getId().getValue()),
                () -> assertEquals(alumno.getNombre(), p.getNombre())
                );
    }


}
