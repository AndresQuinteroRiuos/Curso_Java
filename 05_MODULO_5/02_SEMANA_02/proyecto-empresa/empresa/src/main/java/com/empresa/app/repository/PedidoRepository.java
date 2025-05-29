package com.empresa.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.entity.Cliente;
import com.empresa.app.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByCliente(Cliente cliente);

}
