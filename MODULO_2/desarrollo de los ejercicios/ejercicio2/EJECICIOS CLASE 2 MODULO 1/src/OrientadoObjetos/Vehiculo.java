package OrientadoObjetos;

public abstract class Vehiculo {
    private String  Marca;
    private  String Modelo;
    private int anio;
    public Vehiculo(String marca, String modelo, int anio) {
        this. Marca = marca;
        this .Modelo = modelo;
        this.anio = anio;
    }
    public String getMarca() {
        return Marca;
    }
    @Override
    public String toString() {
        return "Vehiculo [Marca=" + Marca + ", Modelo=" + Modelo + ", anio=" + anio + "]";
    }
    public void setMarca(String marca) {
        this.Marca = marca;
    }
    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String modelo) {
       this. Modelo = modelo;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    // Declarar el métodos abstractos para que las subclases lo sobrescriban
    public abstract void mostrarInformacion();
    public abstract void mover();
}
