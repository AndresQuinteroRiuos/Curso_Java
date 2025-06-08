package com.empresa.app.service;

import com.empresa.app.entity.Cliente;
import com.empresa.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public List<Cliente> buscarPorEmail(String fragmento) {
        return clienteRepository.findByEmailContaining(fragmento);
    }

    public void eliminarPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
