import java.util.Scanner;

public class PedirPalabras {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Pedir las tres palabras al usuario
        System.out.print("Introduzca palabra 1: ");
        String palabra1 = scanner.nextLine();
        
        System.out.print("Introduzca palabra 2: ");
        String palabra2 = scanner.nextLine();
        
        System.out.print("Introduzca palabra 3: ");
        String palabra3 = scanner.nextLine();
        
        // Mostrar las tres palabras en pantalla
        System.out.println(palabra1 + " " + palabra2 + " " + palabra3);
        
        // Cerrar el scanner
        scanner.close();
    }
} 