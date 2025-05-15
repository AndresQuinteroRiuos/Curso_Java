package com.proyecto.service;

import com.proyecto.models.Usuario;
import com.proyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void registrarUsuario(String nombre, String tipo) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!tipo.equals("cliente") && !tipo.equals("vendedor")) {
            throw new IllegalArgumentException("El tipo debe ser 'cliente' o 'vendedor'");
        }
        Usuario usuario = new Usuario(nombre, tipo);
        repository.save(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!usuario.getTipo().equals("cliente") && !usuario.getTipo().equals("vendedor")) {
            throw new IllegalArgumentException("El tipo debe ser 'cliente' o 'vendedor'");
        }
        repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public void eliminarUsuario(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Verificar si el usuario tiene ventas asociadas
        if (usuario.getVentas() != null && !usuario.getVentas().isEmpty()) {
            throw new IllegalArgumentException("No se puede eliminar el usuario porque tiene ventas asociadas");
        }

        repository.deleteById(id);
    }
}
