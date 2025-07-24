import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
      var input = new Scanner(System.in);

      var salir = false;

      do { 
        System.out.println("""
        . : ejercicios :.
        =========================================
        1. Determinar si un número es positivo
        9. venta de camisas
        0. Salir
        """);
        var option = input.nextInt();

        input.nextLine(); // Limpiar el buffer

        switch (option) {
          case 1:
            verificarNumero01(input); // Call the method from Ejercicio1
            break;
          case 9:
             ventaCamisas09(input); // Call the method from Ejercicio9
            System.out.println("Venta de camisas");
            break;
          case 0:
            salir = true;
            break;

          default:
            System.out.println("Opción inválida");
            break;
        }

      } while (!salir);
        System.out.println("¡Hasta luego!");

      input.close();
    }
  
    private static void ventaCamisas09(Scanner input) {
    

        System.out.print("por favor ingresa la cantidad de camisas vendidas: ");
       var camisasVendidas = input.nextInt();
        input.nextLine(); // Limpiar el buffer

        if (camisasVendidas >= 0) { // Validar el rango de camisas
           
          int precio ;

          if (camisasVendidas <= 50) {
            precio = 50_000;
          } else if (camisasVendidas > 50 && camisasVendidas <= 100) {
            precio = 45_000;
          } else if (camisasVendidas > 100 && camisasVendidas <= 150) {
            precio = 40_000;
          } else if (camisasVendidas > 150 && camisasVendidas <= 200) {
            precio = 35_000;
          } else {
            precio = 25_000;
          }
          System.out.printf("El precio por camisa es: %d%n", precio);

          int precioTotal = precio * camisasVendidas;

          System.out.printf("El precio total es: %d%n", precioTotal);
        }
}
    private static void verificarNumero01(Scanner input) {
        System.out.print("Ingrese un número a evaluar: ");
        var numero = input.nextInt();
        /*escriba un programa que determine si un número es positivo, negativo o cero */
        

        if (numero > 0) {
            System.out.println("El número " + numero + " es positivo.");
        } else if (numero < 0) {
            System.out.println("El número " + numero + " es negativo.");
        } else {
            System.out.println("El número es cero.");
        }
    }
}

