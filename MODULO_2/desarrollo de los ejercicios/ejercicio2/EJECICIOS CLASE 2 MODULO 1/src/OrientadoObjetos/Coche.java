package OrientadoObjetos;

public class Coche extends Vehiculo implements Arrancable {
    private int NumeroPuertas;
    
    public Coche(String marca, String modelo, int anio, int NumeroPuertas) {
        super(marca, modelo, anio);
        this.NumeroPuertas = NumeroPuertas;

    }

    public int getNumeroPuertas() {
        return NumeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.NumeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Coche [NumeroPuertas=" + NumeroPuertas + "]";
    }
  
    

    @Override
    public void mostrarInformacion() {
        System.err.println("================================");
        System.out.println("Informacion del Vehiculo Coche:");
        System.err.println("================================");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Anio: " + getAnio());
        System.out.println("Numero de puertas: " + getNumeroPuertas());
    }

    @Override
    public void mover() {
        System.out.println("El coche está circulando por la ciudad.");
    }

    @Override
    public void arrancar() {
        System.out.println("El coche ha arrancado.");
    }
}
