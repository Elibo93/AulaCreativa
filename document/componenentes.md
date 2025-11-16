
### Componentes

En este subapartado describimos los **componentes principales** que forman parte de la aplicación, entendidos como las partes lógicas que se encargan de funciones específicas dentro del sistema. Como todavía estamos en una fase de desarrollo inicial, mantenemos una estructura **mínima y ampliable**, de forma que podamos añadir nuevos componentes más adelante sin modificar este apartado por completo.

Los componentes que consideramos actualmente son:

#### 1. Componente Web (Frontend)

Corresponde a la parte encargada de mostrar la interfaz al usuario. Aunque la interfaz todavía no está completamente definida, este componente representa todo lo relacionado con la **interacción con el usuario**, el acceso a las pantallas y la comunicación con la API.

#### 2. API REST (Backend – Spring Boot)

Es el núcleo de la aplicación. Gestiona las peticiones, la lógica de negocio y los diferentes módulos del sistema (talleres, alumnos, profesores, asistencias, pagos…). Este componente expone los **servicios REST** que utiliza el frontend.

#### 3. Servicio de Persistencia

Representa la capa encargada de comunicarse con la base de datos. Aunque aún no tenemos decidido el motor de base de datos definitivo, este componente engloba los repositorios, entidades y herramientas necesarias para almacenar y recuperar información.

#### 4. Contenedor Docker

Incluye la ejecución del proyecto dentro de un contenedor. Actualmente utilizamos un entorno de desarrollo basado en Alpine Linux mediante **devContainer.json**, y más adelante este mismo componente servirá como base para el despliegue en servidor o nube.

---

### Diagrama UML de Componentes
inserte aqui su diagrama :)

[Volver](/README.md)