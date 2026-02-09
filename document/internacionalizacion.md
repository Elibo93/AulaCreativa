### Internacionalización 
---

La aplicación **AulaCreativa** está preparada para incorporar soporte multilenguaje mediante los mecanismos de internacionalización proporcionados por **Spring Boot** y **Thymeleaf**.

El objetivo de esta funcionalidad es permitir que la interfaz de usuario pueda mostrarse en distintos idiomas sin necesidad de modificar las vistas ni la lógica de negocio.

---

#### Enfoque de internacionalización

La internacionalización se basa en el uso de archivos de propiedades (`.properties`) que contienen las traducciones de los textos mostrados en la interfaz.

Cada idioma dispone de su propio archivo, por ejemplo:

- `messages_es.properties` – Español
- `messages_en.properties` – Inglés

Estos archivos permiten asociar claves de texto con sus traducciones correspondientes.

---

#### Integración con Spring Boot y Thymeleaf

Spring Boot proporciona soporte nativo para internacionalización mediante el uso de un `MessageSource`. Thymeleaf permite acceder a estos mensajes directamente desde las vistas utilizando expresiones específicas.

Ejemplo conceptual de uso en una vista Thymeleaf:

```html
<h1 th:text="#{alumnos.titulo}"></h1>