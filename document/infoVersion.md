### Información sobre la versión de las herramientas utilizadas
---

Para el desarrollo y las pruebas del proyecto AulaCreativa, se utilizaron diversas herramientas y tecnologías del ecosistema Java y Spring Boot. A continuación se detallan las versiones empleadas.

#### Java Development Kit (JDK)
- Versión utilizada:Java 17
- Motivo de uso:versión de soporte extendido, estable y compatible con Spring Boot 3.5.7

#### Spring Boot
- Versión utilizada:3.5.7
- Motivo de uso:simplifica la configuración de la aplicación, proporciona autoconfiguración y un servidor embebido, y se integra con Spring Data JPA y H2 sin configuración adicional.

#### Spring Framework
- Versión utilizada:Incluida dentro de Spring Boot 3.5.7.
  (Spring Boot incorpora automáticamente la versión adecuada del framework)
- Motivo de uso:Proporciona los módulos fundamentales como:

Inyección de dependencias

Gestión del ciclo de vida de beans

Integración con JPA

  
#### Spring Data JPA
- Versión utilizada:la incluida en Spring Boot 3.5.7.
  (El starter spring-boot-starter-data-jpa gestiona automáticamente las versiones internas de JPA y Hibernate)
- Motivo de uso:Ofrece la capa de persistencia basada en JPA, automatiza la generación de consultas y simplifica la interacción con la base de datos.

#### JPA/Hibernate
- Versión utilizada:La incluida en el starter de Spring Boot 3.5.7.
(Hibernate 6.x se usa como implementación por defecto de JPA en Spring Boot 3)
- Motivo de uso:Hibernate actúa como el proveedor ORM responsable de mapear las entidades Java a tablas de base de datos.
- Asegura que las entidades sean traducidas a registros de base de datos y viceversa de forma automática.
  
#### Base de datos H2
- Versión utilizada:(Incluida a través de la dependencia com.h2database:h2 en el pom)
- Motivo de uso:Facilita las pruebas, ya que no requiere instalación y permite reconstruir las tablas en cada ejecución.Ideal para pruebas unitarias e integradas con Spring Boot.

#### Maven
- Versión utilizada:3.8+
- Motivo de uso:construcción del proyecto, gestión de dependencias.
  
#### JUnit 5 (Jupiter)
- Versión utilizada:(Incluida dentro del starter spring-boot-starter-test)
- Motivo de uso:framework para pruebas unitarias y de integración.

Se integra con Spring Boot Test, permitiendo ejecutar pruebas sobre repositorios JPA con anotaciones como:
@DataJpaTest
@Test
@BeforeEach

#### Lombok
- Versión utilizada:1.18.x
(Cargada mediante la dependencia org.projectlombok:lombok)
- Motivo de uso:generar automáticamente getters, setters, constructores y builders en clases del dominio y entidades JPA lo que reduce el código repetitivo permitiendo que las clases sean más limpias y legibles.

#### VS Code
- Versión utilizada:1.106.3
- Motivo de uso:Herramienta de desarrollo utilizada para:

Edición de código

Ejecución de la aplicación

Lanzamiento de pruebas

Depuración
[Volver](/README.md)