package OrientadoObjetos;

public class App {
    public static void main(String[] args)  {
        Vehiculo miCamion = new Camion("Volvo", "FH16", 2021, 25000.0);
        Vehiculo miCoche = new Coche("Toyota", "Corolla", 2022, 4);
        Vehiculo miMoto = new Motocicleta("Honda", "CBR500R", 2023, 500);
        
        miCamion.mostrarInformacion();
        miCoche.mostrarInformacion();
        miMoto.mostrarInformacion();

        System.out.println("\n--- Demostracion de Polimorfismo (Vehiculo) ---");
        Vehiculo vehiculo1 = miCoche;
        Vehiculo vehiculo2 = miMoto;
        Vehiculo vehiculo3 = miCamion;

        vehiculo1.mostrarInformacion();
        vehiculo1.mover();
        System.out.println("---");
        vehiculo2.mostrarInformacion();
        vehiculo2.mover();
        System.out.println("---");
        vehiculo3.mostrarInformacion();
        vehiculo3.mover();

        System.out.println("\n--- Demostración de Polimorfismo (Arrancable) ---");
        Arrancable arrancable1 = (Arrancable) miCoche;
        Arrancable arrancable2 = (Arrancable) miMoto;
        Arrancable arrancable3 = (Arrancable) miCamion;

        arrancable1.arrancar();
        arrancable2.arrancar();
        arrancable3.arrancar();
    }
}
