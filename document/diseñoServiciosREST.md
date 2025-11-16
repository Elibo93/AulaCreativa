### Diseño de los servicios REST

--- 


#### Introducción al diseño de los servicios REST

El diseño de los servicios REST de la aplicación **Aula Creativa** se basa en una estructura clara, consistente y fácil de mantener. El objetivo es proporcionar una API organizada, sencilla de consumir desde el frontend y lo suficientemente flexible como para permitir futuras ampliaciones del sistema. Para ello, se han definido una serie de convenciones y buenas prácticas que garantizan la coherencia entre todos los recursos del proyecto.

Cada endpoint sigue un formato estándar, utilizando rutas en plural, métodos HTTP apropiados para cada operación y respuestas estructuradas en JSON. Además, se ha establecido una convención común para los mensajes de error, un formato unificado para fechas y horas, y un esquema de versionado en la ruta base (`/api/v1`) que facilita la evolución del sistema sin afectar a implementaciones previas.

Con estas pautas, la API ofrece un comportamiento predecible, homogéneo y profesional, permitiendo que los dos desarrolladores del proyecto trabajen de forma coordinada y mantengan un diseño limpio y escalable.


#### Endpoints

- **Alumnos**

    | Operación             | Verbo  | Endpoint                          | Ejemplo Body                                                                                                       | Response Code        | Ejemplo Response                                      | Errores posibles                                                                               |
    | --------------------- | ------ | --------------------------------- | ------------------------------------------------------------------------------------------------------------------ | -------------------- | ----------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
    | **Crear alumno**      | POST   | `/api/v1/alumnos`                 | `{ "nombre": "Ana Pérez", "email": "ana@example.com", "telefono": "600123456", "fecha_nacimiento": "2010-05-12" }` | **201 (Created)**    | `{ "id": 42, "nombre": "Ana Pérez", "activo": true }` | **400 (Solicitud incorrecta)**, **401 (No autorizado)**, **409 (Conflicto — email duplicado)** |
    | **Listar alumnos**    | GET    | `/api/v1/alumnos?page=1&limit=20` | —                                                                                                                  | **200 (OK)**         | `{ "meta": {...}, "data": [...] }`                    | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                        |
    | **Ver alumno**        | GET    | `/api/v1/alumnos/42`              | —                                                                                                                  | **200 (OK)**         | `{ "id": 42, "nombre": "Ana Pérez" }`                 | **404 (No encontrado)**, **401 (No autorizado)**                                               |
    | **Modificar alumno**  | PATCH  | `/api/v1/alumnos/42`              | `{ "telefono": "600000000" }`                                                                                      | **200 (OK)**         | `{ "id": 42, "telefono": "600000000" }`               | **400 (Solicitud incorrecta)**, **404 (No encontrado)**, **401 (No autorizado)**               |
    | **Desactivar alumno** | DELETE | `/api/v1/alumnos/42`              | —                                                                                                                  | **204 (No Content)** | —                                                     | **404 (No encontrado)**, **401 (No autorizado)**, **403 (Prohibido)**                          |

---

- **Talleres**

    | Operación             | Verbo  | Endpoint                         | Ejemplo Body                                                                      | Response Code        | Ejemplo Response                     | Errores posibles                                                                                      |
    | --------------------- | ------ | -------------------------------- | --------------------------------------------------------------------------------- | -------------------- | ------------------------------------ | ----------------------------------------------------------------------------------------------------- |
    | **Crear taller**      | POST   | `/api/v1/talleres`               | `{ "titulo": "Dibujo", "profesor_id": 7, "capacidad": 12, "precio_mensual": 35 }` | **201 (Created)**    | `{ "id": 10, "titulo": "Dibujo" }`   | **400 (Solicitud incorrecta)**, **404 (Profesor no encontrado)**, **401 (No autorizado)**             |
    | **Listar talleres**   | GET    | `/api/v1/talleres?profesor_id=7` | —                                                                                 | **200 (OK)**         | `[{ "id": 10, "titulo": "Dibujo" }]` | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                               |
    | **Ver taller**        | GET    | `/api/v1/talleres/10`            | —                                                                                 | **200 (OK)**         | `{ "id": 10, "titulo": "Dibujo" }`   | **404 (No encontrado)**, **401 (No autorizado)**                                                      |
    | **Modificar taller**  | PATCH  | `/api/v1/talleres/10`            | `{ "capacidad": 14 }`                                                             | **200 (OK)**         | `{ "id": 10, "capacidad": 14 }`      | **400 (Solicitud incorrecta — capacidad inválida)**, **404 (No encontrado)**, **401 (No autorizado)** |
    | **Desactivar taller** | DELETE | `/api/v1/talleres/10`            | —                                                                                 | **204 (No Content)** | —                                    | **404 (No encontrado)**, **409 (Conflicto — inscripciones activas)**, **401 (No autorizado)**         |

