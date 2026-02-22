# Manual de usuario
---

> **Versión:** 1.0 · **Aplicación:** Artia - Aula Creativa · **Fecha:** Febrero 2026

---

## Puesta en Marcha de la Aplicación

En esta sección se explica cómo arrancar la aplicación desde cero. La aplicación y su base de datos funcionan como **contenedores Docker independientes**, lo que significa que no es necesario instalar nada más allá de Docker en el equipo.

### Requisitos previos

Antes de comenzar, asegúrese de tener instalado en su equipo:

| Requisito | ¿Para qué sirve? |
|---|---|
| **Docker Desktop** | Motor que ejecuta los contenedores de la aplicación |
| **Docker Compose** | Herramienta que orquesta y lanza todos los contenedores a la vez |

> **Nota:** Docker Compose viene incluido con Docker Desktop en su versión para Windows y Mac. Puede descargarlo desde [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop).

---

### Paso 1 — Abrir una terminal

Abra una terminal (símbolo del sistema, PowerShell o similar) y navegue hasta la **carpeta raíz del proyecto**, es decir, la carpeta donde se encuentra el archivo `docker-compose.yml`.

```bash
cd ruta/a/la/carpeta/del/proyecto
```

---

### Paso 2 — Lanzar la aplicación

Ejecute el siguiente comando para construir y arrancar todos los contenedores (aplicación + base de datos):

```bash
docker compose up
```

> **¿Qué ocurre en este momento?**
> - Docker descargará las imágenes necesarias (solo la primera vez).
> - Se iniciará el contenedor de la **base de datos**.
> - Se iniciará el contenedor de la **aplicación web**.
>
> Este proceso puede tardar unos minutos la primera vez. Cuando vea en la terminal un mensaje similar a `Started AulaCreativaApplication`, la aplicación estará lista.

Si desea lanzar la aplicación en **segundo plano** (sin mantener la terminal ocupada), use:

```bash
docker compose up -d
```

---

### Paso 3 — Acceder a la aplicación

Una vez que la aplicación esté en marcha, abra su **navegador web** (Chrome, Firefox, Edge, etc.) e introduzca la siguiente dirección en la barra de navegación:

```
https://localhost:8443/web/home
```

> **¡IMPORTANTE! Mensaje de Advertencia de Privacidad**
> Al acceder por primera vez mediante `https`, es muy probable que su navegador muestre una advertencia de seguridad indicando que **"La conexión no es privada"** o **"Riesgo potencial de seguridad"**.
>
> **¿Por qué ocurre esto?** Porque la aplicación utiliza un **certificado SSL autofirmado** para el entorno de desarrollo local.
>
> **¿Qué debe hacer?** Es seguro continuar, ya que somos nosotros quienes alojamos la aplicación:
> * **En Chrome/Edge:** Haga clic en **"Configuración avanzada"** (o "Avanzado") y luego en el enlace inferior **"Continuar a localhost (no seguro)"**.
> * **En Firefox:** Haga clic en **"Avanzado"** y luego en **"Aceptar el riesgo y continuar"**.

Si todo ha ido correctamente, tras aceptar la excepción, verá la **pantalla de inicio de Artia - Aula Creativa**.

---

### Paso 4 — Detener la aplicación

Cuando desee apagar la aplicación, ejecute el siguiente comando en la misma carpeta del proyecto:

```bash
docker compose down
```

Esto detendrá y eliminará los contenedores de forma limpia. Los datos almacenados en la base de datos **se conservarán** para la próxima vez que arranque la aplicación.

---

## Guía de Uso

#### 1. Introducción y Acceso

Este manual describe los pasos necesarios para operar la aplicación **Artia - Aula Creativa**. El sistema permite la gestión integral de alumnos, profesores y talleres a través de una interfaz web intuitiva.

