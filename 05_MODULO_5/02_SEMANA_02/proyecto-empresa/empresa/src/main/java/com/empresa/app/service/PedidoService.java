package com.empresa.app.service;

import com.empresa.app.entity.Pedido;
import com.empresa.app.entity.Cliente;
import com.empresa.app.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidosPorCliente(Cliente cliente) {
        return pedidoRepository.findByCliente(cliente);
    }

    public void eliminarPorId(Long id) {
        pedidoRepository.deleteById(id);
    }
}
