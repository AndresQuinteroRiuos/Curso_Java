package com.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase principal que demuestra el uso de Streams en Java.
 * Esta clase muestra ejemplos de operaciones intermedias y terminales en
 * Streams,
 * incluyendo filter, map, distinct y sorted.
 * 
 * @author Example
 * @version 1.0
 */
public class App {

    /**
     * Procesa una lista de nombres aplicando una serie de operaciones de Stream.
     * - Filtra nombres que comienzan con 'A'
     * - Convierte a mayúsculas
     * - Elimina duplicados
     * - Ordena alfabéticamente
     * 
     * @param nombres Lista de nombres a procesar
     * @return Lista de nombres procesados
     */
    private static List<String> procesarNombres(List<String> nombres) {
        return nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Método principal que ejecuta la demostración de Streams.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis", "Pedro", "Amalia");

        System.out.println("Lista original:");
        nombres.forEach(System.out::println);

        System.out.println("\nLista procesada:");
        List<String> nombresProcesados = procesarNombres(nombres);
        nombresProcesados.forEach(System.out::println);
    }
}
