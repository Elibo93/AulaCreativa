### Plan de pruebas
---

El objetivo de este plan de pruebas es definir las estrategias, tipos de pruebas y metodología empleada para verificar el correcto funcionamiento del sistema AulaCreativa.
El proyecto se desarrolla utilizando Spring Boot, Spring Data JPA, una base de datos H2 en memoria, y pruebas automáticas con JUnit 5.

El plan incluye pruebas unitarias y pruebas de integración, asegurando la corrección tanto de los componentes individuales como del comportamiento completo del sistema.

#### Objetivos de la pruebas

- Validar que la **lógica del dominio** se comporte según lo esperado.
  
- Comprobar que los repositorios **JPA** gestionan correctamente la persistencia.

- Verificar que los datos se **guardan, actualizan, eliminan y consultan** correctamente en la base de datos.

- Comprobar que los mapeos entre **entidades, dominio y DTOs** son correctos.

- Garantizar que el sistema funciona correctamente en conjunto mediante **pruebas de integración**.

#### Tipos de pruebas

##### Pruebas unitarias
Se centrarán en componentes individuales, aislando la lógica del **dominio** o de utilidades internas.

Como se probarán:
- Se instancian objetos de dominio o entidades.

- Se ejecuta el método a probar (por ejemplo, toEntity, toDomain).

- Se comprueba que los valores coinciden, no hay nulls inesperados, etc.

Herramienta: **JUnit 5**

##### Pruebas de integración

Validar que las distintas partes del sistema funcionan bien juntas.

Verificarán la correcta interacción entre:

- Repositorios **JPA**:que puedan guardar,buscar,actualizar y borrar entidades.
- La base de datos **H2** en memoria:que reciba los datos correctamente y responda como una BBDD real.
- La capa de **persistencia**completa:que el proceso de convertir objetos a entidades,guardarlos y recuperarlos funcione sin errores.

Como se probarán:
  Se usa :
  **@DataJpaTest** y la BD **H2** para:

  ###### Pueba de creación (create)
  Comprobar que una entidad se guarda correctamente.
  Validar:
  - El **ID** generado.
  - Los datos coinciden con los del objeto de entrada.
  - Los campos obligatorios no son nulos.

###### Pueba de lectura(findAll, findById, findByNomre...)

- Que se recuperen **registros** existentes.
- Que los datos coincidan.
- Que las **busquedas** personalizadas funciones.

###### Prueba de actualicación (update)

- Que los cambios en una entidad **persisten**.
- Que solo se cambia lo esperado.
- Que el **ID** permanece igual.
- Que solo se cambien los registros permitidos.

###### Pueba de eliminación (delete)

- Que al **eliminar** un registro,no existe más en la BD.




[Volver](/README.md)