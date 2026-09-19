# CRUD de Productos con Spring Boot

API REST + interfaz web (Java 17, Spring Boot 3, Spring Data JPA).
Usa H2 en memoria en desarrollo y MySQL cuando se ejecuta con Docker.

## Estructura

```
src/main/java/com/ejemplo/crud
├── CrudApplication.java
├── controller/   -> endpoints REST
├── service/      -> logica de negocio
├── repository/   -> acceso a datos (JPA)
├── model/        -> entidad Producto
└── exception/    -> manejo de errores
src/main/resources
├── application.properties         -> perfil por defecto (H2)
├── application-mysql.properties   -> perfil MySQL
└── static/index.html              -> interfaz web
```

## Ejecutar con Docker (MySQL)

Requiere Docker Desktop.

```bash
docker compose up --build
```

Abrir `http://localhost:8080/`. Los datos se guardan en un volumen de Docker
y se conservan al detener y volver a iniciar.

| Comando                     | Que hace                                          |
|-----------------------------|---------------------------------------------------|
| `docker compose up --build` | Construye y arranca (usar tras cambiar codigo)    |
| `docker compose up`         | Arranca sin reconstruir                           |
| `docker compose down`       | Detiene y elimina los contenedores (conserva datos) |
| `docker compose down -v`    | Igual, pero BORRA tambien los datos de MySQL      |

MySQL tambien queda disponible en `localhost:3307`
(base `productosdb`, usuario `productos`, clave `productos123`).
Estas credenciales son solo para desarrollo local.

## Ejecutar sin Docker (H2)

Ejecutar `CrudApplication` desde IntelliJ o con `mvn spring-boot:run`.
Los datos se borran al detener la aplicacion.

## Endpoints

| Metodo | URL                    | Descripcion          |
|--------|------------------------|----------------------|
| GET    | /api/productos         | Listar todos         |
| GET    | /api/productos/{id}    | Obtener por id       |
| POST   | /api/productos         | Crear                |
| PUT    | /api/productos/{id}    | Actualizar           |
| DELETE | /api/productos/{id}    | Eliminar             |

## Tests

```bash
mvn test
```
