package servicios;

import interfaces.reproductor;
import modulo.cancion;
import java.util.List;

public class reproductorCancion implements reproductor{

    @Override
    public void reproducir(List<cancion> canciones, String titulo) {
        for (cancion c : canciones) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Reproduciendo cancion: " + c.getTitulo());
                return;
            }
        }
        System.out.println("Canción no encontrada: " + titulo);
    }

    @Override
    public void pausar(List<cancion> canciones, String titulo) {
        System.out.println("Reproducción pausada de: " + titulo);
    }

    @Override
    public void mostrarcanciones(List<cancion> canciones) {
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones para mostrar.");
        } else {
            for (int i = 0; i < canciones.size(); i++)  {
                System.out.println((i+1) + ". " + canciones.get(i).mostrarInformacion());
            }
        }
    }

    @Override
    public void agregarcancion(List<cancion> canciones, cancion cancion) {
        canciones.add(cancion);
        System.out.println("Canción agregada: " + cancion.getTitulo());
    }

    @Override
    public void eliminarcancion(List<cancion> canciones, String titulo) {
        boolean removed = canciones.removeIf(c -> c.getTitulo().equalsIgnoreCase(titulo));
        if (removed) {
            System.out.println("Canción eliminada: " + titulo);
        } else {
            System.out.println("Canción no encontrada: " + titulo);
        }
    }

    @Override
    public void buscarcancion(List<cancion> canciones, String titulo) {
        for (cancion c : canciones) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Canción encontrada: ");
                System.out.println(c.mostrarInformacion());
                return;
            }
        }
        System.out.println("Canción no encontrada: " + titulo);
    }
}
    




