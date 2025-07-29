package Ejercicios_Adicionales;

public class PrecioAntesDescuento {
    
        public static void main(String[] args) {
            double precioConDescuento = 34.00;
            double porcentajeDescuento = 15.0;
            
            double porcentajeRestante = 100.0 - porcentajeDescuento;
            double precioOriginal = precioConDescuento / (porcentajeRestante / 100.0);
    
            System.out.printf(" Precio pagado: %.2f€\n", precioConDescuento);
            System.out.printf(" Descuento aplicado: %.1f%%\n", porcentajeDescuento);
            System.out.printf(" Precio antes del descuento: %.2f€\n", precioOriginal);
        }
    }
    
    

