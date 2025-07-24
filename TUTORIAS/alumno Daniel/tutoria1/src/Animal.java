package src;
//sintasix de una clasee


public class Animal {

    //sintasix de la clase Animal
    
    private String nombre;
    private String raza;
    private double peso;
    private int edad;
    private String color; //atributo

    //sintasix para metodos

    /*lleva el nombre de la clase
     * no lleva tipo de dato no devuelve nada(no llevavoid)
     se escirbe un metodo cualquiera, solo que es especial
     */

      public Animal(String nombre, String raza, double peso, String color, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
        this.edad = edad;
        
        //encapsular();
        //public cualquier lugar
        //private solo dentro de la clase o el mismo paquete
        //default solo dentro del mismo paquete

        //protectec  //private solo dentro de la clase una subclase o el mismo paquete

        //getters podemos ver el contenido de los atributos ejemplo edad
        //setters podemos modificar los atributos ejemplo edad
      }  

        public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getColor() {
        return color;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }}

    /*public void correr() { //metodo correr
        System.out.println("El animal está corriendo");
    }

    public void comer() { //metodo comer
        System.out.println("El animal está comiendo");
    }
    
    // Sintaxis para crear una instancia o objeto

    Animal perroPitbullTerrier   = new Animal("Perro Pitbull", 5);


    //video juego

    //atributos 

    /*nombre
     * clsejuego
     * punteje
     * 
     * disparar()
     * correr()
     * saltar()     */


    /*public void peso() { //metodo peso
        System.out.println("El peso del animal es: " + peso + " kg");
    }
    */
   