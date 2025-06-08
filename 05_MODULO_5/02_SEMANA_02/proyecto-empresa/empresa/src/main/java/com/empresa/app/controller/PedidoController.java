package com.empresa.app.controller;

import com.empresa.app.entity.Cliente;
import com.empresa.app.entity.Pedido;
import com.empresa.app.service.ClienteService;
import com.empresa.app.service.PedidoService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;

    public PedidoController(PedidoService pedidoService, ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodos() {
        List<Pedido> pedidos = pedidoService.obtenerTodos();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody @Valid Pedido pedido) {
        Pedido creado = pedidoService.guardar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.obtenerPorId(clienteId);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        List<Pedido> pedidos = pedidoService.obtenerPedidosPorCliente(cliente);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
