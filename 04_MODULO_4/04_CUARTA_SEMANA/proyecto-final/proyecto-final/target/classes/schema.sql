CREATE DATABASE IF NOT EXISTS gestion_ventas;
USE gestion_ventas;

CREATE TABLE IF NOT EXISTS producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    precio DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('cliente', 'vendedor'))
);

CREATE TABLE IF NOT EXISTS venta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    vendedor_id BIGINT NOT NULL,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES producto(id),
    FOREIGN KEY (cliente_id) REFERENCES usuario(id),
    FOREIGN KEY (vendedor_id) REFERENCES usuario(id)
); 