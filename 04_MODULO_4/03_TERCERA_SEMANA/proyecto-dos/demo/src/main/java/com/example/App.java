package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Producto {

    String nombre;
    String categoria;
    double precio;

    public Producto(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

public class App {

    public static void main(String[] args) {

        List<Producto> productos = Arrays.asList(
                new Producto("Portatil", "Computacion", 1200.0),
                new Producto("Cafetera", "Hogar", 50.0),
                new Producto("Smartphone", "Electronica", 800.0),
                new Producto("Libro", "Libreria", 40.0));

        System.out.println("\n\nLa lista original de productos\n" + productos);
        List<String> productosFiltrados = productos.stream()
                .filter(p -> p.getPrecio() > 100) // Filtrando aquellos precios > 100
                .map(p -> p.getNombre().toUpperCase()) // Convertir los nombre de los producto en mayusculas.
                .sorted(Comparator.reverseOrder()) // Ordenar los nombres de los productos en forma descendiente.
                .collect(Collectors.toList()); // Guardamos el resultado del Stream en la lista "productosFiltrados"

        System.out.println("\nLa lista con los productos filtrados\n" + productosFiltrados);
    }
}