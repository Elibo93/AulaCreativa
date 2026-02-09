### Diseño de los servicios REST

--- 

#### Introducción al diseño de los servicios REST

El diseño de los servicios REST de la aplicación Aula Creativa sigue principios de uniformidad, simplicidad y extensibilidad. Se ha definido una estructura coherente para todos los recursos, basada en rutas limpias, separación clara de responsabilidades y un formato de respuesta homogéneo.
Además, el sistema contempla diferentes roles (administración, alumnos, profesores) y expone endpoints específicos para cada uno, garantizando un control de permisos adecuado.

La API utiliza:
- Rutas en plural para colecciones.
- Versionado en la ruta base: **/api/v1.**
- Respuestas JSON estructuradas.
- Manejo estandarizado de errores.
- Fechas en formato ISO 8601.
- Operaciones representadas por métodos HTTP adecuados **(GET, POST, PUT, DELETE).**
  
Con estas pautas, la API es fácil de consumir, mantener y extender, y soporta todas las funcionalidades del sistema actual y futuros módulos.


### Endpoints REST — Aula Creativa

#### 1. Alumnos

- ##### 1.1 CRUD de alumnos

    | Operación        | Método | Endpoint             | Body Ejemplo                                                                                                                           | Código | Ejemplo Respuesta                          | Errores        |
    |------------------|--------|----------------------|------------------------------------------------------------------------------------------------------------------------------------------|--------|---------------------------------------------|----------------|
    | Crear alumno     | POST   | /api/v1/alumnos      | { "nombre": "Diego", "apellidos": "Romero", "dni": "12345678A", "email": "diego@example.com" }                                          | 201    | { "idAlumno": 1, "nombre": "Diego" }        | 400,401,409    |
    | Listar alumnos   | GET    | /api/v1/alumnos      | -                                                                                                                                        | 200    | { "meta": {...}, "data": [] }              | 400,401        |
    | Ver alumno       | GET    | /api/v1/alumnos/{id} | -                                                                                                                                        | 200    | { "idAlumno": 1, "nombre": "Diego" }       | 404,401        |
    | Modificar alumno | PUT    | /api/v1/alumnos/{id} | { "nombre": "Diego", "email": "nuevo@example.com" }                                                                                     | 200    | { "idAlumno": 1, "email": "nuevo@example.com" } | 400,404,401 |
    | Eliminar alumno  | DELETE | /api/v1/alumnos/{id} | -                                                                                                                                        | 204    | -                                           | 404,401,403    |

- ##### 1.2 Funcionalidades del alumno

    ###### Consultar asistencias del alumno

    | Operación               | Método | Endpoint                             | Código | Respuesta Ejemplo                             | Errores |
    |-------------------------|--------|--------------------------------------|--------|-----------------------------------------------|---------|
    | Consultar asistencias   | GET    | /api/v1/alumnos/{id}/asistencias     | 200    | { "alumnoId": 1, "asistencias": [] }          | 404,401 |

    ###### Consultar talleres disponibles

    | Operación                     | Método | Endpoint         | Código | Respuesta Ejemplo                                      | Errores |
    |------------------------------|--------|-------------------|--------|----------------------------------------------------------|---------|
    | Listar talleres disponibles  | GET    | /api/v1/talleres | 200    | { "data": [ { "idTaller": 10, "cupos": 4 } ] }          | 400,401 |

    ###### Inscribirse en un taller

    | Operación                | Método | Endpoint                           | Body Ejemplo     | Código | Respuesta Ejemplo                               | Errores          |
    |--------------------------|--------|------------------------------------|------------------|--------|--------------------------------------------------|-------------------|
    | Inscribirse en taller    | POST   | /api/v1/alumnos/{id}/inscripciones | { "idTaller":10 } | 201    | { "idInscripcion": 101, "estado": "ACTIVA" }    | 400,401,404,409  |

---

#### 2. Profesores

