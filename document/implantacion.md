### Implantación/Puesta en producción
---

A continuación se describen los componentes utilizados en el proyecto **AulaCreativa** y por qué se usan dentro del proceso de implantación y puesta en producción.

#### DevContainer
Un entorno de desarrollo reproducible basado en Docker que se configura automáticamente al abrir el proyecto en VS Code.

**Por qué se usa:**

- Para que todos los desarrolladores tengan la misma versión de Java y Maven.

- Evita problemas de “en mi máquina funciona”.

- No requiere configurar Java ni Maven en el equipo local.

- Asegura que el entorno de desarrollo y el de producción sean similares.

#### Java + Maven (carpetas pom.xml, src, .mvn, mvnw)


El proyecto está construido con Java y usa Maven como gestor de dependencias y herramienta de construcción.

**Por qué se usa:**

- Maven permite compilar, ejecutar y empaquetar el proyecto de forma automática.

- Las dependencias quedan centralizadas en pom.xml.

- Genera el archivo .jar de producción dentro de target/.

#### VS Code + Extensiones

Visual Studio Code es el editor principal utilizado para el desarrollo del proyecto. Se eligió porque es ligero, multiplataforma y tiene soporte integrado para entornos de desarrollo basados en contenedores (DevContainers), Git y Java.


**Por qué se usa:**

- Permite trabajar dentro del DevContainer, asegurando que todos los desarrolladores utilicen el mismo entorno.

- Tiene extensiones específicas para Java y Maven, necesarias para el proyecto.

- Ofrece integración nativa con Git, simplificando el control de versiones.

- Facilita la depuración, ejecución e inspección del código de forma sencilla.

#### Extensiones

**Maven for java**

Extensión específicamente diseñada para trabajar con proyectos Maven.

- Permite compilar, limpiar y empaquetar el proyecto con un solo clic.

- Facilita la gestión de dependencias definidas en pom.xml.

- Genera el archivo .jar necesario para la puesta en producción.

**Dev Containers**

Extensión que permite a VS Code ejecutar el proyecto dentro de un contenedor configurado en .devcontainer/.

- Asegura que todos los desarrolladores trabajen con la misma versión de Java, Maven y librerías.

- Evita errores por diferencias entre equipos.

- Aporta un entorno idéntico al de producción, aumentando la estabilidad del despliegue.


#### GitFlow

GitFlow es la metodología de control de versiones usada para organizar el ciclo de desarrollo y asegurar que la puesta en producción sea estable.

Es una estrategia basada en ramas que divide el trabajo en fases claras.

**Ramas principales**

**Main**

- Contiene la versión estable y lista para producción.

- Solo recibe cambios tras una release finalizada.

**Develop**

- Contiene la versión estable y lista para producción.

- Solo recibe cambios tras una release finalizada.

**Por qué se usa:**

- Mantiene estabilidad en producción al proteger la rama main.

- Facilita el trabajo en equipo evitando conflictos de código.

- Aclara cuándo se está desarrollando, corrigiendo o publicando.

- Permite realizar despliegues controlados y seguros.

- Se adapta muy bien a ciclos de entrega continuos (CI/CD).



[Volver](/README.md)