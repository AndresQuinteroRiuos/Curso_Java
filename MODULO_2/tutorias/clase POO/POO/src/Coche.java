public class Coche {
 private  String Color;
 private String Marca;
 private int Modelo;
 private  String NumeroDePuertas;
 private  int Cilindraje;
 private Double Velocidadactual;

 public void arrancar() {
  System.out.println("El carro está arrancando.");
 }

 public Coche(String color, String marca, int modelo, String numeroDePuertas, int cilindraje) {
    this.Color = color;
    this.Marca = marca;
    this.Modelo = modelo;
    this.NumeroDePuertas = numeroDePuertas;
    this.Cilindraje = cilindraje;
    this.Velocidadactual = 0.0;
 }

 public String getColor() {
    return Color;
 }

 public void setColor(String color) {
    Color = color;
 }

 public String getMarca() {
    return Marca;
 }

 public void setMarca(String marca) {
    Marca = marca;
 }

 public int getModelo() {
    return Modelo;
 }

 public void setModelo(int modelo) {
    Modelo = modelo;
 }

 public String getNumeroDePuertas() {
    return NumeroDePuertas;
 }

 public void setNumeroDePuertas(String numeroDePuertas) {
    NumeroDePuertas = numeroDePuertas;
 }

 public int getCilindraje() {
    return Cilindraje;
 }

 public void setCilindraje(int cilindraje) {
    Cilindraje = cilindraje;
 }

 public Double getVelocidadactual() {
    return Velocidadactual;
 }

 public void setVelocidadactual(Double velocidadactual) {
    Velocidadactual = velocidadactual;
 }
 public void acelerar(double incremento) {
   
    if (incremento > 0 ) {
    this.Velocidadactual+=incremento;
        System.out.println("El coche ha acelerado a " + Velocidadactual + " km/h.");
    } else 
 {
        System.out.println("El incremento debe ser positivo para acelerar.");
    }    
}}




