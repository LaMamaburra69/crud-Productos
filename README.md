# CRUD de Productos con Spring Boot

API REST básica (Java 17, Spring Boot 3, Spring Data JPA, H2).

## Estructura

```
src/main/java/com/ejemplo/crud
├── CrudApplication.java
├── controller/   -> endpoints REST
├── service/      -> lógica de negocio
├── repository/   -> acceso a datos (JPA)
├── model/        -> entidad Producto
└── exception/    -> manejo de errores
```

## Ejecutar

```bash
mvn spring-boot:run
```

La API queda en `http://localhost:8080/api/productos`.

## Endpoints

| Método | URL                    | Descripción          |
|--------|------------------------|----------------------|
| GET    | /api/productos         | Listar todos         |
| GET    | /api/productos/{id}    | Obtener por id       |
| POST   | /api/productos         | Crear                |
| PUT    | /api/productos/{id}    | Actualizar           |
| DELETE | /api/productos/{id}    | Eliminar             |

## Ejemplos con curl

```bash
# Crear
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Mouse","descripcion":"Inalámbrico","precio":45000,"stock":25}'

# Listar
curl http://localhost:8080/api/productos

# Actualizar
curl -X PUT http://localhost:8080/api/productos/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Mouse Pro","descripcion":"Ergonómico","precio":60000,"stock":20}'

# Eliminar
curl -X DELETE http://localhost:8080/api/productos/1
```

## Tests

```bash
mvn test
```
