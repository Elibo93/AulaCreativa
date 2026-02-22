### Anexos

---

Este apartado recopila material técnico complementario, ficheros de configuración y documentación de soporte que, por su extensión o nivel de detalle, dificultarían la lectura del cuerpo principal de la memoria. Estos anexos sirven como evidencia técnica del trabajo realizado y facilitan la reproducibilidad del proyecto **Artia – Aula Creativa**.

#### Anexo A. Manual de Despliegue Rápido

Guía técnica para poner en marcha la aplicación en un entorno local utilizando la infraestructura contenerizada.

* **Pre-requisitos:** Docker y Git.
* **Comandos de ejecución:** Instrucciones para clonar el repositorio y ejecutar el script `docker-compose up`.
* **Credenciales por defecto:** Usuarios de prueba (Admin/Profesor/Alumno) generados por los scripts de inicialización (`data.sql`).

#### Anexo B. Diccionario de Datos y Scripts SQL

Documentación detallada de la capa de persistencia a nivel de base de datos.

* **Script DDL (`schema.sql`):** Código SQL utilizado para la creación de las tablas, restricciones de integridad (Foreign Keys) e índices.
* **Diccionario de Datos:** Tabla descriptiva de cada campo de la base de datos (tipo de dato, longitud, restricciones `NOT NULL`, `UNIQUE`), complementando el diagrama E-R presentado en el apartado de Diseño.

#### Anexo C. Especificación OpenAPI (Swagger JSON)

Referencia técnica completa de la interfaz de comunicación.

* Se adjunta o referencia el archivo `swagger.json` o `openapi.yaml` generado por la aplicación.
* Este archivo define formalmente el contrato de la API, permitiendo la generación automática de clientes y la integración con herramientas de terceros.

#### Anexo D. Snippets de Configuración Clave

Fragmentos de código esenciales que demuestran la configuración de la infraestructura del proyecto.

* **`application.properties`:** Configuración de los perfiles de Spring (`dev` vs `prod`).
* **`SecurityConfig.java`:** Configuración de las cadenas de filtros de seguridad (`SecurityFilterChain`) y reglas CORS.
* **`Dockerfile`:** Definición de la imagen de construcción basada en Alpine Linux y JDK 17.

#### Anexo E. Glosario de Términos

Definición de conceptos técnicos y acrónimos utilizados a lo largo del documento para facilitar su comprensión por lectores no especializados en el stack tecnológico específico.

* **Términos:** *Clean Architecture, Hexagonal, Vertical Slicing, Endpoint, Docker Container, RESTful, Fat JAR, ORM, DTO, UUID, etc.*

#### Anexo F. Índice de Recursos Gráficos

Relación de las figuras, diagramas e ilustraciones incluidas en la memoria, indicando su fuente:

* **Elaboración propia:** Diagramas UML (Clases, Secuencia, Casos de Uso) diseñados con Mermaid/PlantUML.
* **Fuentes externas:** Referencia a logotipos oficiales de tecnologías (Spring, Docker, Java) utilizados con fines educativos e ilustrativos.

---

### Observación Final

La documentación presentada en estos anexos, junto con el código fuente alojado en el repositorio del proyecto, constituye el **paquete de entrega técnica** de **Artia – Aula Creativa**. Su objetivo es garantizar que el sistema sea auditables, mantenible y extensible por futuros equipos de desarrollo.

---

[Volver](/README.md)