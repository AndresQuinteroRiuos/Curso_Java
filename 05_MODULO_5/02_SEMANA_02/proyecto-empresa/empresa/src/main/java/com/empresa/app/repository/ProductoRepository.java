package com.empresa.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombre(String nombre);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByNombreBetween(Double min, Double max);

    List<Producto> findByPrecioBetween(Double min, Double max);
}
