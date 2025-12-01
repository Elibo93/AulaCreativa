### Despliegue
---
En este subapartado se describe **cómo se va a ejecutar y publicar la aplicación** una vez desarrollada. Aunque algunos detalles aún están por definir, aquí se incluye lo esencial que debe aparecer:

* **Entorno de ejecución**: La aplicación está desarrollada con Spring Boot Web, lo que permite ejecutarla como un servicio independiente.
El despliegue se realizará en un entorno Linux, ya que ofrece estabilidad y buen rendimiento.
Durante el desarrollo se utiliza una imagen ligera basada en Alpine Linux, que permite trabajar de forma rápida y con poco consumo de recursos.

* **Uso de contenedores**: La aplicación se ejecutará mediante **Docker**, de modo que todo el software necesario (la aplicación y sus dependencias) se incluye dentro de contenedores.
Esto aporta varias ventajas:

- El entorno es siempre el mismo, sin importar dónde se ejecute.

- Facilita la instalación y el despliegue.

- Evita problemas de dependencias entre máquinas.

Además, se utiliza un **devContainer** en el entorno de desarrollo para garantizar que todos los desarrolladores trabajan con la misma configuración.

* **Base de datos**: La aplicación utiliza una base de datos **H2**, que es una base de datos ligera escrita en Java. H2 se ejecuta en memoria o en archivo local, y no requiere instalación externa, lo que la hace ideal para el desarrollo.

Para gestionar los datos se emplean:

- **JPA** (Java Persistence API): un estándar que define cómo manejar las entidades y la persistencia.

- **Hibernate** (ORM): una herramienta que implementa JPA y permite convertir las clases Java en tablas de la base de datos sin necesidad de escribir SQL.

Gracias a esta combinación, es posible cambiar en el futuro a otra base de datos (como PostgreSQL o MySQL) sin modificar la lógica de la aplicación, únicamente ajustando la configuración.



[Volver](/README.md)