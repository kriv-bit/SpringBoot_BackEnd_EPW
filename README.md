<div align="center">

# 🚀 EPW Activities API
### *Gestor de Actividades con Spring Boot*

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)

Backend REST para gestionar actividades, categorías, etiquetas, recordatorios y detalles.

> 📚 **Proyecto realizado en clase para la materia Web Electiva: Programación Web.**

</div>

---

## ✨ Características principales

- CRUD completo de actividades.
- Manejo de estado y prioridad por actividad.
- Asociación opcional de actividades con categorías.
- Relación many-to-many entre actividades y etiquetas.
- Creación de recordatorios por actividad.
- Registro de detalle extendido por actividad (lugar, duración estimada, notas privadas).
- Validaciones de entrada con Jakarta Validation.
- Manejo centralizado de errores con respuestas consistentes.

---

## 🧱 Stack tecnológico

- **Java 25**
- **Spring Boot 4.0.3**
  - Spring Web MVC
  - Spring Data JPA
  - Spring Validation
- **PostgreSQL**
- **Maven Wrapper** (`./mvnw`)

---

## 🗂️ Estructura del proyecto

```text
src/main/java/com/epw/activities
├── controller    # Endpoints REST
├── dto           # Request/Response DTOs
├── entity        # Entidades JPA y enums
├── exception     # Manejo global de errores
├── repository    # Repositorios Spring Data
└── service       # Lógica de negocio
```

---

## 🧩 Modelo de dominio (resumen)

- **Activity**
  - Tiene `title`, `description`, `status`, `priority`, `dueDate`, timestamps y `completedAt`.
  - Pertenece opcionalmente a una **Category**.
  - Puede tener muchos **Reminder**.
  - Puede tener un **ActivityDetail** (1 a 1).
  - Puede tener muchas **Tag** (N a N).

- **Category**
  - Catálogo para agrupar actividades.

- **Tag**
  - Etiquetas reutilizables para clasificar actividades.

- **Reminder**
  - Fecha/hora de recordatorio y nota opcional.

- **ActivityDetail**
  - Información extendida: lugar, minutos estimados y notas privadas.

---

## ⚙️ Configuración local

### 1) Requisitos

- JDK 25
- PostgreSQL corriendo localmente

### 2) Configurar base de datos

Por defecto, el proyecto espera:

- **DB:** `activities_db`
- **Usuario:** `postgres`
- **Password:** `1234`
- **Puerto app:** `8080`

Estos valores están en `src/main/resources/application.properties` y se pueden ajustar según tu entorno.

### 3) Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

La API quedará disponible en:

```text
http://localhost:8080
```

---

## 📡 Endpoints principales

Base URL: `/api`

### Actividades

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/activities` | Crear actividad |
| `GET` | `/activities` | Listar actividades |
| `GET` | `/activities/{id}` | Obtener actividad por ID |
| `PUT` | `/activities/{id}` | Actualizar actividad |
| `DELETE` | `/activities/{id}` | Eliminar actividad |
| `PATCH` | `/activities/{id}/done` | Marcar como DONE |
| `PATCH` | `/activities/{id}/status?value=IN_PROGRESS` | Cambiar estado |

### Etiquetas

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/tags` | Listar etiquetas |
| `POST` | `/tags` | Crear etiqueta |
| `POST` | `/activities/{activityId}/tags/{tagId}` | Asignar etiqueta a actividad |
| `DELETE` | `/activities/{activityId}/tags/{tagId}` | Quitar etiqueta de actividad |

### Recordatorios

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/activities/{activityId}/reminders` | Crear recordatorio para actividad |

### Detalle de actividad

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/activities/{activityId}/detail` | Crear detalle extendido |

---

## ✅ Validaciones y manejo de errores

- Se validan campos obligatorios y tamaños máximos en DTOs.
- Cuando no existe un recurso, la API responde con `404 NOT_FOUND`.
- Errores de validación devuelven `400` con detalle por campo.

Ejemplo de estructura de error de validación:

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Request validation failed",
  "timestamp": "2026-03-18T00:00:00Z",
  "path": "/api/activities",
  "fields": {
    "title": "title is required"
  }
}
```

---

## 🧪 Pruebas

Para ejecutar tests:

```bash
./mvnw test
```

---

## 🌱 Posibles mejoras

- Agregar endpoints CRUD para `Category`.
- Incorporar autenticación/autorización (Spring Security + JWT).
- Añadir paginación, filtros y ordenamiento en listados.
- Documentación OpenAPI/Swagger.
- Docker Compose para app + PostgreSQL.

---

## 👨‍💻 Autoría

Proyecto académico desarrollado como práctica de backend en **Web Electiva: Programación Web**.
