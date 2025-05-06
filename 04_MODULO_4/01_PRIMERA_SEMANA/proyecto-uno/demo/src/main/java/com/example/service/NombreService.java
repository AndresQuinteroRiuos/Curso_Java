package com.example.service;

import java.util.List;

/**
 * Interfaz que define los servicios de negocio para la gestión de nombres.
 * Esta interfaz proporciona una capa de abstracción para las operaciones
 * de negocio relacionadas con los nombres.
 *
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public interface NombreService {
    /**
     * Agrega un nuevo nombre al sistema.
     * 
     * @param valor El valor del nombre a agregar
     * @throws IllegalArgumentException si el valor es null o vacío
     */
    void agregarNombre(String valor);

    void insertarNombre(int posicion, String valor);

    String obtenerNombre(int posicion);

    void modificarNombre(int posicion, String nuevoValor);

    void eliminarNombre(String valor);

    void eliminarPorPosicion(int posicion);

    boolean existeNombre(String valor);

    int obtenerCantidadNombres();

    boolean listaVacia();

    void limpiarLista();

    List<String> obtenerTodosLosNombres();
}