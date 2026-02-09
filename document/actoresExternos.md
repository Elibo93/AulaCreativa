### Casos de uso – F (Actores externos a la aplicación)
---
<p align="center">
  <img src="/img/actores_externos.png" width="450">
</p>

En este apartado se describe los **casos de uso** relacionados con los **actores externos** que interactúan con la aplicación, es decir, aquellos usuarios que no forman parte del sistema internamente, pero que sí lo utilizan para realizar acciones concretas. En Aula Creativa, estos actores serían principalmente **Alumnos**, **Profesores** y **Administración**.

A continuación, se resumen las acciones más importantes que realiza cada uno:

#### Alumno
El alumno es un usuario autenticado que interactúa con la plataforma para consultar información relacionada con su formación.

Funciones principales:
* Consultar sus **talleres inscritos**.
* Ver su **asistencia** mensual.
* Revisar el **estado de sus pagos**.
* Recibir **notificaciones** importantes 

El acceso del alumno está restringido a los recursos asociados a su rol, garantizando que solo pueda acceder a su propia información.

(recordatorios, avisos, etc.).
![Diagrama caso de uso Alumno](/img/alumno.png)

#### Profesor

El profesor es un usuario autenticado encargado de la gestión académica de los talleres.

* Ver la **lista de alumnos** de cada taller que imparte.
* Registrar la **asistencia** de cada sesión.
* Acceder a un pequeño resumen de **estadísticas** de participación.
* Enviar **mensajes** o avisos a los alumnos de su taller.

El profesor comparte el rol de usuario, pero con permisos específicos asociados a las funcionalidades docentes.

![Diagrama caso de uso Profesor](/img/profesor.png)

#### Administración

El administrador es un usuario autenticado con permisos avanzados dentro del sistema.

* Consultar la **información general** de alumnos y profesores.
* Ver el estado de **pagos mensuales**.
* Acceder al **panel de estadísticas** para tener una visión global del centro.
* Validar o revisar **inscripciones** y cambios en los talleres.

Este rol dispone de permisos adicionales que le permiten acceder a recursos restringidos y realizar operaciones administrativas.


---

Todos los actores deben autenticarse para acceder al sistema, y la autorización se gestiona en función del rol y los permisos asociados a cada usuario.
[Volver](/README.md)
