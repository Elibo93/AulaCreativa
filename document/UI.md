### UI (Vistas)
---
[Volver](/README.md)4.2 UI – Vistas (Thymeleaf)

La capa de presentación se implementa utilizando Thymeleaf como motor de plantillas del lado servidor, integrado con Spring Boot. La aplicación está diseñada para disponer de un conjunto completo de vistas que permitan la gestión de los distintos elementos del sistema.

Las vistas contempladas son:

Vista de listado de alumnos: muestra todos los alumnos registrados en el sistema en formato tabla. (Implementada)

Vista de edición de alumno: permite modificar los datos de un alumno existente mediante un formulario. (Implementada)

Vista de eliminación de alumno: acción accesible desde el listado, con confirmación previa. (Implementada)

Vista de alta de alumno: formulario para registrar nuevos alumnos. (Planificada)

Vista de profesores: gestión y consulta de profesores. (Planificada)

Vista de actividades: gestión de actividades formativas. (Planificada)

Vista de inscripciones: relación entre alumnos y actividades. (Planificada)

Las vistas se comunican con el backend REST para obtener y modificar los datos, mostrando la información de forma dinámica mediante el modelo proporcionado por los controladores Spring MVC.