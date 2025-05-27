package com.empresa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.app.entity.Cliente;
import com.empresa.app.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll(); // SELECT * FROM clientes
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente); // INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre); // SELECT * FROM clientes WHERE nombre = ?
    }

    public List<Cliente> buscarByEmail(String fragmento) {
        return clienteRepository.findByEmailContaining(fragmento); // SELECT * FROM clientes WHERE email LIKE
                                                                   // CONCAT('%', ?, '%')
    }

    public void eliminarPorId(Long id) {
        clienteRepository.deleteById(id); // DELETE FROM clientes WHERE id = ?
    }
}
