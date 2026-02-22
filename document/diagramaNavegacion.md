### Diagrama de Navegación y Flujo de Pantallas

---

El siguiente diagrama ilustra la arquitectura de navegación de la aplicación, destacando la segregación de rutas basada en roles y el flujo de pantallas para las operaciones CRUD.

## Mapa de Navegación por Roles
El sistema implementa un control de acceso estricto. La navegación se bifurca inmediatamente después del Login dependiendo de los privilegios del usuario (`ROLE_ADMIN`, `ROLE_PROFESOR`, `ROLE_ALUMNO`).

```mermaid
graph TD
    %% --- ZONA PÚBLICA ---
    Start((Inicio)) -->|Petición HTTP| Login[Login / Autenticación]
    Login -- Credenciales Inválidas --> ErrorLogin[Mensaje Error] --> Login
    
    %% --- ZONA SEGURA (Spring Security) ---
    Login -- Auth OK --> Router{¿Qué Rol tiene?}

    %% --- CARRIL ADMINISTRADOR ---
    subgraph "Perfil: ADMINISTRADOR"
        Router -- ROLE_ADMIN --> DashAdmin[Dashboard Admin]
        
        DashAdmin --> NavAlu[Gestión Alumnos]
        NavAlu --> ViewListAlu[Vista: Listado Alumnos]
        
        %% Operaciones CRUD Alumnos
        ViewListAlu -->|Btn: Nuevo| ViewFormNew[Vista: Alta Alumno]
        ViewListAlu -->|Btn: Editar| ViewFormEdit[Vista: Edición Alumno]
        ViewListAlu -->|Btn: Eliminar| ModalDel[Modal: Confirmación]
        
        ViewFormNew -- Guardar --> DB_Save[(Persistencia)]
        ViewFormEdit -- Actualizar --> DB_Update[(Persistencia)]
        ModalDel -- Confirmar --> DB_Delete[(Persistencia)]
        
        %% Retorno
        DB_Save -->|Redirect| ViewListAlu
        DB_Update -->|Redirect| ViewListAlu
        DB_Delete -->|Redirect| ViewListAlu
        
        DashAdmin --> NavProf[Gestión Profesores]
        DashAdmin --> NavTaller[Gestión Talleres]
    end

    %% --- CARRIL PROFESOR ---
    subgraph "Perfil: PROFESOR"
        Router -- ROLE_PROFESOR --> DashProf[Dashboard Profesor]
        DashProf --> MyWorkshops[Mis Talleres]
        MyWorkshops --> ListAsis[Lista de Alumnos]
        ListAsis --> ActionAsis[Registrar Asistencia]
    end

    %% --- CARRIL ALUMNO ---
    subgraph "Perfil: ALUMNO"
        Router -- ROLE_ALUMNO --> DashAlu[Dashboard Alumno]
        DashAlu --> Catalog[Catálogo Talleres]
        Catalog --> ActionInsc[Inscribirse]
        DashAlu --> MyHistory[Mis Asistencias]
    end

    %% --- SALIDA ---
    DashAdmin --> Logout
    DashProf --> Logout
    DashAlu --> Logout
    Logout[Cerrar Sesión] --> Login

    %% Estilos Visuales
    style Login fill:#ff9,stroke:#333
    style Router fill:#f9f,stroke:#333,stroke-width:4px
    style ViewListAlu fill:#bbf,stroke:#333
    style ViewFormNew fill:#bfb,stroke:#333
    style ModalDel fill:#fcc,stroke:#333
```

---

[Volver](/README.md)