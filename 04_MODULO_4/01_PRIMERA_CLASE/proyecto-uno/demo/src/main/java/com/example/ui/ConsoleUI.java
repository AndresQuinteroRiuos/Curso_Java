package com.example.ui;

import com.example.service.NombreService;
import java.util.List;

/**
 * Clase que maneja la interfaz de usuario en consola.
 * Esta clase es responsable de la presentación de datos al usuario
 * y la demostración de las funcionalidades del sistema.
 *
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public class ConsoleUI {
    /** Servicio de nombres utilizado para las operaciones */
    private final NombreService nombreService;

    /**
     * Constructor que inicializa la interfaz de usuario.
     * 
     * @param nombreService El servicio de nombres a utilizar
     */
    public ConsoleUI(NombreService nombreService) {
        this.nombreService = nombreService;
    }

    /**
     * Muestra un mensaje con una lista de elementos.
     * 
     * @param mensaje El mensaje descriptivo
     * @param lista   La lista de elementos a mostrar
     */
    public void mostrarEstado(String mensaje, List<String> lista) {
        System.out.println(mensaje + ": " + lista);
    }

    public void mostrarResultado(String mensaje, boolean resultado) {
        System.out.println(mensaje + ": " + resultado);
    }

    public void mostrarNumero(String mensaje, int valor) {
        System.out.println(mensaje + ": " + valor);
    }

    public void mostrarListaVertical(String titulo, List<String> lista) {
        System.out.println("\n" + titulo + ":");
        lista.forEach(System.out::println);
    }

    public void ejecutarDemostracion() {
        demostrarOperacionesBasicas();
        demostrarOperacionesAvanzadas();
        demostrarVisualizacion();
    }

    private void demostrarOperacionesBasicas() {
        nombreService.agregarNombre("Juan");
        nombreService.agregarNombre("María");
        nombreService.agregarNombre("Pedro");
        mostrarEstado("Lista inicial", nombreService.obtenerTodosLosNombres());

        nombreService.insertarNombre(1, "Ana");
        mostrarEstado("Después de insertar", nombreService.obtenerTodosLosNombres());
    }

    private void demostrarOperacionesAvanzadas() {
        nombreService.modificarNombre(2, "Carlos");
        mostrarEstado("Después de modificar", nombreService.obtenerTodosLosNombres());

        nombreService.eliminarNombre("Pedro");
        nombreService.eliminarPorPosicion(0);
        mostrarEstado("Después de eliminar", nombreService.obtenerTodosLosNombres());
    }

    private void demostrarVisualizacion() {
        mostrarResultado("¿Existe María?", nombreService.existeNombre("María"));
        mostrarNumero("Cantidad de nombres", nombreService.obtenerCantidadNombres());
        mostrarResultado("¿Lista vacía?", nombreService.listaVacia());

        nombreService.limpiarLista();
        mostrarEstado("Después de limpiar", nombreService.obtenerTodosLosNombres());

        nombreService.agregarNombre("Luis");
        nombreService.agregarNombre("Ana");
        nombreService.agregarNombre("Sofia");
        mostrarListaVertical("Lista final", nombreService.obtenerTodosLosNombres());
    }
}