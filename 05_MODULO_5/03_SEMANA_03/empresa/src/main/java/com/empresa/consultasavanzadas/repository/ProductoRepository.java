package com.empresa.consultasavanzadas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.consultasavanzadas.domain.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContaining(String fragmento);

    List<Producto> findByPrecioGreaterThanOrderByPrecioDesc(Double valor);

}
