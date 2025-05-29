package com.empresa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.app.entity.Producto;
import com.empresa.app.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll(); // SELECT * FROM productos
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto); // INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre); // SELECT * FROM productos WHERE nombre = ?
    }

    public List<Producto> buscarPorNombreParcial(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre); // SELECT * FROM productos WHERE nombre LIKE
                                                                            // CONCAT('%', ?, '%')
    }

    public List<Producto> buscarporRangoPrecio(Double min, Double max) {
        return productoRepository.findByPrecioBetween(min, max); // SELECT * FROM productos WHERE precio BETWEEN ? AND ?
    }

    public void eliminarPorId(Long id) {
        productoRepository.deleteById(id); // DELETE FROM productos WHERE id = ?
    }
}
