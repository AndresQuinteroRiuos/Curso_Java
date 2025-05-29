package com.empresa.app.controller;

import com.empresa.app.service.ClienteService;
import com.empresa.app.entity.Cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        List<Cliente> cliente = clienteService.obtenerTodos();
        if (cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody @Valid Cliente cliente) {
        Cliente creado = clienteService.guardar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Cliente>> buscarPorNombre(@PathVariable String nombre) {
        List<Cliente> clientes = clienteService.buscarPorNombre(nombre);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Cliente>> buscarPorEmail(@PathVariable String email) {
        List<Cliente> clientes = clienteService.buscarByEmail(email);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
