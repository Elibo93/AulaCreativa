### Ejecución de las pruebas
---

La ejecución de pruebas tiene como propósito validar que todos los endpoints de la API funcionan conforme a los requisitos especificados en el Plan de Pruebas, verificando las respuestas correctas, los errores esperados y la coherencia en la lógica de negocio.

#### Metodología de ejecución

Las pruebas se ejecutaron de manera manual utilizando:

- Postman para realizar peticiones HTTP.

- Base de datos aislada para evitar alteración de datos reales.

- Colección organizada por módulos (Alumnos, Profesores, Talleres e Inscripciones ).

Para cada test se registró:

1. Entrada enviada
2. Respuesta esperada
3. Código HTTP devuelto
4. Resultado: *Correcto / Fallido*

#### Alumnos

| **Caso** | **Método de prueba** | **Descripción**                                        | **Datos utilizados**                       | **Resultado esperado**                        | **Estado** |
|----------|----------------------|--------------------------------------------------------|--------------------------------------------|-----------------------------------------------|------------|
| CP-A1    | findAll()            | Verificar que existen alumnos y la lista no está vacía | BD con datos iniciales o insertados        | Lista no nula y con elementos                 | ✔ Correcto |
| CP-A2    | findById()           | Búsqueda correcta por ID                               | Alumno generado con AlumnoFactory.create() | Alumno encontrado con ID y nombre coincidente | ✔ Correcto |
| CP-A3    | findByNombre()       | Comprobar búsqueda por nombre                          | Nombre del alumno creado                   | Objeto no nulo y coincidencia exacta          | ✔ Correcto |
| CP-A4    | create()             | Crear un alumno con datos válidos                      | Alumno mapeado sin ID                      | ID generado + coincidencia de datos           | ✔ Correcto |
| CP-A5    | update()             | Actualizar un alumno existente                         | Alumno generado y guardado                 | Persistencia exitosa y campos actualizados    | ✔ Correcto |
| CP-A6    | delete()             | Eliminar alumno por ID                                 | ID existente                               | findById() devuelve vacío                     | ✔ Correcto |


#### Profesores

| **Caso** | **Método de prueba** | **Descripción**            | **Datos utilizados**      | **Resultado esperado**                      | **Estado** |
|----------|----------------------|----------------------------|---------------------------|---------------------------------------------|------------|
| CP-P1    | findAll()            | Verificar listado completo | Datos iniciales           | Lista no nula y con elementos               | ✔ Correcto |
| CP-P2    | findById()           | Recuperar profesor por ID  | Profesor generado         | Profesor no nulo + ID coincide              | ✔ Correcto |
| CP-P3    | findByNombre()       | Buscar profesor por nombre | Nombre de ProfesorFactory | Devuelve el profesor correcto               | ✔ Correcto |
| CP-P4    | create()             | Crear profesor nuevo       | Datos válidos sin ID      | ID generado + sincronización con la entidad | ✔ Correcto |
| CP-P5    | update()             | Actualizar profesor        | Profesor guardado         | Datos actualizados correctamente            | ✔ Correcto |
| CP-P6    | delete()             | Eliminar profesor          | ID existente              | Registro eliminado correctamente            | ✔ Correcto |

#### Talleres

| **Caso** | **Método de prueba** | **Descripción**            | **Datos utilizados**   | **Resultado esperado**           | **Estado** |
|----------|----------------------|----------------------------|------------------------|----------------------------------|------------|
| CP-T1    | findAll()            | Listar talleres existentes | BD con talleres        | Lista no vacía                   | ✔ Correcto |
| CP-T2    | findById()           | Buscar taller por ID       | TallerFactory.create() | Coincidencia de ID y nombre      | ✔ Correcto |
| CP-T3    | create()             | Crear taller               | Datos correctos        | ID generado + campos correctos   | ✔ Correcto |
| CP-T4    | update()             | Actualizar taller          | Taller guardado        | Valores actualizados             | ✔ Correcto |
| CP-T5    | delete()             | Eliminar taller            | ID existente           | Eliminación exitosa              | ✔ Correcto |
| CP-T5    | delete()             | Eliminar profesor          | ID existente           | Registro eliminado correctamente | ✔ Correcto |

#### Inscripciones

| **Caso** | **Método de prueba** | **Descripción**          | **Datos utilizados**           | **Resultado esperado**            | **Estado** |
|----------|----------------------|--------------------------|--------------------------------|-----------------------------------|------------|
| CP-I1    | findAll()            | Listar inscripciones     | BD inicial                     | Lista con elementos               | ✔ Correcto |
| CP-I2    | findById()           | Recuperar inscripción    | Inscripción creada             | ID válido y relación cargada      | ✔ Correcto |
| CP-I3    | create()             | Crear inscripción válida | alumnoId + tallerId existentes | Relación persistida correctamente | ✔ Correcto |
| CP-I4    | update()             | Modificar inscripción    | Cambiar taller o fecha         | Objeto actualizado                | ✔ Correcto |
| CP-I5    | delete()             | Eliminar inscripción     | ID existente                   | Eliminación confirmada            | ✔ Correcto |
| CP-I6    | delete()             | Eliminar profesor        | ID existente                   | Registro eliminado correctamente  | ✔ Correcto |

                  
[Volver](/README.md)