- ##### 2.1 CRUD de profesores

    | Operación         | Método | Endpoint                   | Body Ejemplo                                                                                                 | Código | Respuesta Ejemplo                      | Errores        |
    |-------------------|--------|----------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|-----------------------------------------|----------------|
    | Crear profesor    | POST   | /api/v1/profesores         | { "nombre": "Laura", "apellidos": "García", "especialidad": "Dibujo", "email": "laura@example.com" }                                                            | 201    | { "idProfesor": 2, "nombre": "Laura" } | 400,401,409    |
    | Listar profesores | GET    | /api/v1/profesores         | -                                                                                                                                                              | 200    | { "meta": {...}, "data": [] }          | 400,401        |
    | Ver profesor      | GET    | /api/v1/profesores/{id}    | -                                                                                                                                                              | 200    | { "idProfesor": 2, "nombre": "Laura" } | 404,401        |
    | Modificar prof.   | PUT    | /api/v1/profesores/{id}    | { "email": "nuevo@example.com" }                                                                                                                               | 200    | { "idProfesor": 2, "email": "nuevo" }  | 400,404,401    |
    | Eliminar profesor | DELETE | /api/v1/profesores/{id}    | -                                                                                                                                                              | 204    | -                                       | 404,401,403    |

- ##### 2.2 Funcionalidades del profesor

    ###### Registrar asistencias

    | Operación              | Método | Endpoint                                                        | Body Ejemplo                                                               | Código | Respuesta Ejemplo                                      | Errores |
    |------------------------|--------|------------------------------------------------------------------|----------------------------------------------------------------------------|--------|----------------------------------------------------------|---------|
    | Registrar asistencias  | POST   | /api/v1/profesores/{id}/talleres/{idTaller}/asistencias         | { "fechaSesion":"2025-11-10","asistencias":[{"idAlumno":1,"asistio":true}] } | 201    | { "mensaje": "Asistencias registradas" }                | 400,401,404 |

    ###### Ver alumnos inscritos

    | Operación               | Método | Endpoint                                                       | Código | Respuesta Ejemplo                                         | Errores |
    |-------------------------|--------|----------------------------------------------------------------|--------|-------------------------------------------------------------|---------|
    | Ver alumnos inscritos   | GET    | /api/v1/profesores/{id}/talleres/{idTaller}/alumnos           | 200    | { "tallerId": 10, "alumnos": [{ "idAlumno":1 }] }          | 400,401,404 |

    ###### Consultar talleres impartidos

    | Operación                     | Método | Endpoint                        | Código | Respuesta Ejemplo                                   | Errores |
    |-------------------------------|--------|----------------------------------|--------|-------------------------------------------------------|---------|
    | Consultar talleres impartidos | GET    | /api/v1/profesores/{id}/talleres | 200    | { "profesorId": 2, "talleres": [{ "idTaller":10 }] } | 400,401,404 |

---

#### 3. Talleres

| Operación        | Método | Endpoint              | Body Ejemplo                                                                             | Código | Respuesta Ejemplo                    | Errores     |
|------------------|--------|------------------------|------------------------------------------------------------------------------------------|--------|---------------------------------------|-------------|
| Crear taller     | POST   | /api/v1/talleres       | { "nombre":"Acuarela","descripcion":"Técnicas","idProfesor":2 }                          | 201    | { "idTaller":10,"nombre":"Acuarela"} | 400,401,409 |
| Listar talleres  | GET    | /api/v1/talleres       | -                                                                                        | 200    | { "meta": {...}, "data": [] }        | 400,401     |
| Ver taller       | GET    | /api/v1/talleres/{id}  | -                                                                                        | 200    | { "idTaller":10,"nombre":"Acuarela"} | 404,401     |
| Modificar taller | PUT    | /api/v1/talleres/{id}  | { "nombre":"Acuarela Av.","descripcion":"Nivel medio" }                                 | 200    | { "idTaller":10,"nombre":"Acuarela"} | 400,404,401 |
| Eliminar taller  | DELETE | /api/v1/talleres/{id}  | -                                                                                        | 204    | -                                     | 404,401,403 |

