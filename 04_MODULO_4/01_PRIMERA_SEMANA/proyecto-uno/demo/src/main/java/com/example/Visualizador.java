package com.example;

import java.util.List;

/**
 * Clase que maneja la visualización de la información
 */
public class Visualizador {

    /**
     * Muestra el estado actual de la lista
     * 
     * @param mensaje Mensaje descriptivo
     * @param lista   Lista a mostrar
     */
    public void mostrarEstado(String mensaje, List<String> lista) {
        System.out.println(mensaje + ": " + lista);
    }

    /**
     * Muestra un elemento individual
     * 
     * @param mensaje  Mensaje descriptivo
     * @param elemento Elemento a mostrar
     */
    public void mostrarElemento(String mensaje, String elemento) {
        System.out.println(mensaje + ": " + elemento);
    }

    /**
     * Muestra un resultado booleano
     * 
     * @param mensaje   Mensaje descriptivo
     * @param resultado Resultado a mostrar
     */
    public void mostrarResultado(String mensaje, boolean resultado) {
        System.out.println(mensaje + ": " + resultado);
    }

    /**
     * Muestra información numérica
     * 
     * @param mensaje Mensaje descriptivo
     * @param valor   Valor a mostrar
     */
    public void mostrarNumero(String mensaje, int valor) {
        System.out.println(mensaje + ": " + valor);
    }

    /**
     * Muestra una lista en formato vertical
     * 
     * @param titulo Título de la lista
     * @param lista  Lista a mostrar
     */
    public void mostrarListaVertical(String titulo, List<String> lista) {
        System.out.println("\n" + titulo + ":");
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}