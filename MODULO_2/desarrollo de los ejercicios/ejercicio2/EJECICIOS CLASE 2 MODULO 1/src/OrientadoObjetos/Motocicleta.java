package OrientadoObjetos;

public class Motocicleta extends Vehiculo implements Arrancable {

    private int cilindrada;

    public Motocicleta(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
     @Override
    
    public void mostrarInformacion() {
        System.err.println("=====================================");
        System.out.println("Informacion del Vehiculo Motocicleta:");
        System.err.println("=====================================");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Anio: " + getAnio());
        System.out.println("Cilindrada: " + getCilindrada());
    
    }
    @Override
    public String toString() {
        return "Motocicleta [cilindrada=" + cilindrada + "]";
   

    }
    @Override
    public void mover() {
        System.out.println("La motocicleta está acelerando en la autopista.");
    }

    @Override
    public void arrancar() {
        System.out.println("La motocicleta ha arrancado.");
    }
}