---

#### 4. Inscripciones

| Operación             | Método | Endpoint                     | Body Ejemplo                                           | Código | Respuesta Ejemplo                              | Errores        |
|-----------------------|--------|------------------------------|--------------------------------------------------------|--------|------------------------------------------------|----------------|
| Crear inscripción     | POST   | /api/v1/inscripciones        | { "idAlumno":1, "idTaller":10 }                        | 201    | { "idInscripcion":100,"estado":"ACTIVA" }      | 400,401,409    |
| Listar inscripciones  | GET    | /api/v1/inscripciones        | -                                                      | 200    | { "meta": {...}, "data": [] }                  | 400,401        |
| Ver inscripción       | GET    | /api/v1/inscripciones/{id}   | -                                                      | 200    | { "idInscripcion":100,"estado":"ACTIVA" }      | 404,401        |
| Modificar inscripción | PUT    | /api/v1/inscripciones/{id}   | { "estado":"BAJA" }                                    | 200    | { "idInscripcion":100,"estado":"BAJA" }        | 400,404,401    |
| Eliminar inscripción  | DELETE | /api/v1/inscripciones/{id}   | -                                                      | 204    | -                                              | 404,401,403    |

---

#### 5. Asistencias

| Operación             | Método | Endpoint                 | Body Ejemplo                                            | Código | Respuesta Ejemplo                       | Errores          |
|-----------------------|--------|---------------------------|----------------------------------------------------------|--------|------------------------------------------|-------------------|
| Crear asistencia      | POST   | /api/v1/asistencias      | { "idInscripcion":100, "fechaSesion":"2025-11-10", "asistio":true } | 201    | { "idAsistencia":500,"asistio":true }   | 400,401,409       |
| Listar asistencias    | GET    | /api/v1/asistencias      | -                                                        | 200    | { "meta": {...}, "data": [] }           | 400,401           |
| Ver asistencia        | GET    | /api/v1/asistencias/{id} | -                                                        | 200    | { "idAsistencia":500,"asistio":true }   | 404,401           |
| Modificar asistencia  | PUT    | /api/v1/asistencias/{id} | { "asistio":false, "observaciones":"Falta justificada"} | 200    | { "idAsistencia":500,"asistio":false }  | 400,404,401       |
| Eliminar asistencia   | DELETE | /api/v1/asistencias/{id} | -                                                        | 204    | -                                        | 404,401,403       |


## Documentación de la API con OpenAPI / Swagger

La API REST de **Aula Creativa** se documenta siguiendo el estándar **OpenAPI**, que permite describir de forma estructurada todos los servicios expuestos por el backend.

Para facilitar la visualización y prueba de los endpoints, se utiliza **Swagger**, que genera una interfaz web interactiva a partir de la definición OpenAPI.

Esta documentación complementa el diseño funcional descrito anteriormente y actúa como contrato entre el backend y los clientes de la aplicación.

---

### Función de OpenAPI

- Define los endpoints y métodos HTTP.
- Describe parámetros, cuerpos de petición y respuestas.
- Documenta los modelos de datos.
- Facilita el mantenimiento y evolución del sistema.

---

### Uso de Swagger

Swagger permite:
- Consultar la documentación completa de la API.
- Probar los endpoints directamente desde el navegador.
- Visualizar ejemplos de peticiones y respuestas.
- Facilitar el desarrollo y depuración.

---

### Ubicación y estado de implementación

La documentación Swagger se expone desde el **servidor**, ya que forma parte de la API REST.  
En el estado actual del proyecto, la API está preparada para ser documentada mediante OpenAPI y Swagger, contemplándose su integración completa como una mejora futura.

---

[Volver](/README.md)
