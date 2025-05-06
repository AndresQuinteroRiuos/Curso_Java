package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Venta {

    private String cliente;
    private String producto;
    private String categoria;
    private int cantidad;
    private double precioUnitario;

    public Venta(String cliente, String producto, String categoria, int cantidad, double precioUnitario) {
        this.cliente = cliente;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Metodo para imprimir la información de la venta de forma legible
    @Override
    public String toString() {
        return "Venta{" +
                "cliente='" + cliente + '\'' +
                ", producto='" + producto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", precioUnitario=" + precioUnitario + '}';
    }

}

public class App {
    public static void main(String[] args) {

        List<Venta> ventas = List.of(
                new Venta("Cliente1", "ProductoA", "Electrónica", 3, 150.0),
                new Venta("Cliente2", "ProductoB", "Hogar", 2, 300.0),
                new Venta("Cliente1", "ProductoC", "Electrónica", 1, 700.0));

        Map<String, List<Venta>> ventasPorCategoria = ventas.stream()
                .collect(Collectors.groupingBy(Venta::getCategoria));

        ventasPorCategoria.forEach((categoria, listaVentas) -> {
            System.out.println("Categoría: " + categoria);
            listaVentas.forEach(v -> System.out.println("  - " + v));
        });
    }
}