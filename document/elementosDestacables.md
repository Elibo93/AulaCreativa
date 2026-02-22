### Elementos destacables del desarrollo
---

El desarrollo de **Artia – Aula Creativa** se ha realizado teniendo en cuenta no solo la funcionalidad final de la aplicación, sino también la calidad del diseño, la mantenibilidad del código y la posibilidad de evolución futura del sistema. A continuación, se describen los principales aspectos técnicos y conceptuales que caracterizan el desarrollo de la aplicación y la diferencian de soluciones más tradicionales.

#### Arquitectura modular y desacoplada
La aplicación se ha diseñado siguiendo una arquitectura claramente estructurada, basada en la separación de responsabilidades. Se distinguen dos grandes bloques: una capa común reutilizable y el módulo específico de Aula Creativa, organizado internamente según el enfoque de arquitectura hexagonal.

Esta organización permite:
- Aislar la lógica de negocio del resto de capas.
- Reducir el acoplamiento entre componentes.
- Facilitar el mantenimiento y la evolución del código.
- Permitir la sustitución de elementos de infraestructura sin afectar al dominio.

#### Uso de una arquitectura hexagonal
El núcleo de la aplicación se apoya en un modelo de arquitectura hexagonal, donde el dominio se mantiene independiente de detalles técnicos como la base de datos o la capa web. Las reglas de negocio se concentran en el dominio y se accede a ellas a través de casos de uso definidos en la capa de aplicación.

Este enfoque aporta:
- Mayor claridad en el flujo de la aplicación.
- Facilidad para realizar pruebas.
- Un diseño más alineado con principios de ingeniería de software.

#### Modelo de dominio orientado al negocio
Las entidades principales del sistema (Alumno, Profesor, Taller e Inscripción) han sido diseñadas como parte de un modelo de dominio coherente, reflejando la realidad del funcionamiento del centro educativo.

Este modelo permite:
- Representar de forma clara las relaciones entre los distintos actores.
- Aplicar reglas de negocio directamente sobre los objetos del dominio.
- Evitar que la lógica de negocio dependa de la capa de persistencia.

#### Gestión dinámica y motivadora del alumnado
Uno de los aspectos más innovadores de la aplicación es su enfoque hacia una experiencia educativa más dinámica. El sistema no se limita a registrar información, sino que está preparado para incorporar elementos que fomenten la motivación del alumnado, como:
- Seguimiento del progreso individual.
- Sistemas de reconocimiento y ranking basados en rendimiento o esfuerzo.
- Visión clara de objetivos y evolución dentro de los talleres.

Este planteamiento busca romper con modelos de enseñanza excesivamente pasivos y aproximar la experiencia educativa a formatos más atractivos y participativos.

#### Automatización de procesos clave
La aplicación automatiza tareas que tradicionalmente se realizan de forma manual, como la gestión de inscripciones, el control de asistencias o el seguimiento de la actividad de los talleres. Esto reduce errores humanos, optimiza tiempos de gestión y mejora la fiabilidad de la información almacenada.

#### Escalabilidad y evolución futura
El diseño del sistema permite la incorporación de nuevas funcionalidades sin necesidad de grandes refactorizaciones. Gracias a su arquitectura modular, Artia puede ampliarse con nuevos módulos como sistemas de evaluación, gestión de materiales, métricas de rendimiento o integración con servicios externos.

Esta capacidad de evolución garantiza que la aplicación pueda adaptarse a nuevas necesidades del centro a medio y largo plazo.

### Conclusión

Los elementos destacables del desarrollo de **Artia – Aula Creativa** reflejan una combinación de buenas prácticas de ingeniería de software, una arquitectura bien definida y una visión innovadora del proceso educativo. La aplicación no solo resuelve problemas de gestión, sino que sienta las bases para una plataforma moderna, escalable y orientada a mejorar tanto la organización del centro como la motivación y participación del alumnado.


[Volver](/README.md)