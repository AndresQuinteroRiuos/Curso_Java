package Ejercicios_Adicionales;

import java.util.Scanner;
public class Rectangulo {
   


    

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresa la longitud del rectángulo: ");
        double longitud = entrada.nextDouble();

        System.out.print("Ingresa el ancho del rectángulo: ");
        double ancho = entrada.nextDouble();

        double area = longitud * ancho;
        double perimetro = 2 * (longitud + ancho);

        System.out.println("Área del rectángulo: " + area);
        System.out.println("Perímetro del rectángulo: " + perimetro);

        entrada.close();
    }
}

    

