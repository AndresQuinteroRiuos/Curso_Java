package Ejercicios_Adicionales;
import java.util.Scanner;

public class MediaAritmetica {
    


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println(" Cálculo de la Media Aritmética");
        
        System.out.print(" Ingresa el primer número: ");
        double numero1 = entrada.nextDouble();

        System.out.print(" Ingresa el segundo número: ");
        double numero2 = entrada.nextDouble();

        System.out.print("Ingresa el tercer número: ");
        double numero3 = entrada.nextDouble();

        double media = (numero1 + numero2 + numero3) / 3;

        System.out.printf(" La media aritmética es: %.2f\n", media);

        entrada.close();
    }
}

    

