package com.empresa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.app.entity.Cliente;
import com.empresa.app.entity.Pedido;
import com.empresa.app.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll(); // SELECT * FROM pedidos
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido); // INSERT INTO pedidos (cliente_id, fecha, total) VALUES (?, ?, ?)
    }

    public List<Pedido> obtenerPedidosPorCliente(Cliente cliente) {
        return pedidoRepository.findByCliente(cliente); // SELECT * FROM pedidos WHERE cliente_id = ?
    }

    public void eliminarPorId(Long id) {
        pedidoRepository.deleteById(id); // DELETE FROM pedidos WHERE id = ?
    }

}
