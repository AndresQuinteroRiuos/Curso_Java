# Documentación de la API

Este documento describe las diferentes APIs disponibles en el proyecto y cómo probarlas utilizando herramientas como Postman o cURL.

## Base URL

```
http://localhost:8080
```

---

## Endpoints

### 1. Crear un nuevo cliente

**URL:** `/api/clientes`

**Método:** `POST`

**Descripción:** Crea un nuevo cliente.

**Cuerpo de ejemplo:**

```json
{
  "nombre": "Juan Perez",
  "email": "juan.perez@example.com"
}
```

**Ejemplo de cURL:**

```bash
curl -X POST http://localhost:8080/api/clientes \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Juan Perez",
  "email": "juan.perez@example.com"
}'
```

---

### 2. Crear un nuevo producto

**URL:** `/api/productos`

**Método:** `POST`

**Descripción:** Crea un nuevo producto.

**Cuerpo de ejemplo:**

```json
{
  "nombre": "Producto A",
  "precio": 25.0
}
```

**Ejemplo de cURL:**

```bash
curl -X POST http://localhost:8080/api/productos \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Producto A",
  "precio": 25.0
}'
```

---

### 3. Crear un nuevo pedido

**URL:** `/api/pedidos`

**Método:** `POST`

**Descripción:** Crea un nuevo pedido con los detalles proporcionados.

**Cuerpo de ejemplo:**

```json
{
  "clienteId": 1,
  "fecha": "2025-06-08",
  "total": 150.0,
  "detalles": [
    {
      "productoId": 1,
      "cantidad": 2,
      "precioUnitario": 50.0
    },
    {
      "productoId": 2,
      "cantidad": 1,
      "precioUnitario": 50.0
    }
  ]
}
```

**Ejemplo de cURL:**

```bash
curl -X POST http://localhost:8080/api/pedidos \
-H "Content-Type: application/json" \
-d '{
  "clienteId": 1,
  "fecha": "2025-06-08",
  "total": 150.0,
  "detalles": [
    {
      "productoId": 1,
      "cantidad": 2,
      "precioUnitario": 50.0
    },
    {
      "productoId": 2,
      "cantidad": 1,
      "precioUnitario": 50.0
    }
  ]
}'
```

---

### 4. Obtener todos los pedidos

**URL:** `/api/pedidos`

**Método:** `GET`

**Descripción:** Devuelve una lista de todos los pedidos.

**Ejemplo de cURL:**

```bash
curl -X GET http://localhost:8080/api/pedidos
```

---

### 5. Obtener pedidos filtrados

**URL:** `/api/pedidos/filtrar`

**Método:** `POST`

**Descripción:** Filtra los pedidos según los criterios proporcionados.

**Cuerpo de ejemplo:**

```json
{
  "fechaDesde": "2025-01-01",
  "totalMin": 100.0
}
```

**Ejemplo de cURL:**

```bash
curl -X POST http://localhost:8080/api/pedidos/filtrar \
-H "Content-Type: application/json" \
-d '{
  "fechaDesde": "2025-01-01",
  "totalMin": 100.0
}'
```

---

### 6. Obtener los últimos pedidos

**URL:** `/api/pedidos/ultimos`

**Método:** `GET`

**Descripción:** Devuelve los pedidos realizados en el último mes.

**Ejemplo de cURL:**

```bash
curl -X GET http://localhost:8080/api/pedidos/ultimos
```

---

### 7. Obtener los productos más vendidos

**URL:** `/api/productos/top`

**Método:** `GET`

**Parámetros de consulta:**

- `topN` (opcional): Número de productos a devolver (por defecto 10).

**Descripción:** Devuelve los productos más vendidos.

**Ejemplo de cURL:**

```bash
curl -X GET "http://localhost:8080/api/productos/top?topN=5"
```

---

### 8. Obtener clientes frecuentes

**URL:** `/api/clientes/frecuentes`

**Método:** `GET`

**Parámetros de consulta:**

- `minCompras` (opcional): Número mínimo de compras para considerar a un cliente frecuente.

**Descripción:** Devuelve una lista de clientes frecuentes.

**Ejemplo de cURL:**

```bash
curl -X GET "http://localhost:8080/api/clientes/frecuentes?minCompras=3"
```

---

## Notas

- Asegúrate de que el servidor esté en ejecución antes de realizar las pruebas.
- Puedes usar herramientas como Postman para probar los endpoints de manera más interactiva.
- Si encuentras algún problema, revisa los logs del servidor para más detalles.
