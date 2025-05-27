package com.empresa.app.repository;

import com.empresa.app.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);

    List<Cliente> findByEmailContaining(String email);

}