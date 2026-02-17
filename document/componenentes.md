### Componentes

---

La arquitectura de **Artia - Aula Creativa** se organiza siguiendo estrictamente los principios de **Clean Architecture**, estructurando el sistema en círculos concéntricos donde las dependencias solo apuntan hacia adentro. Esta disposición garantiza la independencia de frameworks, la testabilidad y la separación de preocupaciones.

La estructura del código base se divide en dos grandes bloques funcionales: **Common** (Núcleo Compartido) y **AulaCreativa** (Módulo de Negocio).

---

#### 1. Capa Common

Esta capa encapsula los componentes **transversales y agnósticos al dominio** que son reutilizados por todo el sistema, evitando la duplicidad de código (DRY) y estandarizando el comportamiento base.

* **`crud-repository`:** Definición de contratos genéricos para operaciones de persistencia, desacoplando la lógica de acceso a datos de la implementación específica.
* **`GlobalExceptionHandler`:** Componente de **Infraestructura** encargado de interceptar excepciones en toda la aplicación, traduciendo errores internos en respuestas HTTP estandarizadas y seguras para el cliente.
* **`Identificador`:** Value Object genérico y utilidades para la generación de claves primarias (UUIDs) consistentes en todas las entidades.
* **Utilidades Transversales:** Librerías internas para validaciones comunes, formateo de fechas y constantes globales.

---

#### 2. Capa AulaCreativa (Vertical Slice)

Este módulo contiene la **lógica de negocio** específica de la gestión educativa. Siguiendo la *Dependency Rule* de Clean Architecture, se subdivide en tres capas principales, desde el núcleo más abstracto hasta los detalles de implementación externos.

##### 2.1. Domain (Entidades - Reglas de negocio)

Es el círculo más interno y estable de la arquitectura. Contiene los objetos de negocio puros y las reglas de empresa que no dependen de ninguna tecnología externa.

* **Entidades del Negocio:**
* **`Profesor`**: Lógica asociada al docente y sus especialidades.
* **`Alumno`**: Gestión del perfil del estudiante y su progreso.
* **`Taller`**: Configuración de cursos y materias.
* **`Inscripcion`**: Reglas de matriculación y disponibilidad de plazas.



##### 2.2. Application (Casos de Usos - Servicios)

Esta capa orquesta el flujo de datos hacia y desde las Entidades. Contiene la lógica específica de la aplicación, implementando los casos de uso que definen qué puede hacer el sistema.

* **`UseCases`:** Clases que encapsulan una acción de negocio concreta (ej. `MatricularAlumnoUseCase`). Coordinan la obtención de datos y la ejecución de reglas de dominio.
* **`Services`:** Actua como una Fachada (Facade). Su responsabilidad principal es orquestar la ejecución de tareas, pero no debe contener reglas de negocio complejas.
* **`Commands`:** DTOs de entrada que encapsulan la intención del usuario y los datos necesarios para ejecutar una operación.

##### 2.3. Infrastructure (Interface Adapters & Frameworks)

Es la capa más externa, encargada de conectar los Casos de Uso con herramientas externas (Base de Datos, Web, UI). Aquí residen los detalles de implementación "sucios".

* **`Web Adapter` (Controladores):**
  * **`rest-controllers`:** Adaptadores que convierten peticiones HTTP en llamadas a los Casos de Uso.
* **`dtos` (Data Transfer Objects):** Objetos de transporte optimizados para la vista, desacoplando la API de las Entidades internas.


* **`Persistence Adapter/db` (Base de Datos):**
* **`jpa-entities`:** Modelos específicos para el ORM (Hibernate) con anotaciones de base de datos.
* **`repositories`:** Implementación concreta de los *Ports* definidos en la capa de Aplicación.
* **`mapper`:** Componentes traductores que convierten entre `Domain Entities` y `JPA Entities`, manteniendo limpia la capa de dominio.


* **`Config`:** Configuración de Spring Boot, seguridad y inyección de dependencias.

---

#### Diagrama UML de Componentes

