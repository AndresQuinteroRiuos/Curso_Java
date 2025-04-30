package com.example;

import java.util.List;
//import java.util.stream.Stream;

/**
 * Clase principal que demuestra el uso de Streams en Java.
 * Esta clase muestra ejemplos de operaciones intermedias y terminales en
 * Streams,
 * incluyendo filter, map, distinct, sorted y forEach.
 * 
 * @author Example
 * @version 1.0
 */
public class App {

    /**
     * Método principal que ejecuta la demostración de Streams.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Stream<String> nombres = List.of("Ana", "Luis", "Pedro").stream();

        /*
         * Operaciones Intermedias
         * map(): transformar elementos
         * filter(): filtra de acuerdo a una condición
         * sorted(): Orden natural
         * distinct(): eliminar elementos duplicados
         * limit(), skip(): controlar el número de elementos.
         */

        // Creamos una lista de nombre de tipo "String"
        List<String> nombres = List.of("Ana", "Luis", "Pedro", "Amalia");

        // Imprimir la lista original
        System.out.println("Lista original: ");
        nombres.forEach(System.out::println);

        // Anunciamos el inicio de una serie de procesos intermedio en Stream
        System.out.println("Procesamiento del Stream");

        // Iniciar un Stream de la lista "nombres"
        nombres.stream()
                // Aplicar un filtro para dejar solo los nombres que inicien con "A"
                .filter(nombre -> {
                    System.out.println("Filtro: evaluando " + nombre);
                    return nombre.startsWith("A");

                })

                // Ver los datos luego de haber aplicado el "filter"
                .peek(nombre -> System.out.println("Despues del filter: " + nombre))

                // Convertimos en mayúscula los valores que fueron filtrados
                .map(nombre -> {
                    String upper = nombre.toUpperCase();
                    System.out.println("Mapeando a mayuscula: " + upper);
                    return upper;
                })

                // Eliminar los elementos duplicados
                .distinct()

                // Ver los datos luego de haber eliminado los duplicados
                .peek(nombre -> System.out.println("Lista despues del distinct: " + nombre))

                // Ordenar alfabeticamente los nombres resultantes
                .sorted()

                // Ver los datos despues del ordenamiento
                .peek(nombre -> System.out.println("Despues de ordenar con el sorted: " + nombre))

                /*
                 * Imprimir cada nombre del Stream por consola, para ello, se utiliza la
                 * "Operación Terminal" Foreach: Imprimir -> Cerrar el Stream -> producir un
                 * resultado
                 */

                .forEach(nombre -> System.out.println("Imprimir el final: " + nombre));

    }
}
