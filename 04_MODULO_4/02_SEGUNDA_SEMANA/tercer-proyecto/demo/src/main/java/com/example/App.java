package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Una aplicación Java simple que demuestra operaciones básicas con listas
 * incluyendo iteración y reducción.
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    /**
     * Muestra el menú de opciones y retorna la selección del usuario.
     * 
     * @return Opción seleccionada (1 o 2)
     */
    private static int mostrarMenu() {
        logger.info("\n=== MENÚ DE OPCIONES ===");
        logger.info("1. Ingresar números manualmente");
        logger.info("2. Generar números aleatorios");
        logger.info("Seleccione una opción (1 o 2): ");

        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion == 1 || opcion == 2) {
                    return opcion;
                }
                logger.warn("Opción inválida. Por favor ingrese 1 o 2");
            } catch (NumberFormatException e) {
                logger.warn("Entrada inválida. Por favor ingrese 1 o 2");
            }
        }
    }

    /**
     * Solicita al usuario ingresar números y los almacena en una lista.
     * 
     * @return Lista de números enteros ingresados por el usuario
     * @throws IllegalArgumentException si la lista está vacía
     */
    private static List<Integer> ingresarNumerosManual() throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        logger.info("\nIngrese los números (presione Enter después de cada número)");
        logger.info("Ingrese 'fin' para terminar la entrada");

        while (true) {
            try {
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("fin")) {
                    break;
                }

                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    numbers.add(number);
                    logger.info("Número {} agregado correctamente", number);
                }
            } catch (NumberFormatException e) {
                logger.warn("Entrada inválida. Por favor ingrese un número válido o 'fin' para terminar");
            }
        }

        if (numbers.isEmpty()) {
            logger.error("No se ingresaron números");
            throw new IllegalArgumentException("Debe ingresar al menos un número");
        }

        return numbers;
    }

    /**
     * Genera una lista de números aleatorios.
     * 
     * @return Lista de números enteros generados aleatoriamente
     */
    private static List<Integer> generarNumerosAleatorios() {
        List<Integer> numbers = new ArrayList<>();
        logger.info("\nIngrese la cantidad de números aleatorios a generar: ");

        int cantidad;
        while (true) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine().trim());
                if (cantidad > 0) {
                    break;
                }
                logger.warn("La cantidad debe ser mayor que 0");
            } catch (NumberFormatException e) {
                logger.warn("Entrada inválida. Por favor ingrese un número válido");
            }
        }

        logger.info("Ingrese el valor mínimo para los números aleatorios: ");
        int min = obtenerNumeroValido();

        logger.info("Ingrese el valor máximo para los números aleatorios: ");
        int max = obtenerNumeroValido();

        if (min > max) {
            logger.warn("El valor mínimo es mayor que el máximo. Se intercambiarán los valores.");
            int temp = min;
            min = max;
            max = temp;
        }

        for (int i = 0; i < cantidad; i++) {
            int numero = random.nextInt(max - min + 1) + min;
            numbers.add(numero);
            logger.info("Número aleatorio generado: {}", numero);
        }

        return numbers;
    }

    /**
     * Obtiene un número válido del usuario.
     * 
     * @return Número entero válido
     */
    private static int obtenerNumeroValido() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                logger.warn("Entrada inválida. Por favor ingrese un número válido");
            }
        }
    }

    /**
     * Imprime cada número de la lista.
     * 
     * @param numbers Lista de números enteros a imprimir
     * @throws NullPointerException si la lista es null
     */
    private static void printNumbers(List<Integer> numbers) throws NullPointerException {
        if (numbers == null) {
            logger.error("La lista de números es null");
            throw new NullPointerException("La lista de números no puede ser null");
        }

        logger.info("\nLista de números:");
        try {
            numbers.forEach(numero -> {
                if (numero == null) {
                    logger.warn("Se encontró un número null en la lista");
                    return;
                }
                logger.info("{} ", numero);
            });
            logger.info("");
        } catch (Exception e) {
            logger.error("Error al imprimir los números: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Calcula la suma de todos los números en la lista.
     * 
     * @param numbers Lista de números enteros a sumar
     * @return Suma de todos los números
     * @throws NullPointerException si la lista es null
     * @throws ArithmeticException  si ocurre un desbordamiento en la suma
     */
    private static int calculateSum(List<Integer> numbers) throws NullPointerException, ArithmeticException {
        if (numbers == null) {
            logger.error("La lista de números es null al calcular la suma");
            throw new NullPointerException("La lista de números no puede ser null");
        }

        try {
            return numbers.stream()
                    .filter(num -> num != null)
                    .reduce(0, (a, b) -> {
                        try {
                            return Math.addExact(a, b);
                        } catch (ArithmeticException e) {
                            logger.error("Desbordamiento al sumar {} + {}", a, b);
                            throw e;
                        }
                    });
        } catch (ArithmeticException e) {
            logger.error("Error de desbordamiento al calcular la suma: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Calcula el promedio de los números en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Promedio de los números
     * @throws NullPointerException si la lista es null
     * @throws ArithmeticException  si la lista está vacía
     */
    private static double calcularPromedio(List<Integer> numbers) throws NullPointerException, ArithmeticException {
        if (numbers == null) {
            logger.error("La lista de números es null al calcular el promedio");
            throw new NullPointerException("La lista de números no puede ser null");
        }

        if (numbers.isEmpty()) {
            logger.error("No se puede calcular el promedio de una lista vacía");
            throw new ArithmeticException("La lista no puede estar vacía para calcular el promedio");
        }

        try {
            // Filtrar valores null y contar elementos válidos
            long cantidadValidos = numbers.stream()
                    .filter(num -> num != null)
                    .count();

            if (cantidadValidos == 0) {
                logger.error("No hay números válidos en la lista para calcular el promedio");
                throw new ArithmeticException("No hay números válidos en la lista");
            }

            // Calcular suma de elementos válidos
            double suma = numbers.stream()
                    .filter(num -> num != null)
                    .mapToInt(Integer::intValue)
                    .sum();

            // Calcular y retornar promedio
            double promedio = suma / cantidadValidos;
            logger.debug("Cálculo del promedio: {} / {} = {}", suma, cantidadValidos, promedio);
            return promedio;
        } catch (ArithmeticException e) {
            logger.error("Error al calcular el promedio: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Encuentra el número mínimo en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Número mínimo
     * @throws NullPointerException     si la lista es null
     * @throws IllegalArgumentException si la lista está vacía
     */
    private static int encontrarMinimo(List<Integer> numbers) throws NullPointerException, IllegalArgumentException {
        if (numbers == null) {
            logger.error("La lista de números es null al buscar el mínimo");
            throw new NullPointerException("La lista de números no puede ser null");
        }

        if (numbers.isEmpty()) {
            logger.error("No se puede encontrar el mínimo en una lista vacía");
            throw new IllegalArgumentException("La lista no puede estar vacía para encontrar el mínimo");
        }

        Optional<Integer> min = numbers.stream()
                .filter(num -> num != null)
                .min(Integer::compareTo);

        return min.orElseThrow(() -> {
            logger.error("No se encontró ningún número válido en la lista");
            return new IllegalArgumentException("No hay números válidos en la lista");
        });
    }

    /**
     * Encuentra el número máximo en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Número máximo
     * @throws NullPointerException     si la lista es null
     * @throws IllegalArgumentException si la lista está vacía
     */
    private static int encontrarMaximo(List<Integer> numbers) throws NullPointerException, IllegalArgumentException {
        if (numbers == null) {
            logger.error("La lista de números es null al buscar el máximo");
            throw new NullPointerException("La lista de números no puede ser null");
        }

        if (numbers.isEmpty()) {
            logger.error("No se puede encontrar el máximo en una lista vacía");
            throw new IllegalArgumentException("La lista no puede estar vacía para encontrar el máximo");
        }

        Optional<Integer> max = numbers.stream()
                .filter(num -> num != null)
                .max(Integer::compareTo);

        return max.orElseThrow(() -> {
            logger.error("No se encontró ningún número válido en la lista");
            return new IllegalArgumentException("No hay números válidos en la lista");
        });
    }

    public static void main(String[] args) {
        try {
            logger.info("Iniciando la aplicación");
            logger.info("Bienvenido al programa de operaciones con números");

            List<Integer> numeros;
            int opcion = mostrarMenu();

            if (opcion == 1) {
                numeros = ingresarNumerosManual();
            } else {
                numeros = generarNumerosAleatorios();
            }

            printNumbers(numeros);

            // Cálculo de estadísticas
            int suma = calculateSum(numeros);
            double promedio = calcularPromedio(numeros);
            int minimo = encontrarMinimo(numeros);
            int maximo = encontrarMaximo(numeros);

            // Mostrar resultados
            logger.info("\n=== RESULTADOS ===");
            logger.info("Suma total: {}", suma);
            logger.info("Promedio: {}", String.format("%.2f", promedio));
            logger.info("Número mínimo: {}", minimo);
            logger.info("Número máximo: {}", maximo);

            logger.info("Aplicación finalizada exitosamente");
        } catch (IllegalArgumentException e) {
            logger.error("Error de argumento inválido: {}", e.getMessage(), e);
        } catch (NullPointerException e) {
            logger.error("Error de referencia nula: {}", e.getMessage(), e);
        } catch (ArithmeticException e) {
            logger.error("Error aritmético: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error inesperado: {}", e.getMessage(), e);
        } finally {
            scanner.close();
            logger.info("Recursos liberados");
        }
    }
}
