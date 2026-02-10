### Información sobre la versión de las herramientas utilizadas

---

Para garantizar la reproducibilidad y estabilidad del proyecto **AulaCreativa**, se ha definido una arquitectura de software basada en versiones con Soporte a Largo Plazo y estándares de la industria.

La gestión de versiones se centraliza principalmente a través del **Spring Boot Starter Parent**, que orquesta la compatibilidad entre el framework, el ORM y las librerías de utilidades.

---

#### 1. Matriz de Tecnologías del Núcleo (Core)

| Tecnología | Versión | Artefacto Maven | Justificación Técnica |
| --- | --- | --- | --- |
| **Java JDK** | **17 (LTS)** | - | Versión de soporte extendido que introduce mejoras de rendimiento, *Records* y *Pattern Matching*, siendo el estándar actual para Spring Boot 3.x. |
| **Spring Boot** | **3.5.7** | `spring-boot-starter-parent` | Framework base que provee autoconfiguración, servidor embebido (Tomcat) y gestión unificada de dependencias. |
| **Spring Framework** | *Gest. por Spring Boot* | `spring-core` | Núcleo del sistema. Provee el contenedor de Inversión de Control (IoC), Inyección de Dependencias (DI) y el contexto de aplicación. |
| **Maven** | **3.8+** | - | Herramienta de automatización de construcción (*Build Tool*). Gestiona el ciclo de vida, compilación y empaquetado del artefacto `.jar`. |

---

#### 2. Persistencia y Datos

| Tecnología | Versión | Artefacto Maven | Justificación Técnica |
| --- | --- | --- | --- |
| **Spring Data JPA** | *Gest. por Spring Boot* | `spring-boot-starter-data-jpa` | Capa de abstracción sobre JPA. Elimina la necesidad de implementar DAOs manualmente mediante el patrón *Repository*. |
| **Hibernate ORM** | **6.x** | `hibernate-core` | Proveedor JPA por defecto. Mapea las entidades Java a tablas relacionales y gestiona el ciclo de vida de las transacciones. |
| **H2 Database** | *Gest. por Spring Boot* | `com.h2database:h2` | Base de datos relacional en memoria. Permite pruebas unitarias rápidas y limpias sin necesidad de infraestructura externa. |
| **Lombok** | **1.18.x** | `org.projectlombok:lombok` | Librería de procesamiento de anotaciones. Reduce el código repetitivo (*boilerplate*) generando automáticamente Getters, Setters y Builders. |

---

#### 3. Calidad y Entorno de Desarrollo

| Herramienta | Versión | Justificación Técnica |
| --- | --- | --- |
| **JUnit 5 (Jupiter)** | *Gest. por Spring Boot* | Framework de testing de nueva generación. Integrado mediante `spring-boot-starter-test` para pruebas unitarias y de integración (`@DataJpaTest`). |
| **VS Code** | **1.106.3** | Entorno de Desarrollo Integrado (IDE) ligero. Se utiliza por su integración nativa con Docker (DevContainers) y su excelente soporte para Java mediante extensiones de RedHat. |

---

#### Nota sobre la Gestión de Dependencias

>Es importante destacar que, al utilizar **Maven**, la mayoría de las versiones no se declaran explícitamente en el archivo `pom.xml`, sino que son heredadas del padre (`spring-boot-starter-parent:3.5.7`). Esto asegura que todas las librerías (Hibernate, Jackson, JUnit, etc.) sean totalmente compatibles entre sí, evitando el problema conocido como *"Dependency Hell"*.

---

[Volver](/README.md)