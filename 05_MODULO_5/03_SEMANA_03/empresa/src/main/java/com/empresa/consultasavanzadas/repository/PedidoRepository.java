package com.empresa.consultasavanzadas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empresa.consultasavanzadas.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>,
        JpaSpecificationExecutor<Pedido> {

    @Query("SELECT p FROM Pedido p WHERE P.fecha >= :haceUnMes")
    List<Pedido> ultimosPedidos(@Param("haceUnMes") LocalDate haceUnMes);

    @Query("SELECT d.producto, SUM(d.cantidad) FROM DetallePedido d GROUP BY d.producto ORDER BY SUM(d.cantidad) DESC")
    List<Object[]> topProductos(PageRequest pageable);

    @Query("SELECT p.cliente, COUNT(p) FROM Pedido p GROUP BY p.cliente HAVING COUNT(p) > :minCompras")
    List<Object[]> clientesFrecuentes(@Param("minCompras") long minCompras);

    List<Pedido> findAllByFechaAfter(LocalDate fecha, Sort sort);

}