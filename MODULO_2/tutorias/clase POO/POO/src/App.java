public class App {
    public static void main(String[] args) throws Exception {
        Coche miCoche = new Coche("Rojo", "Toyota", 2022, "4", 2000);
        miCoche.arrancar();
        System.out.println("Color: " + miCoche.getColor()+
                           ", Marca: " + miCoche.getMarca() +
                           ", Modelo: " + miCoche.getModelo() +
                           ", Número de Puertas: " + miCoche.getNumeroDePuertas() +
                           ", Cilindraje: " + miCoche.getCilindraje());
   miCoche.acelerar(50);
                        }
}
