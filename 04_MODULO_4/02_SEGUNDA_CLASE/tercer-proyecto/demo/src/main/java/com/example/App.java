package com.example;

import java.util.List;

/**
 * Una aplicación Java simple que demuestra operaciones básicas con listas
 * incluyendo iteración y reducción.
 */
public class App {

    /**
     * Crea y retorna una lista de números enteros.
     * 
     * @return Lista de números enteros
     */
    private static List<Integer> createNumberList() {
        return List.of(1, 2, 3, 4, 5);
    }

    /**
     * Imprime cada número de la lista.
     * 
     * @param numbers Lista de números enteros a imprimir
     */
    private static void printNumbers(List<Integer> numbers) {
        System.out.println("\nLista de números:");
        numbers.forEach(numero -> System.out.print(numero + " "));
        System.out.println("\n");
    }

    /**
     * Calcula la suma de todos los números en la lista.
     * 
     * @param numbers Lista de números enteros a sumar
     * @return Suma de todos los números
     */
    private static int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> numeros = createNumberList();

        printNumbers(numeros);

        int suma = calculateSum(numeros);
        System.out.println("El resultado de la suma de todos los elementos es: " + suma);
    }
}
