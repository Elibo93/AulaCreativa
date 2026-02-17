### Entorno de Desarrollo

---

Este documento detalla el ecosistema tecnológico seleccionado para la implementación de **AulaCreativa**. La elección de estas herramientas responde a criterios de robustez, soporte a largo plazo y compatibilidad con la **Clean Architecture** planteada.

#### Núcleo del Lenguaje

* **Java 17 (LTS):** Se ha seleccionado la versión 17 por ser una *Long Term Support*, ofreciendo un equilibrio óptimo entre características modernas del lenguaje (Records, Pattern Matching) y estabilidad para entornos productivos.

#### Frameworks y Ecosistema Spring

El proyecto se fundamenta en el ecosistema **Spring**, aprovechando su inyección de dependencias y su capacidad de configuración automática.

| Componente | Tecnología | Responsabilidad en el Proyecto |
| --- | --- | --- |
| **Framework Base** | **Spring Boot 3.x** | Facilita la configuración, el arranque con servidor embebido (Tomcat) y la gestión de dependencias. |
| **Motor de Plantillas** | **Thymeleaf** | Renderizado de vistas en el servidor (SSR) para el módulo de administración web, integrado nativamente con Spring. |
| **Acceso a Datos** | **Spring Data JPA** | Abstrae la capa de persistencia mediante el patrón *Repository*, reduciendo el código repetitivo (boilerplate). |
| **ORM** | **Hibernate** | Implementación del estándar JPA. Gestiona el mapeo entre los objetos del dominio y las tablas relacionales. |
| **Documentación** | **SpringDoc OpenAPI** | Generación automática de la documentación de la API REST y la interfaz Swagger UI. |

#### Persistencia y Base de Datos

Siguiendo la estrategia de entornos diferenciados:

* **H2 Database:** Motor de base de datos en memoria utilizado en **Desarrollo y Test**. Permite prototipado rápido y pruebas limpias.
* **PostgreSQL (Driver):** Soporte añadido para el despliegue en **Producción**, garantizando persistencia robusta y concurrencia.

#### Gestión del Ciclo de Vida y Dependencias

* **Apache Maven:** Herramienta utilizada para la gestión de dependencias, compilación, empaquetado y ejecución de pruebas. Gestiona el ciclo de vida del artefacto `.jar`.

#### Calidad y Pruebas (QA)

* **JUnit 5 (Jupiter):** Framework estándar para la definición y ejecución de pruebas unitarias y de integración.
* **Mockito:** Librería utilizada para crear *mocks* y aislar componentes, permitiendo probar la lógica de negocio sin depender de la base de datos o servicios externos.

#### Herramientas de Infraestructura

* **Docker & Docker Compose:** Utilizados para contenerizar la aplicación y orquestar el entorno (App + Base de Datos), eliminando problemas de compatibilidad entre máquinas ("funciona en mi local").

---

[Volver](/README.md)