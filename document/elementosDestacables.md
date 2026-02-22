### Elementos Destacables del Desarrollo

---

El desarrollo de **Artia – Aula Creativa** trasciende la simple implementación funcional. Se ha priorizado la excelencia técnica, la robustez arquitectónica y la mantenibilidad a largo plazo. A continuación, se detallan las decisiones de diseño y los paradigmas de ingeniería que diferencian a este proyecto de una solución tradicional.

---

#### 1. Implementación Estricta de Clean Architecture

A diferencia de las arquitecturas tradicionales de N-Capas (donde la base de datos es el centro), Artia sitúa al **Dominio** en el centro del sistema.

* **Independencia del Framework:** La lógica de negocio no depende de Spring Boot ni de librerías externas. Esto garantiza que el núcleo de la aplicación sobreviva a cambios tecnológicos.
* **Inversión de Dependencias (DIP):** Las capas externas (Base de Datos, Web) dependen de las internas, nunca al revés. Esto se logra mediante el uso de **Puertos y Adaptadores**.

---

#### 2. Modelo de Dominio Rico (DDD - Domain Driven Design)

Se ha evitado el antipatrón de "Modelo Anémico" (clases que solo tienen getters y setters). Las entidades de Artia (`Alumno`, `Taller`) poseen lógica de negocio y validación intrínseca.

* **Value Objects:** Uso de objetos inmutables (como `Identificador` o `DNI`) que garantizan la integridad de los datos y evitan la "obsesión por los primitivos".
* **Agregados:** Definición clara de límites transaccionales para garantizar la consistencia de los datos.

---

#### 3. Versatilidad Multi-Interfaz (API First + Server Side Rendering)

Uno de los logros técnicos más notables es la capacidad del sistema para servir a múltiples clientes reutilizando el 100% de la lógica de negocio.
Gracias a la capa de **Aplicación (Casos de Uso)**, el mismo servicio (`CrearAlumnoService`) alimenta simultáneamente:

* **API REST:** Para clientes externos, móviles o integraciones JS (JSON).
* **Interfaz Web (Thymeleaf):** Para la administración directa desde el navegador (HTML).

Esto demuestra un desacoplamiento real entre la lógica y la vista.

---

#### 4. Uso de Patrones de Diseño

El código no es solo funcional, sino que es elegante y legible gracias a la aplicación de patrones probados:

* **Repository:** Para abstraer la persistencia de datos.
* **DTO (Data Transfer Object):** Para desacoplar la estructura de la base de datos de la información que se envía al cliente.
* **Mapper:** Para la transformación segura de datos entre capas sin contaminar el dominio.
* **Facade:** Implementado en los Servicios de Aplicación para orquestar flujos complejos de manera sencilla.

---

#### 5. Enfoque "Security by Design"

La seguridad no es un añadido, sino que forma parte del diseño base.

* **Validación en Profundidad:** Los datos se validan tanto en la entrada (DTOs con *Jakarta Validation*) como en el núcleo del dominio (Reglas de Negocio), impidiendo que el sistema alcance estados inconsistentes.
* **Aislamiento de Infraestructura:** La base de datos está oculta en una red interna (Docker), exponiendo únicamente la API necesaria.

---

#### 6. Innovación: Gamificación del Aprendizaje

Técnicamente, el modelo de datos se ha diseñado para soportar mecánicas de juego en el futuro. La estructura de `Inscripciones` y `Asistencias` está preparada para evolucionar hacia un sistema de **Logros y Recompensas**, permitiendo calcular métricas de rendimiento y ranking de alumnos mediante consultas optimizadas, sentando las bases para una experiencia educativa motivadora.

---

#### 7. Entorno de Desarrollo Profesional (DevOps Ready)

El proyecto nace preparado para la integración continua (CI/CD):

* **Dockerización completa:** Garantía de paridad entre desarrollo y producción.
* **Testing Automatizado:** Batería de pruebas unitarias y de integración que actúan como red de seguridad ante refactorizaciones.
* **Gestión de Versiones:** Uso de GitFlow para un ciclo de vida del software ordenado.

---

#### 8. Arquitectura Frontend: Thymeleaf + HTMX

El frontend del proyecto se ha desarrollado buscando simplicidad, reactividad y mantenibilidad, combinando el renderizado en el servidor (**Thymeleaf**) con interacciones dinámicas sin recarga de página (**HTMX**).

##### 8.1. Sistema de Fragmentos (Thymeleaf)

La interfaz se construye basándose en un sistema de layouts y fragmentos. Esto permite reutilizar componentes comunes (cabecera, menú, pie de página, notificaciones) en todas las vistas:

* **Layout Principal:** Un archivo base (`main-layout.html`) define la estructura general HTML de la SPA.
* **Sustitución Dinámica:** Mediante las etiquetas `th:replace`, el controlador indica referenciando a `content` qué fragmento específico de contenido (ej. lista de alumnos, formulario) debe inyectarse en el espacio principal de la página. El nombre del fragmento incluido debe coincidir para que Thymeleaf logre incrustarlo en la plantilla base.

##### 8.2. Interactividad Reactiva (HTMX)

HTMX se utiliza para añadir comportamiento SPA (Single Page Application) e interacciones asíncronas fluidas, reduciendo la dependencia de frameworks de JavaScript complejos en el cliente.

* **Peticiones AJAX Declarativas:** Atributos como `hx-get`, `hx-post` o `hx-delete` incrustados en elementos HTML permiten realizar peticiones al servidor directamente desde el marcado HTML originando transiciones y borrados limpios sin recargas molestas.
* **Componentes Reactivos:** La respuesta del servidor (generalmente un fragmento HTML actualizado, un mensaje de error o una redirección con aviso) se inyecta directamente en el DOM mediante `hx-target` y `hx-swap`, dando la sensación de una app reactiva consumiendo muy pocos recursos.

---

[Volver](/README.md)