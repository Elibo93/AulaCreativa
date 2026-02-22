### Reutilización

---

#### Reutilización en la Arquitectura Frontend (Thymeleaf + HTMX)

La interfaz gráfica del proyecto se ha desarrollado buscando simplicidad, reactividad y mantenibilidad. Para reducir la duplicidad de código y garantizar la consistencia visual, se combinan el renderizado del servidor (**Thymeleaf**) con interacciones dinámicas (**HTMX**), potenciando la reutilización a dos niveles:

##### Sistema de Layouts y Fragmentos (Thymeleaf)
La construcción de la interfaz se basa en el principio de herencia y composición, lo que permite reciclar elementos de diseño comunes en todas las vistas:
* **Layout Principal:** Un archivo base (`main-layout.html`) define la estructura general de la página (SPA). Recursos como librerías CSS, fuentes y scripts se cargan una única vez aquí, aplicándose al instante en toda la aplicación.
* **Fragmentos Aislados y Sustitución Dinámica:** Elementos que se repiten (cabecera, menú, pie de página, notificaciones, alertas) se separan en fragmentos independientes. Mediante etiquetas como `th:replace`, el controlador inyecta el fragmento específico correspondiente al área "content" en el espacio principal, reutilizándolos allá donde hagan falta.

##### Interactividad Reactiva Reutilizable (HTMX)
La inclusión de HTMX reduce enormemente la adición de librerías JS o peticiones nativas fetch en la capa cliente, haciendo que los pedazos de interfaz sean directamente reutilizables:
* **Respuestas Reutilizables:** Los fragmentos de Thymeleaf no solo construyen la vista inicial, sino que se enrutan y reutilizan como respuesta del servidor ante peticiones asíncronas de HTMX. Esto evita tener que picar la vista por un lado (frontend) y una lógica paralela en JSON por otro (backend).
* **Componentes Reactivos Declarativos:** Los hipervínculos y formularios emplean atributos como `hx-get`, `hx-post`, `hx-target` y `hx-swap` para realizar solicitudes y actualizar fragmentos del DOM. Estos patrones asíncronos son reutilizados para transiciones y acciones en toda la aplicación, comportándose como una app SPA que consume muy pocos recursos locales.

En conclusión, este ecosistema minimiza el código duplicado global: un cambio en un área (como el visual de una alerta o un cambio en el menú) se modifica en un lugar y se propaga automáticamente por toda la arquitectura.

---

[Volver](/README.md)
