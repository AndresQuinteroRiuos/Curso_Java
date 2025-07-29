package Ejercicios_Adicionales;

public class PrecioError {
    
public class calculadora {
    public static void main(String[] args) {
         // Precio de 100 gramos
         double precioPor100g = 5.95;
         // Precio anunciado por kilo
         double precioPorKiloAnunciado = 29.75;
         // Calcular el precio real por kilo (1 kg = 1000 g, así que 10 x 100g)
         double precioPorKiloCalculado = precioPor100g * 10;
 
         System.out.println("Precio por kilo calculado: " + precioPorKiloCalculado + "€");
         System.out.println("Precio por kilo anunciado: " + precioPorKiloAnunciado + "€");
 
         if ((precioPorKiloCalculado - precioPorKiloAnunciado) < 0.01) {
             System.out.println("El precio anunciado por kilo es correcto.");
         } else {
             System.out.println("El precio anunciado por kilo NO es correcto.");
         }
           
        }}
    

    
}