---

- **Inscripciones**

    | Operación                | Verbo  | Endpoint                             | Ejemplo Body                           | Response Code        | Ejemplo Response                    | Errores posibles                                                                                                                                 |
    | ------------------------ | ------ | ------------------------------------ | -------------------------------------- | -------------------- | ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ |
    | **Crear inscripción**    | POST   | `/api/v1/inscripciones`              | `{ "alumno_id": 42, "taller_id": 10 }` | **201 (Created)**    | `{ "id": 77, "estado": "activa" }`  | **400 (Solicitud incorrecta)**, **404 (Alumno/Taller no encontrado)**, **409 (Conflicto — ya inscrito o taller lleno)**, **401 (No autorizado)** |
    | **Listar inscripciones** | GET    | `/api/v1/inscripciones?alumno_id=42` | —                                      | **200 (OK)**         | `[{ "id": 77 }]`                    | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                                                                          |
    | **Ver inscripción**      | GET    | `/api/v1/inscripciones/77`           | —                                      | **200 (OK)**         | `{ "id": 77, "estado": "activa" }`  | **404 (No encontrado)**, **401 (No autorizado)**                                                                                                 |
    | **Modificar estado**     | PATCH  | `/api/v1/inscripciones/77`           | `{ "estado": "anulada" }`              | **200 (OK)**         | `{ "id": 77, "estado": "anulada" }` | **400 (Estado no válido)**, **404 (No encontrado)**, **401 (No autorizado)**                                                                     |
    | **Eliminar inscripción** | DELETE | `/api/v1/inscripciones/77`           | —                                      | **204 (No Content)** | —                                   | **404 (No encontrado)**, **401 (No autorizado)**                                                                                                 |

---

- **Asistencias**

    | Operación                | Verbo | Endpoint                           | Ejemplo Body                                                            | Response Code     | Ejemplo Response                         | Errores posibles                                                                                                                         |
    | ------------------------ | ----- | ---------------------------------- | ----------------------------------------------------------------------- | ----------------- | ---------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------- |
    | **Registrar asistencia** | POST  | `/api/v1/asistencias`              | `{ "inscripcion_id": 77, "fecha": "2025-11-16", "estado": "presente" }` | **201 (Created)** | `{ "id": 201, "estado": "presente" }`    | **400 (Solicitud incorrecta)**, **404 (Inscripción no encontrada)**, **409 (Conflicto — asistencia duplicada)**, **401 (No autorizado)** |
    | **Listar asistencias**   | GET   | `/api/v1/asistencias?taller_id=10` | —                                                                       | **200 (OK)**      | `[{ "id": 201 }]`                        | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                                                                  |
    | **Modificar asistencia** | PATCH | `/api/v1/asistencias/201`          | `{ "estado": "justificada" }`                                           | **200 (OK)**      | `{ "id": 201, "estado": "justificada" }` | **400 (Solicitud incorrecta)**, **404 (No encontrado)**, **401 (No autorizado)**                                                         |

---

- **Pagos**

    | Operación             | Verbo | Endpoint                     | Ejemplo Body                                                 | Response Code     | Ejemplo Response                        | Errores posibles                                                                                                                   |
    | --------------------- | ----- | ---------------------------- | ------------------------------------------------------------ | ----------------- | --------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
    | **Crear pago**        | POST  | `/api/v1/pagos`              | `{ "inscripcion_id": 77, "monto": 35, "metodo": "tarjeta" }` | **201 (Created)** | `{ "id": 301, "estado": "pendiente" }`  | **400 (Solicitud incorrecta)**, **404 (Inscripción no encontrada)**, **409 (Conflicto — pago duplicado)**, **401 (No autorizado)** |
    | **Actualizar estado** | PATCH | `/api/v1/pagos/301`          | `{ "estado": "confirmado" }`                                 | **200 (OK)**      | `{ "id": 301, "estado": "confirmado" }` | **400 (Estado no válido)**, **404 (No encontrado)**, **401 (No autorizado)**                                                       |
    | **Consultar pagos**   | GET   | `/api/v1/pagos?alumno_id=42` | —                                                            | **200 (OK)**      | `[{ "id": 301 }]`                       | **400 (Parámetros inválidos)**, **401 (No autorizado)**                                                                            |

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
