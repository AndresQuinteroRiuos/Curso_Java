package com.example.repository;

import com.example.model.Nombre;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Nombre.
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Create,
 * Read, Update, Delete)
 * y otras operaciones útiles sobre la colección de nombres.
 *
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public interface NombreRepository {
    /**
     * Agrega un nuevo nombre a la colección.
     * 
     * @param nombre El nombre a agregar
     */
    void agregar(Nombre nombre);

    /**
     * Inserta un nombre en una posición específica.
     * 
     * @param posicion La posición donde insertar el nombre
     * @param nombre   El nombre a insertar
     * @throws IndexOutOfBoundsException si la posición está fuera de rango
     */
    void insertar(int posicion, Nombre nombre);

    /**
     * Obtiene un nombre por su posición.
     * 
     * @param posicion La posición del nombre a obtener
     * @return El nombre en la posición especificada
     * @throws IndexOutOfBoundsException si la posición está fuera de rango
     */
    Nombre obtener(int posicion);

    /**
     * Modifica un nombre en una posición específica.
     * 
     * @param posicion La posición del nombre a modificar
     * @param nombre   El nuevo nombre
     * @throws IndexOutOfBoundsException si la posición está fuera de rango
     */
    void modificar(int posicion, Nombre nombre);

    /**
     * Elimina un nombre específico de la colección.
     * 
     * @param nombre El nombre a eliminar
     */
    void eliminar(Nombre nombre);

    /**
     * Elimina el nombre en una posición específica.
     * 
     * @param posicion La posición del nombre a eliminar
     * @throws IndexOutOfBoundsException si la posición está fuera de rango
     */
    void eliminarPorPosicion(int posicion);

    /**
     * Verifica si existe un nombre en la colección.
     * 
     * @param nombre El nombre a buscar
     * @return true si el nombre existe, false en caso contrario
     */
    boolean existe(Nombre nombre);

    /**
     * Obtiene el número total de nombres en la colección.
     * 
     * @return El número de nombres
     */
    int obtenerTamanio();

    /**
     * Verifica si la colección está vacía.
     * 
     * @return true si la colección está vacía, false en caso contrario
     */
    boolean estaVacio();

    /**
     * Elimina todos los nombres de la colección.
     */
    void limpiar();

    /**
     * Obtiene una lista con todos los nombres.
     * 
     * @return Una nueva lista con todos los nombres
     */
    List<Nombre> obtenerTodos();
}