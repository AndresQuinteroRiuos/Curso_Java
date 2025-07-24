public class Book {

    private String autor;
    private String titulo;
    private int isbn;
    private double precio;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


    public String getTitulo() {
        return titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public  double obtenerPrecioConiva() {
        return this.precio  * 1.19;
    }

    public double actualizarPrecio(double nuevoPrecio) {
             

               if (nuevoPrecio >0) {

                  return this.precio= nuevoPrecio;
              
               }
               else {
                     System.out.println("El precio no puede ser negativo.");
                     return this.precio;
               }

    }

    public Book(String autor, String titulo, int isbn, double precio) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
    }

    public Book(){
        this.autor = "";
        this.titulo = "";
        this.isbn = 0;
        this.precio = 0.0;

    }
    
    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return String.format(""" 
        Autor: %s
        Titulo: %s
        ISBN: %d
        Precio: %.2f
        """, autor, titulo, isbn, precio);

    }

}
