### Plan de Pruebas y Estrategia de QA

---

El objetivo de este plan de pruebas es definir la estrategia de Aseguramiento de la Calidad para el sistema **AulaCreativa**. Dado que el proyecto sigue una **Arquitectura Clean**, la estrategia se centra en verificar cada capa de forma aislada (Unitarias) y en conjunto (Integración).

El stack tecnológico de pruebas incluye **JUnit 5** como framework principal, **Mockito** para el aislamiento de componentes y **H2 Database** para la simulación de persistencia en memoria.

#### Objetivos de las Pruebas

* **Integridad del Dominio:** Validar que las reglas de negocio y las entidades del núcleo se comportan según lo esperado, independientemente de la base de datos o el framework.
* **Persistencia Fiable:** Garantizar que los repositorios **JPA** gestionan correctamente el ciclo de vida de los datos (CRUD) y los mapeos entre objetos y tablas.
* **Mapeo de Datos:** Verificar que la transformación de datos entre capas (DTO ↔ Dominio ↔ Entidad JPA) es precisa y sin pérdida de información.
* **Detección de Regresiones:** Asegurar que los nuevos desarrollos no rompen funcionalidades existentes.

---

#### Metodología de Pruebas

Para todas las pruebas se sigue el patrón estándar **AAA (Arrange, Act, Assert)**:

1. **Arrange (Preparar):** Se configura el estado inicial (crear objetos, configurar mocks).
2. **Act (Ejecutar):** Se invoca el método o funcionalidad bajo prueba.
3. **Assert (Verificar):** Se comprueba que el resultado obtenido coincide con el esperado.

---

#### Tipos de Pruebas Implementadas

##### 1. Pruebas Unitarias (Unit Testing)

Se centran en probar componentes individuales de forma aislada. En el contexto de Clean Architecture, estas pruebas validan principalmente la capa de **Dominio** y **Aplicación**.

* **Alcance:** Entidades, Value Objects, Mappers y Servicios de Dominio.
* **Estrategia:** Ejecución rápida en memoria sin levantar el contexto de Spring.
* **Verificaciones:**
* Creación correcta de objetos de dominio.
* Validación de reglas de negocio (ej: no permitir un DNI nulo).
* Correcto funcionamiento de los métodos `toEntity()` y `toDomain()` en los Mappers.



##### 2. Pruebas de Integración (Persistence Testing)

Estas pruebas validan la capa de **Infraestructura**, específicamente la interacción entre la aplicación y la base de datos. Se aseguran de que las consultas SQL generadas por Hibernate sean correctas.

* **Herramientas:** `@DataJpaTest` (carga solo la capa de persistencia) y Base de Datos **H2** en memoria.
* **Alcance:** Repositorios JPA y Entidades JPA.

###### Escenarios de Prueba para Repositorios (CRUD)

| Operación | Objetivo de la Prueba | Validaciones (Asserts) |
| :--- | :--- | :--- |
| **Create (Guardar)** | Verificar la persistencia de una nueva entidad. | • Se genera un ID autoincremental.<br>• El número de registros aumenta en 1.<br>• Los datos recuperados coinciden con los guardados. |
| **Read (Buscar)** | Verificar la recuperación de datos (`findById`, `findAll`). | • `findById` devuelve la entidad correcta.<br>• `findById` devuelve `Optional.empty()` si no existe.<br>• Las consultas personalizadas filtran correctamente. |
| **Update (Actualizar)** | Verificar la modificación de datos existentes. | • Los campos modificados persisten tras guardar.<br>• El ID **no** cambia.<br>• Los campos no modificados mantienen su valor original. |
| **Delete (Eliminar)** | Verificar el borrado físico o lógico. | • Tras el borrado, `findById` no encuentra el registro.<br>• El conteo total de registros disminuye en 1. |
| **Constraints** | Verificar restricciones de base de datos (Integridad). | • Intentar guardar un email duplicado lanza excepción.<br>• Guardar campos obligatorios como `null` lanza excepción. |

---

#### Herramientas y Stack de Pruebas

* **JUnit 5 (Jupiter):** Motor de ejecución de pruebas.
* **Spring Boot Test:** Utilidades para pruebas de integración (`@DataJpaTest`).
* **H2 Database:** Base de datos en memoria para entornos de test, rápida y volátil.
* **AssertJ / JUnit Assertions:** Librerías para escribir aserciones fluidas y legibles.

---

[Volver](/README.md)