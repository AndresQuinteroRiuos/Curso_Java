package OrientadoObjetos;

public class Camion extends Vehiculo implements Arrancable {

    private double capacidadCarga;

    public Camion(String marca, String modelo, int anio, double capacidadCarga) {
        super(marca, modelo, anio);
        this.capacidadCarga = capacidadCarga;

    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Camion [capacidadCarga=" + capacidadCarga + "]";
    }
    @Override
    public void mostrarInformacion() {
        System.err.println("================================");
        System.out.println("Informacion del Vehiculo Camion:");
        System.err.println("================================");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Año: " + getAnio());
        System.out.println("Capacidad de carga: " + capacidadCarga + "kg");
    }

    @Override
    public void mover() {
        System.out.println("El camión esta transportando carga por la carretera.");
    }
    
    @Override
    public void arrancar() {
        System.out.println("El camión ha arrancado.");
    }
    
}

