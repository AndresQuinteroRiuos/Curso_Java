package Ejercicios_Adicionales;
import java.util.Scanner;

public class ConvercionTemperatura {
   


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print(" Ingresa la temperatura en grados Celsius: ");
        double celsius = entrada.nextDouble();

        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;

        System.out.printf(" Temperatura en Fahrenheit: %.2f°F\n", fahrenheit);
        System.out.printf(" Temperatura en Kelvin: %.2f K\n", kelvin);

        entrada.close();
    
}

    
}
