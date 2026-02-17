### Reutilización

---

#### Reutilización de Componentes de Interfaz

Para garantizar la consistencia visual y reducir la duplicidad de código en la capa de presentación, se ha implementado una estrategia de composición de vistas basada en el motor de plantillas **Thymeleaf**.

##### Sistema de Plantillas (Layout Decorator)
Se utiliza un patrón de diseño de "Página Maestra" (`layout.html`) que define la estructura HTML base común para todas las pantallas del sistema.
* **Heredabilidad:** Todas las vistas individuales (listados, formularios) inyectan su contenido específico dentro de este contenedor maestro.
* **Recursos Globales:** La carga de librerías CSS (estilos), fuentes y scripts JavaScript se realiza una única vez en el layout, asegurando que cualquier actualización de estilos se propague automáticamente a toda la aplicación.

##### Fragmentos Reutilizables (Fragments)
Los elementos de interfaz que se repiten en múltiples contextos se han encapsulado en fragmentos independientes para ser invocados mediante `th:replace` o `th:insert`:
* **Navegación Global:** La barra de menú (`header`) y el pie de página (`footer`) son componentes aislados.
* **Componentes de Feedback:** Se ha diseñado un único componente para la visualización de alertas (éxito/error) y ventanas modales de confirmación, que es reutilizado por todos los módulos funcionales (Alumnos, Profesores, Talleres).

Esta arquitectura de frontend facilita el mantenimiento: si es necesario cambiar el logo, el color del menú o la librería de iconos, la modificación se realiza en un único archivo y se aplica instantáneamente a todo el sistema.

---

[Volver](/README.md)
