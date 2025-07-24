package modulo;
import interfaces.reproductor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicios.reproductorCancion;

public class principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<cancion> canciones = new ArrayList<>();
        reproductor reproductor = new reproductorCancion();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu Biblioteca");
            System.out.println("1. Agregar canción");
            System.out.println("2. Mostrar canciones");
            System.out.println("3. Eliminar canción");
            System.out.println("4. Reproducir canción");
            System.out.println("5. Pausar canción");
            System.out.println("6. Buscar canción");
            System.out.println("7. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el titulo de la canción");
                    String titulo = sc.nextLine();
                    System.out.println("Ingrese el artista de la canción");
                    String artista = sc.nextLine();
                    System.out.println("Ingrese la duración de la canción");
                    int duracion = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    reproductor.agregarcancion(canciones, new cancion(titulo, artista, duracion));
                    break;
                case 2:
                    reproductor.mostrarcanciones(canciones);
                    break;
                case 3:
                    System.out.println("Ingrese el titulo de la canción a eliminar");
                    String buscar = sc.nextLine();
                    reproductor.eliminarcancion(canciones, buscar);
                    break;
                case 4:
                    System.out.println("Ingrese el titulo de la canción a reproducir");
                    String escuchar = sc.nextLine();
                    reproductor.reproducir(canciones, escuchar);
                    break;
                case 5:
                    System.out.println("Ingrese el titulo de la canción a pausar");
                    String pausar = sc.nextLine();
                    reproductor.pausar(canciones, pausar);
                    break;
                case 6:
                    System.out.println("Ingrese el titulo de la canción a buscar");
                    String busqueda = sc.nextLine();
                    reproductor.buscarcancion(canciones, busqueda);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        sc.close();
    }
}
