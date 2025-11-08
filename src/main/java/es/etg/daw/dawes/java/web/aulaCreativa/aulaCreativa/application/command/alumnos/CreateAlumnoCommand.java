<<<<<<<< HEAD:src/main/java/es/etg/daw/dawes/java/web/aulaCreativa/aulaCreativa/application/command/CreateAlumnoCommand.java
package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command;
========
package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos;
>>>>>>>> 10a31632194653131cc64149c35db9e45d4ec4f2:src/main/java/es/etg/daw/dawes/java/web/aulaCreativa/aulaCreativa/application/command/alumnos/CreateAlumnoCommand.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateAlumnoCommand {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    
}
