package com.empresa.consultasavanzadas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.consultasavanzadas.domain.entity.Producto;
import com.empresa.consultasavanzadas.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

}
