# Guia Tecnica del Proyecto AppAnimeApplication
## Estructura del proyecto
AppAnimeApplication/ <br>
├── src/<br> 
│ ├── com.app.anime/ <br> 
│ │ └── AppAnimeApplication.java # Clase principal (main) <br>
│ ├── com.app.anime.controller/ <br>
│ ├── com.app.anime.model/ <br>
│ │ ├── Usuario.java # Modelo de usuario <br>
│ │ ├── PostgresConector.java # Conexión a PostgreSQL <br>
│ │ └── RepositorioUsuario.java # Lógica de persistencia de usuarios <br>
│ ├── com.app.anime.service/ <br>
│ ├── com.app.anime.view/ <br>
├── .env # Variables sensibles (URL, usuario, contraseña) <br>
├── .gitignore # Exclusión de archivos sensibles <br>
└── README.md # Descripción general del proyecto 
---
## Patrón de diseño: MVC
- **Modelo (`model`)**: Clases que representan datos y lógica de acceso
- **Vista (`view`)**: 
- **Controlador (`controller`)**:
---
## Seguridad
- Uso de `.env` para proteger credenciales de conexión.
- `.gitignore` evita subir `.env` al repositorio
- Contraseñas se almacenan **hasheadas con BCrupt**, no en texto plano.
---
## Clases y Métodos Documentados

### `Usuario.java`

**Propósito**: Representa un usuario con nombre y contraseña.

| Método | Descripción |
|--------|-------------|
| `Usuario(String usuario, String contrasena)` | Constructor que inicializa los atributos. |
| `getUsuario()` / `setUsuario()` | Acceso y modificación del nombre de usuario. |
| `getContrasena()` / `setContrasena()` | Acceso y modificación de la contraseña (sin hashear). |

> Nota: La contraseña se guarda en texto plano en esta clase, pero se hashea antes de insertarse en la base de datos.
---
### `PostgresConector.java`

**Propósito**: Establece conexión con la base de datos PostgreSQL usando credenciales del archivo `.env`.

| Elemento | Descripción |
|---------|-------------|
| `Dotenv.load()` | Carga variables desde `.env`. |
| `getConnection()` | Devuelve una conexión activa a PostgreSQL. Maneja excepciones y retorna `null` si falla. |
---
### `RepositorioUsuario.java`
| Método | Descrpción                                                                              |
|--------|-----------------------------------------------------------------------------------------|
| `guardarUsuario(Usuario usuario, Connection conn)` | - Hashea la contraseña con BCrypt. <br> - Inserta el nuevo usuario en la base de datos. |
| `crearTablaUsuarios(Connection conn)` | - Ejecuta SQL para crear la tabla `tbUsuarios` con: <br> - `id` autoincremental <br>- `usuario` único <br>- `contraseña` obligatoria |
| `usuarioExiste(String usuario, Connection conn)` |- Consulta si el usuario ya existe en la base de datos.<br>- Devuelve `true` si encuentra coincidencias, `false` si no. |

---
### `ServicioUsuario.java`
| Método | Descrpción                                                                              |
|--------|-----------------------------------------------------------------------------------------|
| `registraUsuario(Usuario usuario)` |- Obtiene una conexión a la base de datos.<br>- Crea la tabla `tbUsuarios` si no existe.<br>- Verifica si el usuario ya está registrado.<br>- Si no existe, guarda el usuario con contraseña hasheada.<br>- Muestra mensajes de éxito o error.|
---

### `AppAnimeApplication.java`

**Propósito**: Clase principal para ejecutar la aplicación.

#### `main(String[] args)`

- Crea un usuario de prueba.
- Llama a `ServicioUsuario` para registrarlo.

---

## 🛠️ Siguientes pasos sugeridos

1. **Crear carpeta `view`** para integrar JavaFX como interfaz.

3. **Agregar validaciones** en la clase `Usuario` (por ejemplo, longitud mínima de contraseña).
4. **Documentar errores comunes** en un archivo `ErroresComunes.md`.

---