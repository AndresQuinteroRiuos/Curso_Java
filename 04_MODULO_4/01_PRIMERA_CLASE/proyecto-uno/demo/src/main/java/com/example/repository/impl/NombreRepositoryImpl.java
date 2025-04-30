package com.example.repository.impl;

import com.example.model.Nombre;
import com.example.repository.NombreRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de {@link NombreRepository} que utiliza un ArrayList como
 * estructura de almacenamiento.
 * Esta clase proporciona una implementación concreta de todas las operaciones
 * definidas en la interfaz del repositorio.
 *
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 * @see NombreRepository
 * @see ArrayList
 */
public class NombreRepositoryImpl implements NombreRepository {
    /** Lista que almacena los nombres */
    private final List<Nombre> nombres;

    /**
     * Constructor que inicializa la lista de nombres.
     */
    public NombreRepositoryImpl() {
        this.nombres = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregar(Nombre nombre) {
        nombres.add(nombre);
    }

    @Override
    public void insertar(int posicion, Nombre nombre) {
        nombres.add(posicion, nombre);
    }

    @Override
    public Nombre obtener(int posicion) {
        return nombres.get(posicion);
    }

    @Override
    public void modificar(int posicion, Nombre nombre) {
        nombres.set(posicion, nombre);
    }

    @Override
    public void eliminar(Nombre nombre) {
        nombres.remove(nombre);
    }

    @Override
    public void eliminarPorPosicion(int posicion) {
        nombres.remove(posicion);
    }

    @Override
    public boolean existe(Nombre nombre) {
        return nombres.contains(nombre);
    }

    @Override
    public int obtenerTamanio() {
        return nombres.size();
    }

    @Override
    public boolean estaVacio() {
        return nombres.isEmpty();
    }

    @Override
    public void limpiar() {
        nombres.clear();
    }

    @Override
    public List<Nombre> obtenerTodos() {
        return new ArrayList<>(nombres);
    }
}