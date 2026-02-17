### Gestión de Perfiles y Entornos (Spring Profiles)

---

Para garantizar que la aplicación **Artia - Aula Creativa** pueda ejecutarse correctamente en diferentes infraestructuras sin necesidad de modificar el código fuente, se ha implementado el sistema de **Perfiles de Spring Boot**.

Un perfil actúa como una etiqueta que agrupa una configuración específica, permitiendo que la aplicación adapte su comportamiento (base de datos, nivel de logs, servicios externos) dinámicamente según el entorno donde se despliegue.

---

#### 1. Justificación y Necesidad

El uso de perfiles responde a la necesidad de automatizar la configuración y evitar errores humanos derivados de la gestión manual.

* **Seguridad:** Evita exponer credenciales de producción en entornos de desarrollo.
* **Integridad:** Elimina el riesgo de conectar accidentalmente una versión de prueba a la base de datos real.
* **Flexibilidad:** Permite probar comportamientos específicos (como el envío simulado de emails) sin afectar a los usuarios reales.

---

#### 2. Estrategia de Configuración

Siguiendo el patrón de nombres estándar de Spring Boot, la configuración se ha segregado en tres ficheros distintos ubicados en `src/main/resources`:

##### `application.properties` (Configuración Base)

Contiene los elementos comunes a todos los entornos. Se define aquí la configuración que es invariable.

```properties
spring.application.name=artia-aula-creativa
api.version=1.0
server.error.include-message=always
# Perfil por defecto activo si no se especifica otro
spring.profiles.active=dev

```

##### `application-dev.properties` (Entorno de Desarrollo)

Configuración optimizada para la productividad del desarrollador y la depuración.

* **Base de Datos:** H2 en memoria (`jdbc:h2:mem:testdb`).
* **Logs:** Nivel `DEBUG` para las consultas SQL (Hibernate), permitiendo ver qué ocurre "por debajo".
* **Herramientas:** Consola H2 habilitada para inspección visual de datos.
* **Inicialización:** Carga automática de datos de prueba (`data.sql`) en cada reinicio.

##### `application-prod.properties` (Entorno de Producción)

Configuración enfocada en el rendimiento, la persistencia y la seguridad.

* **Base de Datos:** Conexión a motor persistente (PostgreSQL/MySQL) mediante Docker.
* **Logs:** Nivel `ERROR` o `INFO` para reducir el ruido y optimizar el rendimiento.
* **DDL:** Validación del esquema (`validate`) en lugar de recreación, para asegurar que no se pierden datos.

---

#### 3. Activación de Perfiles

La selección del "traje" que vestirá la aplicación se realiza en el momento del despliegue:

* **En Local (IDE):** Se utiliza por defecto el perfil `dev` definido en `application.properties`.
* **En Contenedores (Docker):** Se inyecta la variable de entorno `SPRING_PROFILES_ACTIVE` al crear el contenedor. Esto permite que la misma imagen Docker funcione como desarrollo o producción simplemente cambiando esta variable.

```bash
# Ejemplo de ejecución activando el perfil de producción
java -jar artia-app.jar --spring.profiles.active=prod

```

---

#### 4. Desarrollo basado en componentes (@Profile)

Además de la configuración, el código Java utiliza la anotación `@Profile` para cargar condicionalmente ciertos *beans*. Esto permite, por ejemplo, utilizar un servicio de envío de emails real (`SmtpEmailService`) cuando el perfil activo es `prod`, y un servicio simulado (`MockEmailService`) que solo imprime en consola cuando estamos en `dev`.

---

[Volver](/README.md)