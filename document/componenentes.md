
### Componentes
---

La arquitectura de **Artia - Aula Creativa** se organiza en torno a una estructura de capas bien definida, separando las responsabilidades y facilitando la modularidad, el mantenimiento y la escalabilidad. Esta estructura se divide en dos grandes capas funcionales principales: **Common** y **AulaCreativa**.

---

#### 1. Capa Common

Esta capa contiene todos los componentes **comunes y transversales** que son necesarios para el funcionamiento general de la aplicación, independientemente de la lógica de negocio específica de la gestión del centro.

* **`crud-repository`:** Interfaz base que define las operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) genéricas que cualquier repositorio de entidad de la aplicación debe implementar.
* **`GlobalExceptionHandler`:** Componente encargado de la **gestión centralizada de excepciones**, asegurando que los errores se manejen de forma consistente y que se devuelvan respuestas uniformes a los clientes (por ejemplo, con códigos de estado HTTP apropiados).
* **`Identificador`:** Un servicio o clase de utilidad que genera o gestiona identificadores **únicos** para las entidades de la aplicación.
* **Otros Utilitarios:** Clases de ayuda, constantes o configuraciones que son utilizadas por múltiples módulos.

---

#### 2. Capa AulaCreativa

Esta es la capa principal que alberga la **lógica de negocio** específica de **Artia - Aula Creativa**. Siguiendo los principios de la **Arquitectura Hexagonal (Ports and Adapters)**, esta capa se estructura en tres subcapas principales, dispuestas de forma concéntrica para mantener el **Dominio** (el corazón de la aplicación) aislado de las preocupaciones externas.

- ##### 2.1. Domain (Núcleo)

    Es el **centro de la aplicación** y contiene la lógica de negocio pura. Define los objetos y reglas que representan el mundo real de la gestión del centro.

    * **Entidades del Negocio:**
        * **`Profesor`**
        * **`Alumno`**
        * **`Taller`**
        * **`Inscripcion`**

- ##### 2.2. Application (Servicios)

    Esta capa orquesta las interacciones y flujos de trabajo del negocio, actuando como la capa de servicios que utiliza los objetos del *Domain*. Contiene los casos de uso (use cases) que manipulan las entidades del dominio.

    * **`Command`:** Objetos que representan una **intención** de modificar el estado de la aplicación (por ejemplo, `CrearTallerCommand`).
    * **`Services`:** Componentes que contienen la **lógica de negocio específica** y coordinan operaciones (por ejemplo, validaciones y acceso a repositorios).
    * **`UseCase`:** Implementaciones concretas que definen las **acciones** que el usuario puede realizar, utilizando los *Services* y los *Command*.

- ##### 2.3. Infrastructure (Adaptadores)

    Esta capa conecta el *Domain* y la *Application* con el **mundo exterior** (bases de datos, frameworks web, sistemas externos). Actúa como los adaptadores de la Arquitectura Hexagonal.

    * **`web`:** Adaptador de entrada (lado izquierdo del hexágono).
        * **`rest-controllers`:** Puntos finales que exponen la funcionalidad de la *Application* a través de la API REST.
        * **`dtos` (Data Transfer Objects):** Objetos utilizados para la **transferencia de datos** entre el cliente y los *Controllers*
    * **`db`:** Adaptador de salida (lado derecho del hexágono).
        * **`mockImpl`:** Implementaciones de **repositorios mock** para pruebas o desarrollo inicial.
        * **`jpa-entities`:** Entidades específicas para la persistencia en la base de datos usando JPA.
    * **`mapper`:** Componentes encargados de transformar datos entre los objetos del *Domain* (lógica de negocio) y los objetos de *Infraestructura* (`dtos`, `jpa-entities`).
    * **`config`:** Archivos y clases de configuración para frameworks, base de datos, seguridad, etc.

---

#### Diagrama UML de Componentes
inserte aqui su diagrama :)

