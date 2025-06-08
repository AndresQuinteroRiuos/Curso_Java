package com.empresa.app.repository;

import com.empresa.app.entity.Pedido;
import com.empresa.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Buscar pedidos por cliente
    List<Pedido> findByCliente(Cliente cliente);
}
