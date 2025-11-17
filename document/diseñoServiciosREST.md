### Diseño de los servicios REST

--- 

#### Introducción al diseño de los servicios REST

El diseño de los servicios REST de la aplicación **Aula Creativa** se basa en una estructura clara, consistente y fácil de mantener. El objetivo es proporcionar una API organizada, sencilla de consumir desde el frontend y lo suficientemente flexible como para permitir futuras ampliaciones del sistema. Para ello, se han definido una serie de convenciones y buenas prácticas que garantizan la coherencia entre todos los recursos del proyecto.

Cada endpoint sigue un formato estándar, utilizando rutas en plural, métodos HTTP apropiados para cada operación y respuestas estructuradas en JSON. Además, se ha establecido una convención común para los mensajes de error, un formato unificado para fechas y horas, y un esquema de versionado en la ruta base (`/api/v1`) que facilita la evolución del sistema sin afectar a implementaciones previas.

Con estas pautas, la API ofrece un comportamiento predecible, homogéneo y profesional, permitiendo que los dos desarrolladores del proyecto trabajen de forma coordinada y mantengan un diseño limpio y escalable.


#### Endpoints

- **Alumnos**

    | Operación             | Verbo  | Endpoint                          | Ejemplo Body                                                                                                       | Response Code        | Ejemplo Response                                      | Errores posibles                                                                               |
    |----------------------|--------|-----------------------------------|--------------------------------------------------------------------------------------------------------------------|----------------------|--------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | **Crear alumno**     | POST   | `/api/v1/alumnos`                 | `{ "nombre": "Diego", "apellidos": "Romero", "dni": "12345678A", "email": "diego@example.com", "telefono": "600111222", "fecha_alta": "2025-04-01", "activo": true }` | **201 (Created)**    | `{ "id_alumno": 1, "nombre": "Diego", "activo": true }` | **400 (Solicitud incorrecta)**, **401 (No autorizado)**, **409 (Conflicto — email o DNI duplicado)** |
    | **Listar alumnos**   | GET    | `/api/v1/alumnos?page=1&limit=20` | —                                                                                                                  | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                    | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                        |
    | **Ver alumno**       | GET    | `/api/v1/alumnos/1`               | —                                                                                                                  | **200 (OK)**         | `{ "id_alumno": 1, "nombre": "Diego" }`               | **404 (No encontrado)**, **401 (No autorizado)**                                               |
    | **Modificar alumno** | PUT    | `/api/v1/alumnos/1`               | `{ "nombre": "Diego", "apellidos": "Romero", "dni": "12345678A", "email": "nuevo@example.com", "telefono": "600000000", "fecha_alta": "2025-04-01", "activo": true }` | **200 (OK)**         | `{ "id_alumno": 1, "email": "nuevo@example.com" }`    | **400 (Solicitud incorrecta)**, **404 (No encontrado)**, **401 (No autorizado)**               |
    | **Eliminar alumno**  | DELETE | `/api/v1/alumnos/1`               | —                                                                                                                  | **204 (No Content)** | —                                                      | **404 (No encontrado)**, **401 (No autorizado)**, **403 (Prohibido)**                          |

---

