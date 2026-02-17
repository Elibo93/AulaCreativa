### Estrategia de Implantación y Puesta en Producción

---

Este apartado define la metodología y las herramientas seleccionadas para garantizar que el paso del código desde el entorno local hasta el entorno productivo sea fluido, reproducible y libre de errores. La estrategia se basa en la **inmutabilidad de la infraestructura** y la **estandarización de entornos**.

---

#### Contenedorización (Docker)

La arquitectura de despliegue de **AulaCreativa** se fundamenta en el uso de contenedores Docker. Esto permite empaquetar la aplicación junto con su entorno de ejecución, librerías y configuraciones en una unidad desplegable autocontenida.

**Justificación técnica:**

* **Paridad de Entornos:** Garantiza el principio de *"Build once, run anywhere"*. El mismo contenedor que se prueba en local es el que se despliega en producción, eliminando discrepancias de sistema operativo.
* **Aislamiento:** La aplicación corre en su propio espacio de usuario, sin conflictos con otras aplicaciones del servidor.
* **Escalabilidad:** Facilita el despliegue horizontal; si la carga aumenta, se pueden levantar réplicas idénticas del contenedor en segundos.

---

#### Estandarización del Desarrollo (DevContainers)

Para mitigar el clásico problema de *"en mi máquina funciona"*, se ha implementado la especificación de **Development Containers**. Al abrir el proyecto en VS Code, este detecta la configuración y levanta un entorno Docker completo con las herramientas exactas que necesita el proyecto.

**Beneficios en la implantación:**

* **Determinismo:** Todos los desarrolladores (y el servidor de CI/CD) utilizan exactamente la misma versión del JDK y Maven, definida como código (`Dockerfile`).
* **Onboarding Inmediato:** No es necesario instalar ni configurar Java en la máquina host; el entorno está listo para compilar y desplegar desde el primer minuto.

---

#### Gestión del Ciclo de Vida (Java + Maven)

El proyecto utiliza **Apache Maven** no solo para la gestión de dependencias, sino como herramienta de orquestación del ciclo de vida de la construcción (*Build Lifecycle*).

**Rol en la puesta en producción:**

* **Empaquetado:** Maven se encarga de generar el artefacto final (Fat JAR) en la carpeta `target/`. Este archivo `.jar` contiene todas las dependencias necesarias para ejecutarse de forma autónoma (`java -jar app.jar`).
* **Wrapper (`mvnw`):** Se incluye el Maven Wrapper para asegurar que el proyecto se construya siempre con la versión correcta de Maven, independientemente de la que esté instalada en el sistema operativo del servidor.

---

#### Entorno de Construcción (VS Code + Extensiones)

Visual Studio Code actúa como el orquestador del entorno de desarrollo y despliegue. Su elección no es meramente por preferencias de edición, sino por su integración nativa con el ecosistema de contenedores.

**Extensiones críticas para el despliegue:**

* **Maven for Java:** Permite ejecutar los *goals* de ciclo de vida (`clean`, `install`, `package`) de forma visual, asegurando que el artefacto generado es válido para producción.
* **Dev Containers:** Es el puente que conecta el editor con el motor de Docker, permitiendo desarrollar *dentro* del contenedor que simula el entorno productivo.

---

#### Estrategia de Versionado (GitFlow)

Para asegurar un despliegue ordenado y minimizar riesgos en producción, se utiliza **GitFlow**. Esta metodología de ramificación permite separar claramente el desarrollo de nuevas funcionalidades de la estabilidad del producto final.

**Estructura de Ramas:**

| Rama | Propósito | Política de Despliegue |
| --- | --- | --- |
| **`main`** | **Entorno de Producción.** Contiene estrictamente código estable, probado y listo para el usuario final. | Solo recibe cambios mediante *Merges* desde ramas de `release` o `hotfix`. Cada commit aquí es una versión etiquetada (v1.0, v1.1). |
| **`develop`** | **Entorno de Integración.** Es la rama donde convergen todas las nuevas funcionalidades. | Aquí se realizan las pruebas de integración. Es el paso previo a preparar una release. |
| **`feature/*`** | **Desarrollo.** Ramas efímeras para nuevas características. | Nacen de `develop` y mueren al integrarse de nuevo en ella. Nunca llegan a producción directamente. |

**Beneficios para la producción:**

* **Estabilidad:** Protege la rama `main` de errores humanos o código incompleto.
* **Trazabilidad:** Permite saber exactamente qué cambios incluye cada versión desplegada.
* **Hotfixes:** Permite corregir errores críticos en producción (`main`) sin tener que desplegar funcionalidades de `develop` que aún no están terminadas.

---

[Volver](/README.md)