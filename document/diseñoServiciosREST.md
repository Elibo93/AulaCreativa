### Diseño de los servicios REST

---

#### Introducción al diseño de los servicios REST

La arquitectura de comunicación de **Aula Creativa** se fundamenta en un diseño **RESTful** estricto, priorizando la semántica, la escalabilidad y el desacoplamiento entre el cliente (Frontend) y el servidor (Backend).

Se ha establecido un contrato de interfaz uniforme que garantiza la predictibilidad de las operaciones. El sistema implementa un modelo de seguridad basado en roles (RBAC), exponiendo recursos específicos según el perfil del consumidor (Administrador, Alumno o Profesor).

**Principios de Diseño Adoptados:**

* **Identificación de Recursos:** Uso de sustantivos en plural para las rutas (URIs) que representan colecciones (ej. `/alumnos`, `/talleres`).
* **Semántica HTTP:** Uso estricto de los verbos HTTP para definir la naturaleza de la operación:
* **GET:** Recuperación de información (Idempotente).
* **POST:** Creación de nuevos recursos (No idempotente).
* **PUT:** Actualización total de un recurso.
* **DELETE:** Eliminado lógico o físico de un recurso.


* **Versionado:** Prefijo `/api/v1` en todas las rutas para facilitar la evolución futura sin romper la compatibilidad.
* **Formato de Intercambio:** `application/json` tanto para las peticiones como para las respuestas.
* **Manejo de Errores:** Respuestas estandarizadas con códigos de estado HTTP (4xx, 5xx) y mensajes descriptivos en el cuerpo.

---

#### Estructura de Recursos (Endpoints)

A continuación, se detalla la especificación técnica de los endpoints disponibles, agrupados por dominio funcional.

#### 1. Recurso: Alumnos

##### 1.1 CRUD de Alumnos (Gestión Administrativa)

| Operación | Método | Endpoint (URI) | Body (Payload) | Estado | Respuesta Ejemplo | Errores Posibles |
| --- | --- | --- | --- | --- | --- | --- |
| **Crear** | `POST` | `/api/v1/alumnos` | `{"nombre": "Diego", "dni": "12345678A", ...}` | `201` | `{"id": 1, "nombre": "Diego", ...}` | 400, 409 |
| **Listar** | `GET` | `/api/v1/alumnos` | - | `200` | `[{"id": 1, "nombre": "Diego"}, ...]` | 401, 403 |
| **Detalle** | `GET` | `/api/v1/alumnos/{id}` | - | `200` | `{"id": 1, "nombre": "Diego", ...}` | 404, 401 |
| **Editar** | `PUT` | `/api/v1/alumnos/{id}` | `{"nombre": "Diego", "email": "new@mail.com"}` | `200` | `{"id": 1, "email": "new@mail.com"}` | 400, 404 |
| **Eliminar** | `DELETE` | `/api/v1/alumnos/{id}` | - | `204` | - | 404, 403 |

##### 1.2 Funcionalidades Específicas del Alumno

| Operación | Método | Endpoint (URI) | Descripción | Código | Errores |
| --- | --- | --- | --- | --- | --- |
| **Mis Asistencias** | `GET` | `/api/v1/alumnos/{id}/asistencias` | Histórico de asistencia del alumno. | `200` | 404, 401 |
| **Talleres Disp.** | `GET` | `/api/v1/talleres?estado=abierto` | Lista talleres con cupo disponible. | `200` | 401 |
| **Inscribirse** | `POST` | `/api/v1/alumnos/{id}/inscripciones` | Solicita plaza en un taller (`{idTaller: 10}`). | `201` | 400, 409 |

---

#### 2. Recurso: Profesores

##### 2.1 CRUD de Profesores (Gestión Administrativa)

| Operación | Método | Endpoint (URI) | Body (Payload) | Estado | Respuesta Ejemplo | Errores Posibles |
| --- | --- | --- | --- | --- | --- | --- |
| **Crear** | `POST` | `/api/v1/profesores` | `{"nombre": "Laura", "especialidad": "Arte", ...}` | `201` | `{"id": 2, "nombre": "Laura"}` | 400, 409 |
| **Listar** | `GET` | `/api/v1/profesores` | - | `200` | `[{"id": 2, "nombre": "Laura"}, ...]` | 401, 403 |
| **Detalle** | `GET` | `/api/v1/profesores/{id}` | - | `200` | `{"id": 2, "especialidad": "Arte"}` | 404, 401 |
| **Editar** | `PUT` | `/api/v1/profesores/{id}` | `{"email": "new@example.com"}` | `200` | `{"id": 2, "email": "new@..."}` | 400, 404 |
| **Eliminar** | `DELETE` | `/api/v1/profesores/{id}` | - | `204` | - | 404, 403 |

##### 2.2 Funcionalidades Específicas del Profesor

