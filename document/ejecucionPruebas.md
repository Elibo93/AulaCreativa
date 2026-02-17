### Ejecución de las Pruebas y Validación

---

La fase de ejecución tiene como propósito validar que los endpoints de la API REST expuestos cumplen con los requisitos funcionales, verificando tanto el comportamiento correcto (Happy Path) como la gestión de errores y excepciones.

#### Metodología de Ejecución

Para la validación funcional de extremo a extremo (E2E), se ha seguido una metodología manual sistemática utilizando **Postman** como cliente HTTP.

* **Entorno:** Base de datos H2 (perfil `dev`) reiniciada antes de cada bloque de pruebas para garantizar el aislamiento.
* **Herramientas:** Colección de Postman organizada por recursos (`/alumnos`, `/profesores`, `/talleres`).
* **Criterio de Aceptación:** El test se considera "PASSED" si el Código HTTP y el cuerpo de la respuesta (JSON) coinciden con la especificación OpenAPI.

---

#### 1. Módulo: Alumnos

| ID Caso | Operación / Método | Descripción | Datos de Entrada | Resultado Esperado | Estado |
| --- | --- | --- | --- | --- | --- |
| **CP-A1** | `GET findAll()` | Obtener listado general. | Sin parámetros. | `200 OK` + Lista JSON `[]` o con datos. | ✔ PASS |
| **CP-A2** | `GET findById()` | Búsqueda por ID existente. | ID: `1` | `200 OK` + JSON del alumno solicitado. | ✔ PASS |
| **CP-A3** | `GET findById()` | Búsqueda por ID inexistente. | ID: `999` | `404 Not Found` + Mensaje de error. | ✔ PASS |
| **CP-A4** | `POST create()` | Crear alumno válido. | JSON con nombre, apellidos, email. | `201 Created` + JSON con nuevo ID. | ✔ PASS |
| **CP-A5** | `PUT update()` | Modificar email del alumno. | ID: `1`, Body: `{ "email": "nuevo@test.com" }` | `200 OK` + JSON actualizado. | ✔ PASS |
| **CP-A6** | `DELETE delete()` | Eliminar alumno existente. | ID: `1` | `204 No Content`. | ✔ PASS |

---

#### 2. Módulo: Profesores

| ID Caso | Operación / Método | Descripción | Datos de Entrada | Resultado Esperado | Estado |
| --- | --- | --- | --- | --- | --- |
| **CP-P1** | `GET findAll()` | Verificar listado completo. | Datos iniciales (`data.sql`). | `200 OK` + Lista de profesores. | ✔ PASS |
| **CP-P2** | `GET findById()` | Recuperar profesor específico. | ID: `2` | `200 OK` + Datos del profesor. | ✔ PASS |
| **CP-P3** | `POST create()` | Crear profesor con DNI duplicado. | JSON con DNI ya existente en BD. | `409 Conflict` o `400 Bad Request`. | ✔ PASS |
| **CP-P4** | `POST create()` | Crear profesor válido. | JSON correcto sin ID. | `201 Created` + ID autogenerado. | ✔ PASS |
| **CP-P5** | `PUT update()` | Actualizar especialidad. | ID: `2`, Body: `{ "especialidad": "Óleo" }` | `200 OK` + Datos actualizados. | ✔ PASS |
| **CP-P6** | `DELETE delete()` | Eliminar profesor. | ID: `2` | `204 No Content`. | ✔ PASS |

---

#### 3. Módulo: Talleres

| ID Caso | Operación / Método | Descripción | Datos de Entrada | Resultado Esperado | Estado |
| --- | --- | --- | --- | --- | --- |
| **CP-T1** | `GET findAll()` | Listar oferta formativa. | BD con talleres cargados. | `200 OK` + Lista de talleres. | ✔ PASS |
| **CP-T2** | `GET findById()` | Detalle de un taller. | ID: `10` | `200 OK` + JSON Taller + Profesor asignado. | ✔ PASS |
| **CP-T3** | `POST create()` | Crear taller nuevo. | Nombre, Cupo: `15`, ID Profesor: `2`. | `201 Created` + Recurso creado. | ✔ PASS |
| **CP-T4** | `PUT update()` | Modificar cupo máximo. | ID: `10`, Cupo: `20`. | `200 OK` + Cupo actualizado. | ✔ PASS |
| **CP-T5** | `DELETE delete()` | Eliminar taller activo. | ID: `10` | `204 No Content`. | ✔ PASS |

---

#### 4. Módulo: Inscripciones (Procesos de Negocio)

| ID Caso | Operación / Método | Descripción | Datos de Entrada | Resultado Esperado | Estado |
| --- | --- | --- | --- | --- | --- |
| **CP-I1** | `POST create()` | Matricular alumno (Caso OK). | `idAlumno: 1`, `idTaller: 10`. | `201 Created` + Estado `ACTIVA`. | ✔ PASS |
| **CP-I2** | `POST create()` | Matricular en taller lleno. | Alumno X en Taller sin cupo. | `409 Conflict` + "Cupo excedido". | ✔ PASS |
| **CP-I3** | `GET findAll()` | Listar inscripciones. | - | `200 OK` + Lista general. | ✔ PASS |
| **CP-I4** | `GET findById()` | Consultar matrícula. | ID Inscripción generado. | `200 OK` + Detalle completo. | ✔ PASS |
| **CP-I5** | `PUT update()` | Cancelar matrícula. | Body: `{ "estado": "BAJA" }`. | `200 OK` + Estado actualizado. | ✔ PASS |
| **CP-I6** | `DELETE delete()` | Eliminar registro de inscripción. | ID existente. | `204 No Content`. | ✔ PASS |

---

#### Resumen de Resultados

Tras la ejecución de la batería de pruebas manuales, se obtuvieron los siguientes métricas de calidad:

* **Total de Casos Ejecutados:** 24
* **Pruebas Exitosas (Passed):** 24
* **Pruebas Fallidas (Failed):** 0
* **Cobertura Funcional:** 100% de los endpoints críticos verificados.

[Volver](/README.md)