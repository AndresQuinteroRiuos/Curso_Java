package com.example.model;

/**
 * Clase modelo que representa un nombre en el sistema.
 * Esta clase encapsula la información básica de un nombre y proporciona
 * métodos para acceder y modificar su valor.
 * 
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public class Nombre {
    /** El valor del nombre almacenado */
    private String valor;

    /**
     * Constructor que crea un nuevo objeto Nombre.
     * 
     * @param valor El valor inicial del nombre
     * @throws IllegalArgumentException si el valor es null
     */
    public Nombre(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El valor del nombre no puede ser null");
        }
        this.valor = valor;
    }

    /**
     * Obtiene el valor actual del nombre.
     * 
     * @return El valor del nombre
     */
    public String getValor() {
        return valor;
    }

    /**
     * Establece un nuevo valor para el nombre.
     * 
     * @param valor El nuevo valor del nombre
     * @throws IllegalArgumentException si el valor es null
     */
    public void setValor(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El valor del nombre no puede ser null");
        }
        this.valor = valor;
    }

    /**
     * Devuelve una representación en cadena del nombre.
     * 
     * @return El valor del nombre como String
     */
    @Override
    public String toString() {
        return valor;
    }
}