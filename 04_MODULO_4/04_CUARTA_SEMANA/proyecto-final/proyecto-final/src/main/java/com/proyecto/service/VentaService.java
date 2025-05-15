package com.proyecto.service;

import com.proyecto.models.Venta;
import com.proyecto.models.Producto;
import com.proyecto.models.Usuario;
import com.proyecto.repository.VentaRepository;
import com.proyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VentaService {
    private final VentaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public VentaService(VentaRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarVenta(Producto producto, Usuario cliente, Usuario vendedor, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        // Verificar que el cliente exista en la base de datos
        Usuario clienteDB = usuarioRepository.findById(cliente.getId())
                .orElseThrow(() -> new IllegalArgumentException("El cliente no existe en la base de datos"));

        // Verificar que el vendedor exista en la base de datos
        Usuario vendedorDB = usuarioRepository.findById(vendedor.getId())
                .orElseThrow(() -> new IllegalArgumentException("El vendedor no existe en la base de datos"));

        if (!clienteDB.getTipo().equals("cliente")) {
            throw new IllegalArgumentException("El usuario seleccionado no es un cliente");
        }
        if (!vendedorDB.getTipo().equals("vendedor")) {
            throw new IllegalArgumentException("El usuario seleccionado no es un vendedor");
        }

        Venta venta = new Venta(producto, clienteDB, vendedorDB, cantidad, LocalDate.now());
        repository.save(venta);
    }

    public List<Venta> listarVentas() {
        return repository.findAll();
    }

    public void eliminarVenta(Long id) {
        repository.deleteById(id);
    }
}
