### Requisitos funcionales (F)
---

<p align="center">
  <img src="/img/rf.png" width="600">
</p>

En este apartado se describe las funciones principales que nuestra aplicación debe realizar para que cumpla con lo que necesita un centro como **Aula Creativa**. Son requisitos basados en cómo debería comportarse la app desde el punto de vista del usuario.

#### Requisitos Funcionales (F) - Organización por Roles

A continuación, se describen las funcionalidades del sistema segregadas por el perfil de usuario que interactúa con la aplicación, definiendo el alcance y los permisos de cada actor.

##### 1. Actor: Sistema / Común
Reglas que aplican a la lógica interna de la aplicación independientemente del usuario.
* **RF-SYS-01:** El sistema validará automáticamente los datos de entrada (campos obligatorios, emails válidos y duplicados).
* **RF-SYS-02:** El sistema dispondrá de un buscador transversal para localizar entidades (alumnos, profesores, talleres).

##### 2. Actor: Administrador
Usuario con privilegios elevados para la gestión integral del centro.
* **RF-ADM-01:** Acceso completo a funciones CRUD (Crear, Leer, Actualizar, Borrar) de Alumnos.
* **RF-ADM-02:** Acceso completo a funciones CRUD de Profesores.
* **RF-ADM-03:** Acceso completo a funciones CRUD de Talleres.
* **RF-ADM-04:** Capacidad para gestionar inscripciones (altas y bajas) de cualquier alumno.

##### 3. Actor: Profesor
Usuario encargado de la impartición de talleres y control de aula.
* **RF-PROF-01:** Consultar los talleres que tiene asignados para impartir.
* **RF-PROF-02:** Visualizar el listado de alumnos inscritos en sus talleres.
* **RF-PROF-03:** Registrar y modificar la asistencia de los alumnos en sus clases.

##### 4. Actor: Alumno
Usuario final que consume los servicios educativos.
* **RF-ALU-01:** Consultar el catálogo de talleres disponibles.
* **RF-ALU-02:** Inscribirse en un taller de su elección.
* **RF-ALU-03:** Consultar su propio historial de asistencias y faltas. 

--- 

[Volver](/README.md)