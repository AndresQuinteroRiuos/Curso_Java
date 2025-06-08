package com.empresa.app.repository;

import com.empresa.app.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar por nombre exacto
    List<Producto> findByNombre(String nombre);

    // Buscar productos cuyo nombre contenga una cadena (ej: búsqueda parcial)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Buscar productos por rango de precio
    List<Producto> findByPrecioBetween(Double min, Double max);
}
