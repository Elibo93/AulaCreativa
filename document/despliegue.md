### Despliegue

En este subapartado se describe **cómo se va a ejecutar y publicar la aplicación** una vez desarrollada. Aunque algunos detalles aún están por definir, aquí se incluye lo esencial que debe aparecer:

* **Entorno de ejecución**: indicar que la aplicación está desarrollada con **Spring Boot Web** y que se ejecutará sobre un entorno **Linux** (actualmente usando un contenedor basado en **Alpine** durante el desarrollo).

* **Uso de contenedores**: explicar que la aplicación se desplegará mediante **Docker**, utilizando imágenes que contienen tanto la aplicación como sus dependencias. También mencionar que se usa un **devContainer** para el entorno de desarrollo.

* **Servidor o nube**: especificar que la aplicación se publicará en un **servidor remoto** o en algún proveedor de **nube**, aunque todavía no esté decidido cuál. La idea es que el despliegue sea **automatizable y reproducible** gracias a los contenedores.

* **Base de datos**: indicar que el despliegue incluirá una **base de datos** externa o en otro contenedor. Por ahora no se sabe cuál se usará, pero el diseño permitirá cambiarla sin afectar a toda la arquitectura.

* **Estructura del despliegue**: mencionar que la arquitectura estará preparada para que cada componente (app, base de datos…) pueda desplegarse por separado, facilitando posibles configuraciones futuras como **Docker Compose**.

* **Escalabilidad futura**: dejar apuntado que más adelante se podrá añadir integración con sistemas de **orquestación** (como Kubernetes) o pipelines de **CI/CD**, pero de momento no forman parte del alcance actual.

[Volver](/README.md)