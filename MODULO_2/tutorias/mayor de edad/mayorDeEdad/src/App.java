
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        /* crear un programa que resiba una edad y muestre si es mayor de edad o no.
        1. niño (0-12)
        2. adolescente (13-17)
        3. adulto (18 o mas)

        variables:edad

        variable:

        1. edad < 12= es niño
        2. edad >= 13 && edad <= 17 = es adolescente
        3. edad >= 18 = es adulto

       
        
      
         */
        int edad = 10; // Cambia este valor para probar diferentes edades
        Scanner entrada = new Scanner(System.in);

        do { 
            
      
        System.out.println("Ingrese su edad: ");
        edad = entrada.nextInt();
        entrada.nextLine();

        if (edad < 0) {
            System.out.println("La edad no puede ser negativa. Intente de nuevo.");
            }
        
        } while (edad < 0);
       
        System.out.printf( "Edad ingresada: %d\n", edad);

    
        if (edad < 12 && edad >= 0) {
            System.out.println("Es niño");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Es adolescente");
        } else 
            System.out.println("Es adulto");
       entrada.close();
        
                // Ejemplo de uso
                // System.out.println("La persona es: " + clasificarEdad(edad));
        
            }
        }

    
   
