package com.empresa.consultasavanzadas.service;

import java.util.List;

import com.empresa.consultasavanzadas.domain.entity.Pedido;
import com.empresa.consultasavanzadas.domain.filter.PedidoFiltro;

public interface PedidoService {
    List<Pedido> obtenerUltimoPedidos();

    List<Object[]> obtenerTopProductos(int topN);

    List<Object[]> obtenerClientesFrecuentes(long minCompras);

    List<Pedido> buscarDinamico(PedidoFiltro filtro);

    Pedido crearPedido(Pedido pedido);

    List<Pedido> obtenerTodosLosPedidos();

    List<Pedido> obtenerPedidosOrdenados(String campo, String direccion);
}
