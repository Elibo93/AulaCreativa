
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

[![](https://img.plantuml.biz/plantuml/svg/XPNDQjj04CVlXRx3u4jTY5tgta8mSIoJg90qn75R2C5CfB6xMD8kk-lWKFnYlVR5EgjlsR8gNIJjR_xpjJkwD1QrtSOHJBGL20EOR2E4gIQqufKVPAnaGea5J-1QO_p-NNQRZKWKyWS82cHkto82rXeLaC9WWsk2Ngju3tuN8F1LmbDKgUDO9Zr0apzcCEINdrZIAmmS_h3m7aX98wpKRnUFP-1xuynmwTRgPa_NaNp1QBOBI5aXanjCmeZqSqRFVavdzmtS3paliH81Xb9_yiDhIaWZ-yaj_59zVpeLbtHPqFuDxN0j4um-fZ4s5XlrQ0YDXYEOA1Ln92vkwCz9luf0I9FBrDOQXN9NsI4EY6l9EHSso-cjrq5dJiYK-Fpxj0DV69gYgU6B8pht2HV3uId1_3CC1kCMaNr7YRxmjbXf96FrDh1RJT2VXAYiQnxbXJeakehbNK7_ApTmndl02Z9dS2k3ZH-hgDHQUbST0hUe5EcIvTVErYGhiIvXzzf1_w0Nw3DZjOnu1tDitkEtAiSbhnzQ5wffPTjZporBeYNYpF1_HERdwPS8-GGzj_hRrrzETFGpU396mVlzxk-V82AP9PX_xEgTwrc88Ha8AO8xMai-B8NnikZeeO2enaerKaghUwdjaKbThigudJ_QlFLwjno7wYax22cN9N-eubgoLTbovXZEmMrLYhaUsEQOMmV3uRYPmJdmPy9JR75-QrXZ0jPx-O4dTq8x7aciMqpqOh7CF0twOFPMEHJBRf2pqzcEWqn2geDLyNFMT-J28BZ_4wpJaQtvfs3g0PQjk6Gz_cVz0m00)](https://editor.plantuml.com/uml/XPNDQjj04CVlXRx3u4jTY5tgta8mSIoJg90qn75R2C5CfB6xMD8kk-lWKFnYlVR5EgjlsR8gNIJjR_xpjJkwD1QrtSOHJBGL20EOR2E4gIQqufKVPAnaGea5J-1QO_p-NNQRZKWKyWS82cHkto82rXeLaC9WWsk2Ngju3tuN8F1LmbDKgUDO9Zr0apzcCEINdrZIAmmS_h3m7aX98wpKRnUFP-1xuynmwTRgPa_NaNp1QBOBI5aXanjCmeZqSqRFVavdzmtS3paliH81Xb9_yiDhIaWZ-yaj_59zVpeLbtHPqFuDxN0j4um-fZ4s5XlrQ0YDXYEOA1Ln92vkwCz9luf0I9FBrDOQXN9NsI4EY6l9EHSso-cjrq5dJiYK-Fpxj0DV69gYgU6B8pht2HV3uId1_3CC1kCMaNr7YRxmjbXf96FrDh1RJT2VXAYiQnxbXJeakehbNK7_ApTmndl02Z9dS2k3ZH-hgDHQUbST0hUe5EcIvTVErYGhiIvXzzf1_w0Nw3DZjOnu1tDitkEtAiSbhnzQ5wffPTjZporBeYNYpF1_HERdwPS8-GGzj_hRrrzETFGpU396mVlzxk-V82AP9PX_xEgTwrc88Ha8AO8xMai-B8NnikZeeO2enaerKaghUwdjaKbThigudJ_QlFLwjno7wYax22cN9N-eubgoLTbovXZEmMrLYhaUsEQOMmV3uRYPmJdmPy9JR75-QrXZ0jPx-O4dTq8x7aciMqpqOh7CF0twOFPMEHJBRf2pqzcEWqn2geDLyNFMT-J28BZ_4wpJaQtvfs3g0PQjk6Gz_cVz0m00)

[Volver](/README.md)