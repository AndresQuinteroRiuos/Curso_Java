package Ejercicios_Adicionales;

public class CostoOrdenador {
    
        public static void main(String[] args) {
            double precioOriginal = 660.00;
            double descuento = 0.10;
    
            double cantidadDescontada = precioOriginal * descuento;
            double precioFinal = precioOriginal - cantidadDescontada;
    
            System.out.printf(" Precio original: %.2f€\n", precioOriginal);
            System.out.printf(" Descuento aplicado (10%%): %.2f€\n", cantidadDescontada);
            System.out.printf(" Precio final a pagar: %.2f€\n", precioFinal);
        }
    }
    
    

