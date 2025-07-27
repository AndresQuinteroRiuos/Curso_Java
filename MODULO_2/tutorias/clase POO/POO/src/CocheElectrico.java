public class CocheElectrico extends Coche {
    private int capacidadBateria;

    public CocheElectrico(String color, String marca, int modelo, String numeroDePuertas, int cilindraje, int capacidadBateria) {
        super(color, marca, modelo, numeroDePuertas, cilindraje);
        this.capacidadBateria = capacidadBateria;
    }

    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(int capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }
}
