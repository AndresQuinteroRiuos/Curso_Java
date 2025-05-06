package com.example;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        // Creando una colecciòn de strings
        Collection<String> nombres = List.of("Andres", "Juan", "Edwinson", "Catalina", "Ana", "Beatriz");

        System.out.println("\n\nCadena original\n" + nombres);

        // Procesamiento con streams
        List<String> nombreMayuscula = nombres.stream()
                .filter(n -> n.length() > 5) // Operación intermedia - filtro
                .map(String::toUpperCase) // Operación intermedia - transformación
                .sorted() // Operación intermedia - ordenamiento
                .collect(Collectors.toList()); // Operación terminal - Agregar a la lista

        System.out.println("\nCadena procesada con un pipeline de streams\n" + nombreMayuscula);

    }
}
