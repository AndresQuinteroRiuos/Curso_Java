package com.example;

import java.util.Arrays;
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

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return String.format("Venta{cliente = '%s', producto = '%s', total = %.2f}", cliente, producto, getTotal());
    }

}

public class App {

    public static void main(String[] args) {

        // Lista de ventas (instancias de Ventas)
        List<Venta> ventas = Arrays.asList(
                new Venta("Cliente1", "ProductoA", "Electronica", 5, 150.0),
                new Venta("Cliente2", "ProductoB", "Hogar", 2, 100.0),
                new Venta("Cliente3", "ProductoA", "Electronica", 1, 220.0),
                new Venta("Cliente4", "ProductoC", "Hogar", 2, 800.0),
                new Venta("Cliente5", "ProductoD", "Electronica", 1, 700.0));

        // Crear el Stream() para dividir las ventas mayores a 500 y cuales no

        Map<Boolean, List<Venta>> caras = ventas.stream()
                .collect(Collectors.partitioningBy(v -> v.getTotal() > 500));

        System.out.println("\n\nVentas con un Total mayor a 500: ");
        caras.get(true).forEach(System.out::println);

        System.out.println("\n\nTotal de ventas que no superaron los 500: ");
        caras.get(false).forEach(System.out::println);

    }
}