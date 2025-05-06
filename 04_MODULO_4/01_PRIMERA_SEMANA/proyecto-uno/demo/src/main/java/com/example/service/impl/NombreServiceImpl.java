package com.example.service.impl;

import com.example.model.Nombre;
import com.example.repository.NombreRepository;
import com.example.service.NombreService;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de nombres
 */
public class NombreServiceImpl implements NombreService {
    private final NombreRepository repository;

    public NombreServiceImpl(NombreRepository repository) {
        this.repository = repository;
    }

    @Override
    public void agregarNombre(String valor) {
        repository.agregar(new Nombre(valor));
    }

    @Override
    public void insertarNombre(int posicion, String valor) {
        repository.insertar(posicion, new Nombre(valor));
    }

    @Override
    public String obtenerNombre(int posicion) {
        return repository.obtener(posicion).getValor();
    }

    @Override
    public void modificarNombre(int posicion, String nuevoValor) {
        repository.modificar(posicion, new Nombre(nuevoValor));
    }

    @Override
    public void eliminarNombre(String valor) {
        repository.eliminar(new Nombre(valor));
    }

    @Override
    public void eliminarPorPosicion(int posicion) {
        repository.eliminarPorPosicion(posicion);
    }

    @Override
    public boolean existeNombre(String valor) {
        return repository.existe(new Nombre(valor));
    }

    @Override
    public int obtenerCantidadNombres() {
        return repository.obtenerTamanio();
    }

    @Override
    public boolean listaVacia() {
        return repository.estaVacio();
    }

    @Override
    public void limpiarLista() {
        repository.limpiar();
    }

    @Override
    public List<String> obtenerTodosLosNombres() {
        return repository.obtenerTodos()
                .stream()
                .map(Nombre::getValor)
                .collect(Collectors.toList());
    }
}