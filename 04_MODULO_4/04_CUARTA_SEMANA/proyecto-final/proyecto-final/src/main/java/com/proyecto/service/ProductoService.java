package com.proyecto.service;

import com.proyecto.models.Producto;
import com.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public void agregarProducto(String nombre, String categoria, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }

        Producto producto = new Producto(nombre.trim(), categoria, precio);
        repository.save(producto);
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Producto obtenerProducto(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    public void actualizarProducto(Long id, String nombre, String categoria, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        producto.setNombre(nombre.trim());
        producto.setCategoria(categoria);
        producto.setPrecio(precio);

        repository.save(producto);
    }

    public void eliminarProducto(Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (producto.getVentas() != null && !producto.getVentas().isEmpty()) {
            throw new IllegalArgumentException("No se puede eliminar el producto porque tiene ventas asociadas");
        }

        repository.deleteById(id);
    }
}