[![](https://img.plantuml.biz/plantuml/svg/XPNDQjj04CVlXRx3u4jTY5tgta8mSIoJg90qn75R2C5CfB6xMD8kk-lWKFnYlVR5EgjlsR8gNIJjR_xpjJkwD1QrtSOHJBGL20EOR2E4gIQqufKVPAnaGea5J-1QO_p-NNQRZKWKyWS82cHkto82rXeLaC9WWsk2Ngju3tuN8F1LmbDKgUDO9Zr0apzcCEINdrZIAmmS_h3m7aX98wpKRnUFP-1xuynmwTRgPa_NaNp1QBOBI5aXanjCmeZqSqRFVavdzmtS3paliH81Xb9_yiDhIaWZ-yaj_59zVpeLbtHPqFuDxN0j4um-fZ4s5XlrQ0YDXYEOA1Ln92vkwCz9luf0I9FBrDOQXN9NsI4EY6l9EHSso-cjrq5dJiYK-Fpxj0DV69gYgU6B8pht2HV3uId1_3CC1kCMaNr7YRxmjbXf96FrDh1RJT2VXAYiQnxbXJeakehbNK7_ApTmndl02Z9dS2k3ZH-hgDHQUbST0hUe5EcIvTVErYGhiIvXzzf1_w0Nw3DZjOnu1tDitkEtAiSbhnzQ5wffPTjZporBeYNYpF1_HERdwPS8-GGzj_hRrrzETFGpU396mVlzxk-V82AP9PX_xEgTwrc88Ha8AO8xMai-B8NnikZeeO2enaerKaghUwdjaKbThigudJ_QlFLwjno7wYax22cN9N-eubgoLTbovXZEmMrLYhaUsEQOMmV3uRYPmJdmPy9JR75-QrXZ0jPx-O4dTq8x7aciMqpqOh7CF0twOFPMEHJBRf2pqzcEWqn2geDLyNFMT-J28BZ_4wpJaQtvfs3g0PQjk6Gz_cVz0m00)](https://editor.plantuml.com/uml/XPNDQjj04CVlXRx3u4jTY5tgta8mSIoJg90qn75R2C5CfB6xMD8kk-lWKFnYlVR5EgjlsR8gNIJjR_xpjJkwD1QrtSOHJBGL20EOR2E4gIQqufKVPAnaGea5J-1QO_p-NNQRZKWKyWS82cHkto82rXeLaC9WWsk2Ngju3tuN8F1LmbDKgUDO9Zr0apzcCEINdrZIAmmS_h3m7aX98wpKRnUFP-1xuynmwTRgPa_NaNp1QBOBI5aXanjCmeZqSqRFVavdzmtS3paliH81Xb9_yiDhIaWZ-yaj_59zVpeLbtHPqFuDxN0j4um-fZ4s5XlrQ0YDXYEOA1Ln92vkwCz9luf0I9FBrDOQXN9NsI4EY6l9EHSso-cjrq5dJiYK-Fpxj0DV69gYgU6B8pht2HV3uId1_3CC1kCMaNr7YRxmjbXf96FrDh1RJT2VXAYiQnxbXJeakehbNK7_ApTmndl02Z9dS2k3ZH-hgDHQUbST0hUe5EcIvTVErYGhiIvXzzf1_w0Nw3DZjOnu1tDitkEtAiSbhnzQ5wffPTjZporBeYNYpF1_HERdwPS8-GGzj_hRrrzETFGpU396mVlzxk-V82AP9PX_xEgTwrc88Ha8AO8xMai-B8NnikZeeO2enaerKaghUwdjaKbThigudJ_QlFLwjno7wYax22cN9N-eubgoLTbovXZEmMrLYhaUsEQOMmV3uRYPmJdmPy9JR75-QrXZ0jPx-O4dTq8x7aciMqpqOh7CF0twOFPMEHJBRf2pqzcEWqn2geDLyNFMT-J28BZ_4wpJaQtvfs3g0PQjk6Gz_cVz0m00)

---

[Volver](/README.md)