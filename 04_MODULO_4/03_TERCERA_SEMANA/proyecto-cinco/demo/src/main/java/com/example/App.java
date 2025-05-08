package com.example;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
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
        return "Venta [cliente=" + cliente + ", producto=" + producto + ", getTotal()=" + getTotal() + "]";
    }

}

public class App {

    public static void main(String[] args) {

        List<Venta> ventas = Arrays.asList(
                new Venta("Cliente1", "ProductoA", "Electronica", 3, 150.0),
                new Venta("Cliente2", "ProductoB", "Hogar", 2, 300.0),
                new Venta("Cliente3", "ProductoA", "Electronica", 1, 200.0),
                new Venta("Cliente4", "ProductoC", "Hogar", 2, 350.0));

        DoubleSummaryStatistics estadisticaDescriptiva = ventas.stream()
                .collect(Collectors.summarizingDouble(Venta::getTotal));

        System.out.println("\n\nEstadistica de ventas: ");
        System.out.println("\nTotal: " + estadisticaDescriptiva.getSum());
        System.out.println("Promedio: " + estadisticaDescriptiva.getAverage());
        System.out.println("Maximo: " + estadisticaDescriptiva.getMax());
        System.out.println("Minimo: " + estadisticaDescriptiva.getMin());
        System.out.println("Cantidad: " + estadisticaDescriptiva.getCount());
    }

}