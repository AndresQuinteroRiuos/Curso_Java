package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja las operaciones básicas de una lista de nombres
 */
public class ListaManager {
    private List<String> nombres;

    public ListaManager() {
        this.nombres = new ArrayList<>();
    }

    /**
     * Agrega un nombre a la lista
     * 
     * @param nombre Nombre a agregar
     */
    public void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    /**
     * Inserta un nombre en una posición específica
     * 
     * @param posicion Posición donde insertar
     * @param nombre   Nombre a insertar
     */
    public void insertarNombre(int posicion, String nombre) {
        nombres.add(posicion, nombre);
    }

    /**
     * Obtiene un nombre por su posición
     * 
     * @param posicion Posición del nombre
     * @return El nombre en la posición especificada
     */
    public String obtenerNombre(int posicion) {
        return nombres.get(posicion);
    }

    /**
     * Modifica un nombre en una posición específica
     * 
     * @param posicion    Posición a modificar
     * @param nuevoNombre Nuevo nombre
     */
    public void modificarNombre(int posicion, String nuevoNombre) {
        nombres.set(posicion, nuevoNombre);
    }

    /**
     * Elimina un nombre específico
     * 
     * @param nombre Nombre a eliminar
     */
    public void eliminarNombre(String nombre) {
        nombres.remove(nombre);
    }

    /**
     * Elimina un nombre por su posición
     * 
     * @param posicion Posición a eliminar
     */
    public void eliminarPorPosicion(int posicion) {
        nombres.remove(posicion);
    }

    /**
     * Verifica si existe un nombre
     * 
     * @param nombre Nombre a buscar
     * @return true si existe, false si no
     */
    public boolean existeNombre(String nombre) {
        return nombres.contains(nombre);
    }

    /**
     * Obtiene el tamaño de la lista
     * 
     * @return Número de elementos en la lista
     */
    public int obtenerTamanio() {
        return nombres.size();
    }

    /**
     * Verifica si la lista está vacía
     * 
     * @return true si está vacía, false si no
     */
    public boolean estaVacia() {
        return nombres.isEmpty();
    }

    /**
     * Limpia la lista
     */
    public void limpiarLista() {
        nombres.clear();
    }

    /**
     * Obtiene la lista completa
     * 
     * @return Lista de nombres
     */
    public List<String> obtenerLista() {
        return new ArrayList<>(nombres);
    }
}