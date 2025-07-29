package Ejercicios_Adicionales;

import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double numero1 = entrada.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numero2 = entrada.nextDouble();

        double suma = numero1 + numero2;
        double resta = numero1 - numero2;
        double multiplicacion = numero1 * numero2;
        double Division = numero1 / numero2;


        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        
        if (numero2 != 0) {
            System.out.println("División: " + Division);
        } else {
            System.out.println("No se puede dividir entre cero.");
        }

        ntrada.close(); 
    }
}

