### Base de datos
---

#### Base de datos en entorno de desarrollo: **H2**

Para el desarrollo y las pruebas de la aplicación **Artia – Aula Creativa** se utiliza **H2**, una base de datos relacional ligera y embebida muy popular en el ecosistema Java y Spring Boot.

H2 resulta especialmente adecuada para entornos de desarrollo, ya que no requiere instalación externa ni configuración compleja, al ejecutarse directamente dentro de la JVM de la aplicación. Esto permite un ciclo de desarrollo más ágil y sin dependencias externas.

---

#### Características principales de H2

##### En memoria (*In-Memory*)

H2 puede ejecutarse completamente en memoria, lo que proporciona un alto rendimiento.
Los datos se recrean cada vez que la aplicación se inicia, siendo ideal para pruebas y desarrollo.

##### Embebida (*Embedded*)

La base de datos y su driver se integran directamente en la aplicación Java, eliminando la necesidad de un servidor de bases de datos independiente.

##### Portabilidad

Al estar escrita en Java, puede ejecutarse en cualquier sistema que disponga de una JVM.

##### Tamaño reducido

El tamaño del archivo JAR es muy pequeño (en torno a **2–3 MB**), lo que la hace ligera y fácil de integrar.

---

#### Consola web de H2

H2 incluye una consola web integrada que permite inspeccionar la estructura de la base de datos, ejecutar consultas SQL y verificar los datos de forma visual desde el navegador.

**URL por defecto:**

```
http://localhost:8080/h2-console
```

Para habilitarla, es necesario añadir la siguiente configuración en el archivo `application.properties`:

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Esta herramienta resulta especialmente útil para depuración y validación del estado de la base de datos durante el desarrollo.

---

#### Inicialización de la base de datos

Spring Boot permite cargar automáticamente la estructura y los datos iniciales mediante scripts SQL ubicados en el directorio `src/main/resources`:

* **schema.sql**: define la estructura de las tablas.
* **data.sql**: inserta datos iniciales de prueba.

Este enfoque facilita trabajar con una base de datos conocida y controlada desde el inicio de la aplicación.

---

#### Configuración de H2 con Spring Data JPA

La aplicación utiliza **Spring Data JPA** como capa de acceso a datos. A continuación se muestra la configuración empleada para H2 en el entorno de desarrollo:

```properties
# Información general
spring.application.name=artia-aula-creativa
api.version=1.0
server.error.include-message=always

# Configuración de la base de datos H2 (en memoria)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

# Inicialización mediante scripts SQL
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always

# Consola H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Logging SQL para depuración
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
```

Se utiliza el valor `spring.jpa.hibernate.ddl-auto=none` para evitar que Hibernate genere automáticamente el esquema, ya que la estructura de la base de datos se define explícitamente mediante el archivo `schema.sql`.

---

#### Consideraciones sobre `ddl-auto`

Hibernate permite generar automáticamente las tablas usando:

```properties
spring.jpa.hibernate.ddl-auto=create-drop
```

Esta opción crea el esquema al iniciar la aplicación y lo elimina al detenerla.

No obstante, en este proyecto se ha optado por **`none`**, con el objetivo de trabajar con un esquema controlado manualmente, simulando de forma más realista un entorno de producción.

---

#### Bases de datos en entorno de producción

Aunque H2 es ideal para desarrollo, **no está diseñada para entornos productivos**.
En producción, Spring Data JPA se integra fácilmente con sistemas de bases de datos más robustos como **MySQL** y **PostgreSQL**.

* **MySQL**: ampliamente utilizado, buen rendimiento y gran adopción.
* **PostgreSQL**: destaca por su robustez y características avanzadas (JSON nativo, consultas complejas).

##### Ejemplo de configuración MySQL

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/miapp
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

##### Ejemplo de configuración PostgreSQL

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/miapp
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

#### Conclusión

El uso de **H2 en desarrollo**, combinado con **Spring Data JPA**, permite un desarrollo rápido, controlado y sin dependencias externas.
Al mismo tiempo, la arquitectura de la aplicación facilita la migración a bases de datos relacionales más avanzadas en entornos de producción.

[Volver](/README.md)