- **Profesores**
  
    | Operación               | Verbo  | Endpoint                            | Ejemplo Body                                                                                                                   | Response Code        | Ejemplo Response                                        | Errores posibles                                                                               |
    |-------------------------|--------|---------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|----------------------|----------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | **Crear profesor**      | POST   | `/api/v1/profesores`                 | `{ "nombre": "Laura", "apellidos": "García", "email": "laura@example.com", "telefono": "600999888", "especialidad": "Dibujo", "fecha_alta": "2025-09-15", "activo": true }` | **201 (Created)**    | `{ "id_profesor": 2, "nombre": "Laura" }`               | **400**, **401**, **409 (email duplicado)**                                                   |
    | **Listar profesores**   | GET    | `/api/v1/profesores?page=1&limit=20` | —                                                                                                                              | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                      | **400**, **401**                                                                               |
    | **Ver profesor**        | GET    | `/api/v1/profesores/2`               | —                                                                                                                              | **200 (OK)**         | `{ "id_profesor": 2, "nombre": "Laura" }`               | **404**, **401**                                                                               |
    | **Modificar profesor**  | PUT    | `/api/v1/profesores/2`               | `{ "nombre": "Laura", "apellidos": "García", "email": "laura@nueva.com", "telefono": "600123000", "especialidad": "Dibujo", "fecha_alta": "2025-09-15", "activo": true }` | **200 (OK)**         | `{ "id_profesor": 2, "email": "laura@nueva.com" }`      | **400**, **404**, **401**                                                                     |
    | **Eliminar profesor**   | DELETE | `/api/v1/profesores/2`               | —                                                                                                                              | **204 (No Content)** | —                                                        | **404**, **401**, **403**                                                                      |

---

- **Talleres**

    | Operación              | Verbo  | Endpoint                          | Ejemplo Body                                                                                                                       | Response Code        | Ejemplo Response                                        | Errores posibles                                                                               |
    |------------------------|--------|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|----------------------|----------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | **Crear taller**       | POST   | `/api/v1/talleres`                | `{ "nombre": "Dibujo Avanzado", "descripcion": "Sombras y composición", "id_profesor": 2, "dia_semana": "Lunes", "hora_inicio": "17:00", "hora_fin": "19:00", "precio_mensual": 45.5, "aforo_maximo": 12 }` | **201 (Created)**    | `{ "id_taller": 10, "nombre": "Dibujo Avanzado" }`      | **400**, **401**, **409 (profesor no disponible)**                                             |
    | **Listar talleres**    | GET    | `/api/v1/talleres`               | —                                                                                                                                    | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                      | **400**, **401**                                                                               |
    | **Ver taller**         | GET    | `/api/v1/talleres/10`            | —                                                                                                                                    | **200 (OK)**         | `{ "id_taller": 10, "nombre": "Dibujo Avanzado" }`      | **404**, **401**                                                                               |
    | **Modificar taller**   | PUT    | `/api/v1/talleres/10`            | `{ "nombre": "Dibujo Avanzado 2", "descripcion": "Nivel experto", "id_profesor": 2, "dia_semana": "Lunes", "hora_inicio": "17:00", "hora_fin": "19:00", "precio_mensual": 50, "aforo_maximo": 12 }` | **200 (OK)**         | `{ "id_taller": 10, "nombre": "Dibujo Avanzado 2" }`    | **400**, **404**, **401**                                                                     |
    | **Eliminar taller**    | DELETE | `/api/v1/talleres/10`            | —                                                                                                                                    | **204 (No Content)** | —                                                        | **404**, **401**, **403**                                                                      |

---

- **Inscripciones**

    | Operación                 | Verbo  | Endpoint                           | Ejemplo Body                                                                                                                   | Response Code        | Ejemplo Response                                      | Errores posibles                                                                               |
    |---------------------------|--------|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|----------------------|--------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | **Crear inscripción**     | POST   | `/api/v1/inscripciones`           | `{ "id_alumno": 1, "id_taller": 10, "fecha_inscripcion": "2025-11-01", "estado": "ACTIVA", "nota": "Pendiente de pago" }`        | **201 (Created)**    | `{ "id_inscripcion": 100, "estado": "ACTIVA" }`        | **400**, **401**, **409 (duplicado: alumno ya inscrito)** |
    | **Listar inscripciones**  | GET    | `/api/v1/inscripciones`           | —                                                                                                                                | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                    | **400**, **401**                                                                               |
    | **Ver inscripción**       | GET    | `/api/v1/inscripciones/100`       | —                                                                                                                                | **200 (OK)**         | `{ "id_inscripcion": 100, "estado": "ACTIVA" }`        | **404**, **401**                                                                               |
    | **Modificar inscripción** | PUT    | `/api/v1/inscripciones/100`       | `{ "id_alumno": 1, "id_taller": 10, "fecha_inscripcion": "2025-11-01", "estado": "BAJA", "nota": "Solicitud por email" }`        | **200 (OK)**         | `{ "id_inscripcion": 100, "estado": "BAJA" }`          | **400**, **404**, **401**                                                                     |
    | **Eliminar inscripción**  | DELETE | `/api/v1/inscripciones/100`       | —                                                                                                                                | **204 (No Content)** | —                                                      | **404**, **401**, **403**                                                                      |

