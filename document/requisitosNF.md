### Requisitos no funcionales (NF)
---

#### Requisitos No Funcionales (RNF) de Arquitectura y Mantenibilidad

<p align="center">
  <img src="/img/rnf.png" width="450">
</p>

##### Adherencia Estricta a la Arquitectura Hexagonal

El código fuente debe **respetar de manera estricta** los límites y principios definidos por la Arquitectura Hexagonal. Esto implica que:

* **Dirección de Dependencias:** Las dependencias entre las capas deben fluir **siempre hacia el interior**, apuntando hacia la capa central del **Dominio (Business Core)**.
* **Aislamiento de la Lógica:** La lógica de negocio crucial y las reglas de la aplicación deben estar completamente **libres de dependencias** de cualquier tecnología externa, como *frameworks* de interfaz de usuario, librerías de persistencia (como JPA o Spring Data), o *frameworks* web. Esto asegura la máxima *testabilidad* y *portabilidad* del *core* de la aplicación.

##### Modularidad y Escalabilidad mediante Vertical Slicing

La estructura organizativa del proyecto debe basarse en el patrón de **Vertical Slicing** (Cortes Verticales).

* **Organización por Funcionalidad:** El código debe agruparse en paquetes o módulos que representan una funcionalidad o característica completa de la aplicación (ej., `com.tudominio.inscripciones`, `com.tudominio.talleres`).
* **Independencia Funcional:** Al añadir una **nueva funcionalidad** (*slice* vertical), el impacto en los *slices* existentes debe ser **nulo o mínimo**. Este enfoque garantiza una **escalabilidad funcional** superior, facilitando el desarrollo paralelo y la futura segregación del código si se migra a microservicios.

##### Convenciones de Código y Limpieza

Para garantizar la **legibilidad** y **mantenibilidad** a largo plazo, el código debe adherirse a estándares profesionales:

* **Convenciones Estándar:** El código debe seguir las convenciones de nombrado de Java (ej. `CamelCase` para clases y variables, nombres **descriptivos** y que reflejen la intención).
* **Uso Juicioso de Lombok:** Se permitirá el uso de la librería **Lombok** para reducir el código repetitivo (*boilerplate*), específicamente para generar *getters*, *setters*, y constructores simples. Su uso debe ser moderado, evitando ocultar lógica crucial o métodos que deberían implementarse explícitamente.

##### Garantía de Testabilidad del Dominio (Unit Testing)

La arquitectura debe **facilitar inherentemente** la creación de pruebas automatizadas en los distintos niveles de la aplicación.

* **Enfoque en el Dominio:** Debe ser posible crear y ejecutar **pruebas unitarias** (empleando *JUnit* y *Mockito*) sobre la **capa de Dominio** y su lógica de negocio de manera **completamente aislada**.
* **Independencia de Contexto:** Esto significa que las pruebas más importantes **no deben requerir** levantar el contexto completo de Spring (*Spring Context*) ni inicializar la base de datos (incluso la base de datos H2 en memoria).

---

#### Requisitos No Funcionales (RNF) de Desacoplamiento y Persistencia

##### Abstracción Total de la Persistencia (Database Agnostic)

Aunque el desarrollo inicial y las pruebas utilicen una base de datos en memoria (como **H2**), la solución debe estar diseñada para ser **completamente agnóstica** al motor de base de datos final.

* **Aislamiento JPA/Hibernate:** El uso de JPA/Hibernate (o cualquier *framework* ORM) debe actuar como el adaptador, **abstraído** del Dominio mediante el patrón *Repository* de la Arquitectura Hexagonal.
* **Portabilidad de Datos:** El cambio a una base de datos de producción (como **PostgreSQL** o **MySQL**) debe ser un proceso de **configuración pura**. Solo debe requerir modificar las propiedades de conexión dentro del archivo `application.properties` y ajustar las dependencias del *driver* en Maven/Gradle, **sin necesidad de realizar cambios** en el código fuente de Java.

* **Internacionalización:** ### Internacionalización 
---

La aplicación **AulaCreativa** está preparada para incorporar soporte multilenguaje mediante los mecanismos de internacionalización proporcionados por **Spring Boot** y **Thymeleaf**.

El objetivo de esta funcionalidad es permitir que la interfaz de usuario pueda mostrarse en distintos idiomas sin necesidad de modificar las vistas ni la lógica de negocio.

---

#### Enfoque de internacionalización

La internacionalización se basa en el uso de archivos de propiedades (`.properties`) que contienen las traducciones de los textos mostrados en la interfaz.

Cada idioma dispone de su propio archivo, por ejemplo:

- `messages_es.properties` – Español
- `messages_en.properties` – Inglés
- `messages_it.properties` – Italiano
- `messages_ar.properties` – Arabe

Estos archivos permiten asociar claves de texto con sus traducciones correspondientes.

---

#### Integración con Spring Boot y Thymeleaf

Spring Boot proporciona soporte nativo para internacionalización mediante el uso de un `MessageSource`. Thymeleaf permite acceder a estos mensajes directamente desde las vistas utilizando expresiones específicas.

Ejemplo conceptual de uso en una vista Thymeleaf:

```html
<h1 th:text="#{alumnos.titulo}"></h1>
  
[Volver](/README.md)