Para acceder a la plataforma, una vez que la aplicación esté en marcha ([consulte la sección anterior](#-puesta-en-marcha-de-la-aplicación)), abra su navegador e introduzca:

```
https://localhost:8443/web/home
```

Accederá directamente al **Panel de Control**, sin necesidad de inicio de sesión (pendiente de implementar).

> **Nota:** La aplicación está disponible en cuatro idiomas: 🇪🇸 Español, 🇬🇧 Inglés, 🇲🇦 Árabe, 🇮🇹 Italiano. Puede cambiar el idioma en cualquier momento desde los botones de banderas situados en la esquina superior derecha.

---

#### 2. Panel de Control (Pantalla de Inicio)

Nada más acceder a la aplicación, verá el **Panel de Control**, que es el punto central de navegación.

Desde aquí encontrará:

- **Estadísticas rápidas:** tarjetas que muestran el número total de alumnos y talleres registrados.
- **Accesos directos:** cuatro tarjetas que le llevan directamente a cada sección de la aplicación.
- **Menú desplegable:** en la cabecera superior, un botón con el avatar **«A»** despliega un menú de navegación con acceso a todas las secciones.

| Sección | Descripción |
|---|---|
| 🎓 **Alumnos** | Gestión completa del listado de estudiantes |
| 💼 **Profesores** | Gestión del claustro de docentes |
| 🎨 **Talleres** | Gestión de la oferta de cursos y talleres |
| ✅ **Inscripciones** | Gestión de las matriculaciones de alumnos en talleres |

---

#### 3. Gestión de Alumnos

Acceda pulsando la tarjeta **«Alumnos»** o a través del menú desplegable.

##### 3.1. Ver el listado de alumnos

Al entrar en la sección, se muestra una tabla con todos los alumnos registrados, con los siguientes datos: **ID, Nombre, Apellido, DNI, Email y Teléfono**.

Si no hay alumnos registrados aún, el sistema mostrará un mensaje indicándolo.

##### 3.2. Registrar un nuevo alumno

1. Pulse el botón **«+ Nuevo Alumno»** (parte superior derecha de la tabla).
2. Rellene el formulario con los datos del alumno:
   - **DNI** *(obligatorio)*
   - **Nombre** *(obligatorio)*
   - **Apellidos** *(obligatorio)*
   - Email, Teléfono, Fecha de Nacimiento y Dirección *(opcionales)*
3. Pulse **«Guardar»** para confirmar el registro. Pulse **«Cancelar»** para descartarlo.

##### 3.3. Editar un alumno

1. En la tabla de alumnos, localice el alumno que desea modificar.
2. Pulse el **icono de lápiz** (✏️) en la columna de acciones.
3. Se abrirá una ventana emergente donde podrá actualizar el **email, teléfono y dirección**.
4. Pulse **«Guardar»** para aplicar los cambios.

##### 3.4. Eliminar un alumno

1. En la fila del alumno, pulse el **icono de papelera** (🗑️).
2. El sistema le pedirá confirmación antes de eliminar el registro.
3. Confirme para proceder con el borrado.

> **Atención:** La eliminación de un alumno es permanente y no se puede deshacer.

##### 3.5. Exportar el listado a PDF

Pulse el botón **«Exportar PDF»** para generar y descargar un documento PDF con el listado completo de alumnos.

---

#### 4. Gestión de Profesores

Acceda pulsando la tarjeta **«Profesores»** o a través del menú desplegable. El funcionamiento es análogo al de la sección de Alumnos.

##### 4.1. Ver el listado de profesores

Se muestra una tabla con todos los docentes registrados: **ID, Nombre, Apellido, DNI, Email y Teléfono**.

##### 4.2. Registrar un nuevo profesor

1. Pulse **«+ Nuevo Profesor»**.
2. Rellene el formulario con los datos del docente (campos similares a los de alumnos).
3. Pulse **«Guardar»**.

##### 4.3. Editar / Eliminar un profesor

El proceso es idéntico al descrito para los alumnos: use el **icono de lápiz** para editar y el **icono de papelera** para eliminar, con confirmación previa.

##### 4.4. Exportar el listado a PDF

Pulse el botón **«Exportar PDF»** para generar el documento con el listado de profesores.

---

#### 5. Gestión de Talleres

Acceda pulsando la tarjeta **«Talleres»** o a través del menú desplegable.

##### 5.1. Ver el listado de talleres

Se muestra una tabla con todos los talleres disponibles, incluyendo información como el nombre, descripción, el profesor responsable y el cupo máximo de alumnos.

##### 5.2. Crear un nuevo taller

1. Pulse **«+ Nuevo Taller»**.
2. Rellene el formulario:
   - **Nombre** del taller *(obligatorio)*
   - **Descripción** *(opcional)*
   - **Profesor titular:** seleccione el docente responsable de la lista.
   - **Cupo máximo:** número límite de alumnos que pueden inscribirse.
3. Pulse **«Guardar»**. El taller quedará disponible inmediatamente.

##### 5.3. Editar / Eliminar un taller

Use los iconos de la columna de acciones: **lápiz** para editar y **papelera** para eliminar (con confirmación previa).

##### 5.4. Exportar el listado a PDF

Pulse **«Exportar PDF»** para generar el documento con la oferta de talleres.

---

#### 6. Gestión de Inscripciones

Acceda pulsando la tarjeta **«Inscripciones»** o a través del menú desplegable.

Las inscripciones representan la **relación entre un alumno y un taller**, es decir, la matriculación de un estudiante en un curso concreto.

##### 6.1. Ver el listado de inscripciones

Se muestra una tabla con todas las matriculaciones activas, mostrando el alumno, el taller en el que está inscrito y la fecha de inscripción.

##### 6.2. Crear una nueva inscripción

1. Pulse **«+ Nueva Inscripción»**.
2. Seleccione el **alumno** y el **taller** en los menús desplegables del formulario.
3. Pulse **«Guardar»**.

> **Nota:** Solo se podrá inscribir a un alumno en un taller si este no ha alcanzado su **cupo máximo** de participantes.

##### 6.3. Eliminar una inscripción

Use el **icono de papelera** en la fila correspondiente y confirme la operación.

##### 6.4. Exportar el listado a PDF

Pulse **«Exportar PDF»** para generar el documento con el listado de inscripciones.

---

#### 7. Solución de Problemas Frecuentes

| Problema | Solución |
|---|---|
| **La página no carga** | Compruebe que los contenedores están activos con `docker compose ps`. Si están parados, ejecúte `docker compose up`. |
| **Error al guardar un alumno/profesor** | Verifique que el campo **DNI** no está duplicado y que el **email** tiene un formato válido. |
| **No se puede crear una inscripción** | Compruebe que el taller seleccionado no ha alcanzado su cupo máximo de alumnos. |
| **Edición de datos incorrectos** | Utilice el icono de edición (✏️) situado junto a cada registro en la tabla correspondiente.

---

[Volver](/README.md)