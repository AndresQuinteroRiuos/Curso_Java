# Documentación de Pruebas de API

## Configuración Inicial

1. **Base URL**: `http://localhost:8080`
2. **Headers**:
   - `Content-Type: application/json`

## Endpoints de Clientes

### 1. Obtener Todos los Clientes

- **Método**: GET
- **URL**: `/clientes`
- **Descripción**: Retorna la lista de todos los clientes registrados
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan@email.com",
    "telefono": "123456789"
  }
]
```

### 2. Crear Cliente

- **Método**: POST
- **URL**: `/clientes`
- **Descripción**: Crea un nuevo cliente
- **Body**:

```json
{
  "nombre": "Juan Pérez",
  "email": "juan@email.com",
  "telefono": "123456789"
}
```

- **Respuesta Exitosa**: 201 Created

```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "email": "juan@email.com",
  "telefono": "123456789"
}
```

### 3. Buscar Cliente por Nombre

- **Método**: GET
- **URL**: `/clientes/nombre/{nombre}`
- **Descripción**: Busca clientes por nombre exacto
- **Ejemplo**: `/clientes/nombre/Juan Pérez`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan@email.com",
    "telefono": "123456789"
  }
]
```

### 4. Buscar Cliente por Email

- **Método**: GET
- **URL**: `/clientes/email/{email}`
- **Descripción**: Busca clientes por email parcial
- **Ejemplo**: `/clientes/email/juan`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan@email.com",
    "telefono": "123456789"
  }
]
```

### 5. Eliminar Cliente

- **Método**: DELETE
- **URL**: `/clientes/{id}`
- **Descripción**: Elimina un cliente por su ID
- **Ejemplo**: `/clientes/1`
- **Respuesta Exitosa**: 204 No Content

## Endpoints de Productos

### 1. Obtener Todos los Productos

- **Método**: GET
- **URL**: `/productos`
- **Descripción**: Retorna la lista de todos los productos
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 999.99,
    "stock": 10
  }
]
```

### 2. Crear Producto

- **Método**: POST
- **URL**: `/productos`
- **Descripción**: Crea un nuevo producto
- **Body**:

```json
{
  "nombre": "Laptop",
  "precio": 999.99,
  "stock": 10
}
```

- **Respuesta Exitosa**: 201 Created

```json
{
  "id": 1,
  "nombre": "Laptop",
  "precio": 999.99,
  "stock": 10
}
```

### 3. Buscar Producto por Nombre Exacto

- **Método**: GET
- **URL**: `/productos/nombre/{nombre}`
- **Descripción**: Busca productos por nombre exacto
- **Ejemplo**: `/productos/nombre/Laptop`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 999.99,
    "stock": 10
  }
]
```

### 4. Buscar Producto por Nombre Parcial

- **Método**: GET
- **URL**: `/productos/nombre/parcial/{nombre}`
- **Descripción**: Busca productos por nombre parcial
- **Ejemplo**: `/productos/nombre/parcial/lap`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 999.99,
    "stock": 10
  }
]
```

### 5. Buscar Productos por Rango de Precio

- **Método**: GET
- **URL**: `/productos/precio`
- **Descripción**: Busca productos por rango de precio
- **Parámetros**:
  - `min`: precio mínimo
  - `max`: precio máximo
- **Ejemplo**: `/productos/precio?min=500&max=1000`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 999.99,
    "stock": 10
  }
]
```

### 6. Eliminar Producto

- **Método**: DELETE
- **URL**: `/productos/{id}`
- **Descripción**: Elimina un producto por su ID
- **Ejemplo**: `/productos/1`
- **Respuesta Exitosa**: 204 No Content

## Endpoints de Pedidos

### 1. Obtener Todos los Pedidos

- **Método**: GET
- **URL**: `/pedidos`
- **Descripción**: Retorna la lista de todos los pedidos
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "fecha": "2024-03-20",
    "cliente": {
      "id": 1,
      "nombre": "Juan Pérez"
    },
    "productos": [
      {
        "id": 1,
        "nombre": "Laptop"
      }
    ]
  }
]
```

### 2. Crear Pedido

- **Método**: POST
- **URL**: `/pedidos`
- **Descripción**: Crea un nuevo pedido
- **Body**:

```json
{
  "fecha": "2024-03-20",
  "cliente": {
    "id": 1
  },
  "productos": [
    {
      "id": 1
    },
    {
      "id": 2
    }
  ]
}
```

- **Respuesta Exitosa**: 201 Created

```json
{
  "id": 1,
  "fecha": "2024-03-20",
  "cliente": {
    "id": 1,
    "nombre": "Juan Pérez"
  },
  "productos": [
    {
      "id": 1,
      "nombre": "Laptop"
    },
    {
      "id": 2,
      "nombre": "Mouse"
    }
  ]
}
```

### 3. Obtener Pedidos por Cliente

- **Método**: GET
- **URL**: `/pedidos/cliente/{clienteId}`
- **Descripción**: Obtiene los pedidos de un cliente específico
- **Ejemplo**: `/pedidos/cliente/1`
- **Respuesta Exitosa**: 200 OK

```json
[
  {
    "id": 1,
    "fecha": "2024-03-20",
    "cliente": {
      "id": 1,
      "nombre": "Juan Pérez"
    },
    "productos": [
      {
        "id": 1,
        "nombre": "Laptop"
      }
    ]
  }
]
```

### 4. Eliminar Pedido

- **Método**: DELETE
- **URL**: `/pedidos/{id}`
- **Descripción**: Elimina un pedido por su ID
- **Ejemplo**: `/pedidos/1`
- **Respuesta Exitosa**: 204 No Content

## Flujo de Prueba Recomendado

1. Crear un cliente usando POST `/clientes`
2. Crear varios productos usando POST `/productos`
3. Crear un pedido usando POST `/pedidos` (asociando el cliente y productos creados)
4. Verificar los pedidos del cliente usando GET `/pedidos/cliente/{id}`
5. Probar las búsquedas de productos
6. Eliminar recursos usando los endpoints DELETE

## Notas Importantes

- Asegúrate de que la base de datos PostgreSQL esté corriendo
- Verifica que las credenciales en `application.properties` sean correctas
- Los IDs en los ejemplos son referenciales, los IDs reales dependerán de los registros en tu base de datos
- Algunas respuestas pueden variar dependiendo de los datos existentes en la base de datos