```mermaid
%% Diagrama de Componentes - Artia (Aula Creativa)

graph TD
    %% ----------------------------------------------------
    %% Capa Common
    %% ----------------------------------------------------
    subgraph Common [Capa Common - Componentes Transversales]
        C_CRUD[CrudRepositoryBase<T, ID>]
        C_EXCEP[GlobalExceptionHandler]
        C_ID[Identificador/IdGenerator]
        C_UTIL[Otros Utilitarios]
    end

    %% ----------------------------------------------------
    %% Capa AulaCreativa (Hexagonal)
    %% ----------------------------------------------------
    subgraph AulaCreativa [Capa AulaCreativa - Arquitectura Hexagonal]

        %% 2.3. Infrastructure (Adaptadores)
        subgraph Infrastructure [2.3 Infrastructure - Adaptadores]
            Inf_Web[web (Rest Controllers, DTOs)]
            Inf_DB[db (mockImpl, Jpa Entities)]
            Inf_Map[mapper (Mappers)]
            Inf_Conf[config (Configuraciones)]
        end

        %% 2.2. Application (Servicios)
        subgraph Application [2.2 Application - Casos de Uso]
            App_UC[UseCase]
            App_SVC[Services]
            App_CMD[Command]
        end

        %% 2.1. Domain (Núcleo)
        subgraph Domain [2.1 Domain - Modelo de Negocio]
            Dom_Entities[Entidades: Profesor, Alumno, Taller, Inscripcion]
            Dom_Ports[Repository Ports (Interfaces)]
        end

    end

    %% ----------------------------------------------------
    %% Dependencias
    %% ----------------------------------------------------

    %% Flujo Hexagonal: Infra -> App -> Domain
    Inf_Web --> App_UC
    App_UC --> App_SVC
    App_SVC --> Dom_Entities
    App_SVC --> Dom_Ports

    %% Implementación de Puertos (DB implementa Interfaces de Domain)
    Inf_DB -->|implementa| Dom_Ports

    %% Mapeo entre capas
    Inf_Web --> Inf_Map
    Inf_Map --> Dom_Entities

    %% Dependencias de Common
    Inf_DB -->|extiende| C_CRUD
    Inf_Web -->|usa| C_EXCEP
    Dom_Entities -->|usa| C_ID
    App_UC -->|usa| C_UTIL

    %% Orden de los Subgraphs
    style Domain fill:#cceeff,stroke:#6699ff
    style Application fill:#ffcc99,stroke:#ff9933
    style Infrastructure fill:#ffffcc,stroke:#ffcc00
    style Common fill:#dddddd,stroke:#aaaaaa
```
```plantUml
@startuml Artia - Aula Creativa Component Diagram

skinparam componentStyle uml2

package "Artia - Aula Creativa" {

    package "Capa Common" as Common {
        [CrudRepositoryBase<T, ID>] as C_CRUD
        [GlobalExceptionHandler] as C_EXCEP
        [Identificador/IdGenerator] as C_ID
    }

    package "Capa AulaCreativa (Hexagonal)" as AulaCreativa {

        package "2.1 Domain (Núcleo)" as Domain {
            component "Entidades del Negocio" as Dom_Entities
            interface "Repository Ports" as Dom_Ports
            Dom_Entities -[hidden] Dom_Ports
        }

        package "2.2 Application (Servicios)" as Application {
            component "Use Case" as App_UC
            component "Services" as App_SVC
            component "Command" as App_CMD
            App_UC --> App_SVC
            App_UC --> App_CMD
        }

        package "2.3 Infrastructure (Adaptadores)" as Infrastructure {
            component "Web (Controllers, DTOs)" as Inf_Web
            component "DB (Jpa Entities, MockImpl)" as Inf_DB
            component "Mapper" as Inf_Map
            component "Config" as Inf_Conf
            Inf_Web --> Inf_Map
            Inf_DB --> Inf_Map
            Inf_Conf -[hidden]-> Inf_DB
        }

        Inf_Web --> App_UC : Usa
        Application --> Domain : Lógica de Negocio

        App_SVC --> Dom_Ports : Usa Interfaz
        Inf_DB -up-> Dom_Ports : Implementa

        Inf_Map ..> Dom_Entities : Mapea

    }
    
    ' Conexiones a Common
    Inf_DB -up-> C_CRUD : Extiende
    Inf_Web -up-> C_EXCEP : Usa
    Dom_Entities -up-> C_ID : Usa para generar IDs
}

@enduml

```

[Volver](/README.md)