---

- **Asistencias**

    | Operación               | Verbo  | Endpoint                           | Ejemplo Body                                                                                              | Response Code        | Ejemplo Response                                          | Errores posibles                                                                               |
    |-------------------------|--------|------------------------------------|-----------------------------------------------------------------------------------------------------------|----------------------|------------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | **Crear asistencia**    | POST   | `/api/v1/asistencias`             | `{ "id_inscripcion": 100, "fecha_sesion": "2025-11-10", "asistio": true, "observaciones": "Llegó tarde" }` | **201 (Created)**    | `{ "id_asistencia": 500, "asistio": true }`                | **400**, **401**, **409 (registro duplicado)**                                               |
    | **Listar asistencias**  | GET    | `/api/v1/asistencias`             | —                                                                                                         | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                        | **400**, **401**                                                                               |
    | **Ver asistencia**      | GET    | `/api/v1/asistencias/500`         | —                                                                                                         | **200 (OK)**         | `{ "id_asistencia": 500, "asistio": true }`                | **404**, **401**                                                                               |
    | **Modificar asistencia**| PUT    | `/api/v1/asistencias/500`         | `{ "id_inscripcion": 100, "fecha_sesion": "2025-11-10", "asistio": false, "observaciones": "Falta justificada" }` | **200 (OK)** | `{ "id_asistencia": 500, "asistio": false }`             | **400**, **404**, **401**                                                                     |
    | **Eliminar asistencia** | DELETE | `/api/v1/asistencias/500`         | —                                                                                                         | **204 (No Content)** | —                                                          | **404**, **401**, **403**                                                                      |

---

#### Convenciones adicionales en el diseño de los servicios REST

- **Convenciones de nombrado**

  * Los endpoints se definen siempre en **plural** para representar colecciones de recursos (`/alumnos`, `/talleres`, `/inscripciones`).
  * Las URLs mantienen una estructura **limpia y jerárquica**, evitando verbos dentro de la ruta.

    * Ejemplo correcto: `/talleres/10/inscripciones`
    * Ejemplo incorrecto: `/crearInscripcion`
  * En los cuerpos JSON se usa un formato consistente (`camelCase` o `snake_case`, según defina el proyecto).
  * Los identificadores siempre se pasan dentro de la ruta, nunca en el cuerpo.

- **Estructura estándar de errores**

    Todos los errores del sistema siguen una estructura común para facilitar su manejo desde el frontend:

    ```json
    {
    "error": {
        "code": "INVALID_DATA",
        "message": "El campo email es obligatorio",
        "details": {
        "email": "formato no válido"
        }
    }
    }
    ```

    * `code`: identificador del tipo de error.
    * `message`: descripción breve del problema.
    * `details`: información adicional opcional sobre los campos afectados.

- **Formato de fechas y horas**

    Para asegurar coherencia entre frontend y backend, todas las fechas y horas se manejan en formato **ISO 8601**:

    * Fecha: `YYYY-MM-DD`
    * Fecha y hora UTC: `YYYY-MM-DDTHH:MM:SSZ`

    Este formato evita ambigüedades y facilita la integración con bases de datos y librerías de frontend.

- **Versionado de la API**

    La API utiliza un sistema de versionado en la ruta base:

    ```
    /api/v1
    ```

    Este enfoque permite introducir nuevas versiones de la API sin afectar a los clientes que dependen de versiones anteriores, asegurando compatibilidad y evolución ordenada.

[Volver](/README.md)
