### Vista (UI)

---

La interfaz de usuario se implementa siguiendo el patrón **MVC (Modelo-Vista-Controlador)**, utilizando **Thymeleaf** como motor de plantillas para el renderizado en el lado del servidor (Server-Side Rendering). Esta capa actúa como un **Adaptador de Entrada** (Web Adapter) dentro de la arquitectura hexagonal, comunicándose con los puertos de entrada de la aplicación.

---

#### 1. Tecnologías y Enfoque
* **Motor de Plantillas:** Thymeleaf + Spring Boot Starter Web.
* **Estilo y Maquetación:** (Aquí puedes añadir si usas Bootstrap, Tailwind, CSS propio, etc.).
* **Interacción:** Las vistas son dinámicas y responden a los modelos de datos (`Model`) inyectados por los Controladores de Spring MVC.

---

#### 2. Mapa de Navegación y Vistas
A continuación, se detalla el catálogo de interfaces de usuario planificadas, organizadas por el **Vertical Slice** (Módulo funcional) al que pertenecen.

- ##### Módulo: Gestión de Alumnos
    Este módulo centraliza las operaciones relacionadas con los estudiantes del centro.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-ALU-01** | **Listado General** | Visualización tabular de todos los alumnos registrados. Incluye opciones de filtrado y acciones rápidas (editar/borrar). | ✅ **Implementado** |
    | **V-ALU-02** | **Formulario de Edición** | Interfaz para modificar los datos de un alumno existente. Realiza *binding* de datos bidireccional con el backend. | ✅ **Implementado** |
    | **V-ALU-03** | **Acción de Eliminación** | Mecanismo (Modal o Vista de confirmación) para el borrado seguro de un alumno desde el listado. | ✅ **Implementado** |
    | **V-ALU-04** | **Alta de Alumno** | Formulario de registro para nuevos ingresos. Incluye validaciones de cliente y servidor. | 🗓️ **Planificado** |

- ##### Módulo: Gestión Académica (Profesores y Actividades)
    Este módulo abarca la gestión del personal docente y la oferta formativa.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-ACAD-01** | **Gestión de Profesores** | Panel para consultar, dar de alta y asignar profesores. | 🗓️ **Planificado** |
    | **V-ACAD-02** | **Catálogo de Actividades** | Vista para la gestión (CRUD) de talleres y actividades formativas disponibles. | 🗓️ **Planificado** |

- ##### Módulo: Inscripciones y Seguimiento
    Gestión de la relación entre alumnos y actividades.

    | ID Vista | Nombre de la Vista | Descripción Funcional | Estado |
    | :--- | :--- | :--- | :--- |
    | **V-INS-01** | **Gestión de Inscripciones** | Interfaz para matricular alumnos en actividades y consultar las listas de clase. | 🗓️ **Planificado** |

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
