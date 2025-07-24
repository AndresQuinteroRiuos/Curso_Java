import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
      
        Book book1 = new Book("Gabriel Garcia Marquez", "Cien años de soledad", 123456789, 29.99);
        Book book2 = new Book("J.K. Rowling", "Harry Potter y la piedra filosofal", 987654321, 19.99);
        Book book3 = new Book("George Orwell", "1984", 112233445, 15.99);
        book2.obtenerPrecioConiva();
        book2.setPrecio(20.00);

        System.out.println("Precio con IVA de " .concat(String.valueOf(book2.getTitulo())) + ": " + book2.obtenerPrecioConiva());
       System.out.println("presio sin iva de " .concat(String.valueOf(book2.getTitulo())) + ": " + book2.getPrecio());
      
       List<Book> libros = new ArrayList<>();
        libros.add(book1);
        libros.add(book2);
        libros.add(book3);
        
        
        for (Book libro : libros) {
            System.out.println("Autor: " + libro.getAutor()
             + ", Título: " + libro.getTitulo()
              + ", ISBN: " + libro.getIsbn() 
              + ", Precio: $" + libro.getPrecio());
        }
    }
}