| Operación | Método | Endpoint (URI) | Descripción | Código | Errores |
| --- | --- | --- | --- | --- | --- |
| **Pasar Lista** | `POST` | `/api/v1/profesores/{id}/talleres/{idTaller}/asistencias` | Registra un lote de asistencias para una fecha. | `201` | 400, 404 |
| **Ver Alumnos** | `GET` | `/api/v1/profesores/{id}/talleres/{idTaller}/alumnos` | Listado de matriculados en su taller. | `200` | 403, 404 |
| **Mis Talleres** | `GET` | `/api/v1/profesores/{id}/talleres` | Talleres impartidos por el profesor. | `200` | 401 |

---

#### 3. Recurso: Talleres

| Operación | Método | Endpoint (URI) | Body (Payload) | Estado | Respuesta Ejemplo | Errores Posibles |
| --- | --- | --- | --- | --- | --- | --- |
| **Crear** | `POST` | `/api/v1/talleres` | `{"nombre":"Acuarela", "cupo": 10, "idProfesor":2}` | `201` | `{"id":10, "nombre":"Acuarela"}` | 400, 409 |
| **Listar** | `GET` | `/api/v1/talleres` | - | `200` | `{"data": [...], "meta": {...}}` | 401 |
| **Detalle** | `GET` | `/api/v1/talleres/{id}` | - | `200` | `{"id":10, "descripcion":"..."}` | 404, 401 |
| **Editar** | `PUT` | `/api/v1/talleres/{id}` | `{"nombre":"Acuarela Avanzada"}` | `200` | `{"id":10, "nombre":"..."}` | 400, 404 |
| **Eliminar** | `DELETE` | `/api/v1/talleres/{id}` | - | `204` | - | 403, 404 |

---

#### 4. Recurso: Inscripciones (Matrículas)

| Operación | Método | Endpoint (URI) | Body (Payload) | Estado | Respuesta Ejemplo | Errores Posibles |
| --- | --- | --- | --- | --- | --- | --- |
| **Matricular** | `POST` | `/api/v1/inscripciones` | `{"idAlumno":1, "idTaller":10}` | `201` | `{"id":100, "estado":"ACTIVA"}` | 400, 409 |
| **Listar** | `GET` | `/api/v1/inscripciones` | - | `200` | `[{"id":100, "taller":"..."}]` | 401 |
| **Detalle** | `GET` | `/api/v1/inscripciones/{id}` | - | `200` | `{"id":100, "fecha": "2025..."}` | 404, 401 |
| **Baja/Modif** | `PUT` | `/api/v1/inscripciones/{id}` | `{"estado":"BAJA"}` | `200` | `{"id":100, "estado":"BAJA"}` | 400, 404 |
| **Borrar** | `DELETE` | `/api/v1/inscripciones/{id}` | - | `204` | - | 403, 404 |

---

#### 5. Recurso: Asistencias

| Operación | Método | Endpoint (URI) | Body (Payload) | Estado | Respuesta Ejemplo | Errores Posibles |
| --- | --- | --- | --- | --- | --- | --- |
| **Registrar** | `POST` | `/api/v1/asistencias` | `{"idInscripcion":100, "asistio":true}` | `201` | `{"id":500, "asistio":true}` | 400, 409 |
| **Listar** | `GET` | `/api/v1/asistencias` | - | `200` | `[{"id":500, "fecha": "..."}]` | 401 |
| **Detalle** | `GET` | `/api/v1/asistencias/{id}` | - | `200` | `{"id":500, "asistio":true}` | 404 |
| **Corregir** | `PUT` | `/api/v1/asistencias/{id}` | `{"asistio":false}` | `200` | `{"id":500, "asistio":false}` | 400, 404 |
| **Borrar** | `DELETE` | `/api/v1/asistencias/{id}` | - | `204` | - | 403, 404 |

---

### Documentación de la API (OpenAPI / Swagger)

Para garantizar la interoperabilidad y facilitar el consumo de los servicios, **Aula Creativa** integra una especificación formal de su API.

#### Estándar OpenAPI

La API se adhiere a la especificación **OpenAPI 3.0**, que actúa como un contrato técnico entre el Backend y cualquier cliente (Frontend Web, App Móvil o servicios de terceros). Este estándar define de forma agnóstica al lenguaje:

* Los endpoints disponibles y sus métodos HTTP.
* Los esquemas de datos (Modelos) de entrada y salida.
* Los mecanismos de autenticación requeridos (Bearer Token / JWT).

#### Interfaz Interactiva (Swagger UI)

Como implementación de referencia, el proyecto incluye **Swagger UI**, una herramienta que genera dinámicamente una página web interactiva basada en el código fuente.

**Beneficios para el proyecto:**

1. **Documentación Viva:** La documentación se actualiza automáticamente junto con el código, evitando desincronizaciones.
2. **Testing en Tiempo Real:** Permite a los desarrolladores y al tribunal probar los endpoints directamente desde el navegador, enviando peticiones reales y visualizando las respuestas JSON.
3. **Onboarding:** Facilita la comprensión de la lógica de negocio expuesta sin necesidad de leer el código fuente.

*Nota de implementación: La interfaz de Swagger UI está configurada para ser accesible únicamente en los entornos de Desarrollo y Testing, deshabilitándose en Producción por motivos de seguridad.*

---

[Volver](/README.md)