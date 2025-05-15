package com.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private LocalDate fecha;

    public Venta(Producto producto, Usuario cliente, Usuario vendedor, Integer cantidad, LocalDate fecha) {
        this.producto = producto;
        this.usuario = cliente;
        this.usuario = vendedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String toString() {
        return "Venta #" + id + " | " + cantidad + " x " + producto.getNombre() + " a " +
                usuario.getNombre() + " por " + usuario.getNombre() + " el " + fecha;
    }
}
