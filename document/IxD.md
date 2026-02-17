### Diseño de Interacción (IxD) y Comportamiento del Sistema

---

El diseño de la interacción se ha definido para garantizar una comunicación fluida y predecible entre el usuario y la aplicación. Se prioriza la claridad en la ejecución de tareas y la visibilidad del estado del sistema en todo momento.

---

#### 1. Estrategia de Interacción
La interfaz implementa patrones de diseño estándar para asegurar que la curva de aprendizaje sea mínima.

* **Jerarquía Visual y Affordance:** Los elementos interactivos (botones, enlaces) están diseñados con estilos visuales claros que indican su función (acciones primarias vs. secundarias). Los botones de acción crítica, como "Editar" o "Eliminar", siguen convenciones de color y ubicación estándar (ej. Rojo para acciones destructivas/peligrosas).
* **Diseño de Formularios:** La entrada de datos se facilita mediante etiquetas descriptivas (`Labels`) y marcadores de posición (`Placeholders`) que guían al usuario sobre el formato esperado, reduciendo la ambigüedad durante la carga de información.

---

#### 2. Seguridad y Prevención de Errores
Se han implementado mecanismos de defensa para evitar acciones no deseadas o irreversibles por parte del usuario (Heurística de Prevención de Errores).

* **Confirmación de Acciones Destructivas:** Para operaciones críticas como la eliminación de registros (Alumnos/Profesores), el sistema interrumpe el flujo mediante un **diálogo modal de confirmación**. Esto obliga al usuario a verificar su intención antes de ejecutar el borrado permanente, evitando errores accidentales.

---

#### 3. Retroalimentación del Sistema (System Feedback)
La aplicación mantiene al usuario informado sobre lo que está ocurriendo en cada paso del proceso:

* **Respuesta Inmediata:** Tras completar una operación (CRUD), el sistema proporciona feedback visual instantáneo.
    * *Éxito:* Redirección automática al listado actualizado o vista de detalle.
    * *Error:* Visualización de mensajes de validación claros en el propio formulario si los datos son incorrectos.
* **Transiciones de Estado:** El usuario nunca se queda "a ciegas"; el sistema confirma explícitamente que la acción solicitada (guardar, borrar, actualizar) ha sido procesada correctamente por el servidor.

---

#### 4. Objetivo: Confianza del Usuario
La combinación de validaciones claras, confirmaciones de seguridad y respuestas rápidas tiene como objetivo principal reducir la **carga cognitiva** y aumentar la **confianza** del usuario al operar el sistema, minimizando la frustración derivada de errores operativos.

---

[Volver](/README.md)