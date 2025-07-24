package interfaces;

import modulo.cancion;
import java.util.List;

public interface reproductor {

    void reproducir(List<cancion> canciones, String titulo);
    void pausar(List<cancion> canciones, String titulo);
    void agregarcancion(List<cancion> canciones, cancion cancion);
    void mostrarcanciones(List<cancion> canciones);
    void eliminarcancion(List<cancion> canciones, String titulo);
    void buscarcancion(List<cancion> canciones, String titulo);

}
    


