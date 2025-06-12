package com.empresa.consultasavanzadas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.consultasavanzadas.service.PedidoService;
import com.empresa.consultasavanzadas.domain.entity.Pedido;
import com.empresa.consultasavanzadas.domain.filter.PedidoFiltro;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping("/ultimos")
    public List<Pedido> ultimo() {
        return service.obtenerUltimoPedidos();
    }

    @GetMapping("/top-productos")
    public List<Object[]> topProductos(@RequestParam(defaultValue = "3") int n) {
        return service.obtenerTopProductos(n);
    }

    @GetMapping("clientes-frecuentes")
    public List<Object[]> clientes(@RequestParam(defaultValue = "3") long minCompras) {
        return service.obtenerClientesFrecuentes(minCompras);
    }

    @PostMapping("/buscar-dinamico")
    public List<Pedido> buscarDinamico(@RequestBody PedidoFiltro filtro) {
        return service.buscarDinamico(filtro);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return service.crearPedido(pedido);
    }

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return service.obtenerTodosLosPedidos();
    }

    /*
     * @GetMapping("/ordenados")
     * public List<Pedido> obtenerPedidosOrdenados(@RequestParam String campo,
     * 
     * @RequestParam(defaultValue = "ASC") String direccion) {
     * return service.obtenerPedidosOrdenados(campo, direccion);
     * }
     */
}