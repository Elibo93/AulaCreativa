### Vista (UI)

---

La interfaz de usuario se implementa siguiendo el patrón **MVC (Modelo-Vista-Controlador)**, utilizando **Thymeleaf** como motor de plantillas para el renderizado en el lado del servidor (Server-Side Rendering). Esta capa actúa como un **Adaptador de Entrada** (Web Adapter) dentro de la arquitectura hexagonal, comunicándose con los puertos de entrada de la aplicación.

---

#### 1. Tecnologías y Enfoque
* **Motor de Plantillas:** Thymeleaf + Spring Boot Starter Web.
* **Estilo y Maquetación:** CSS propio (`estilos.css`) con variables CSS nativas (`:root`). Sin frameworks externos. Tipografía **Plus Jakarta Sans** cargada desde Google Fonts. Iconos vectoriales mediante la librería **Lucide** (cargada vía CDN). Diseño responsive mediante CSS Grid y Flexbox.
* **Interacción:** Las vistas son dinámicas y responden a los modelos de datos (`Model`) inyectados por los Controladores de Spring MVC.

---

#### 2. Mapa de Navegación y Vistas
A continuación, se detalla el catálogo de interfaces de usuario planificadas, organizadas por el **Vertical Slice** (Módulo funcional) al que pertenecen.

- ##### Módulo: Gestión de Alumnos
    Este módulo centraliza las operaciones relacionadas con los estudiantes del centro.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-ALU-01** | **Listado General** | Tabla con todos los alumnos registrados. Incluye acciones rápidas de editar (modal emergente vía AJAX) y eliminar (con confirmación). | ✅ **Implementado** |
    | **V-ALU-02** | **Formulario de Alta** | Formulario para registrar un nuevo alumno con campos: DNI, nombre, apellidos, email, teléfono, fecha de nacimiento y dirección. Incluye validaciones de servidor. | ✅ **Implementado** |
    | **V-ALU-03** | **Edición en Modal** | Ventana emergente para modificar el email, teléfono y dirección de un alumno existente. Actualización asíncrona mediante Fetch API (PUT). | ✅ **Implementado** |
    | **V-ALU-04** | **Eliminación** | Borrado de alumno con diálogo de confirmación nativo del navegador. Procesado mediante formulario POST. | ✅ **Implementado** |
    | **V-ALU-05** | **Exportar PDF** | Generación y descarga de un PDF con el listado completo de alumnos. | ✅ **Implementado** |

- ##### Módulo: Gestión Académica (Profesores y Talleres)
    Este módulo abarca la gestión del personal docente y la oferta formativa.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-PROF-01** | **Listado de Profesores** | Tabla con todos los profesores registrados e iconos de editar/eliminar. | ✅ **Implementado** |
    | **V-PROF-02** | **Formulario de Alta** | Formulario para dar de alta a un nuevo profesor con sus datos personales. | ✅ **Implementado** |
    | **V-PROF-03** | **Edición / Eliminación** | Modal de edición y acción de borrado con confirmación, análogos al módulo de alumnos. | ✅ **Implementado** |
    | **V-PROF-04** | **Exportar PDF** | Generación de PDF con el listado de profesores. | ✅ **Implementado** |
    | **V-TALL-01** | **Listado de Talleres** | Tabla con los talleres disponibles: nombre, descripción, profesor titular y cupo máximo. | ✅ **Implementado** |
    | **V-TALL-02** | **Formulario de Alta** | Formulario para crear un taller, con selector de profesor titular y campo de cupo máximo. | ✅ **Implementado** |
    | **V-TALL-03** | **Edición / Eliminación** | Modal de edición y borrado con confirmación para talleres. | ✅ **Implementado** |
    | **V-TALL-04** | **Exportar PDF** | Generación de PDF con el catálogo de talleres. | ✅ **Implementado** |

- ##### Módulo: Inscripciones y Seguimiento
    Gestión de la relación entre alumnos y talleres.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-INS-01** | **Listado de Inscripciones** | Tabla con todas las matriculaciones activas: alumno, taller y fecha de inscripción. | ✅ **Implementado** |
    | **V-INS-02** | **Formulario de Alta** | Formulario con selectores desplegables para elegir alumno y taller. Valida el cupo máximo. | ✅ **Implementado** |
    | **V-INS-03** | **Eliminación** | Borrado de una inscripción con confirmación. | ✅ **Implementado** |
    | **V-INS-04** | **Exportar PDF** | Generación de PDF con el listado de inscripciones activas. | ✅ **Implementado** |

---

#### 3. Integración con el Backend
La comunicación entre la vista y la lógica de negocio sigue el flujo estricto de Spring MVC:

1.  **Petición:** El usuario interactúa con la interfaz (GET/POST).
2.  **Web Adapter (Controller):** El controlador recibe la petición.
3.  **Lógica:** El controlador invoca el Caso de Uso correspondiente a través del Puerto de Entrada.
4.  **Modelo:** El resultado se mapea a un DTO y se añade al objeto `Model` de Spring.
5.  **Renderizado:** Thymeleaf procesa la plantilla HTML inyectando los datos del `Model` para generar la vista final que se devuelve al navegador.

> **Nota:** Para operaciones asíncronas o dinámicas sin recarga de página (si las hubiera), se expondrán endpoints REST que serán consumidos mediante JavaScript (Fetch API/AJAX).

---

[Volver](/README.md)
