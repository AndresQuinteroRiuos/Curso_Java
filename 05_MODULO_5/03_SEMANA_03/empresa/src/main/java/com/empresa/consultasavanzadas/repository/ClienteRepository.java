package com.empresa.consultasavanzadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.consultasavanzadas.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
