
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
      
    // Crear la cuenta bancaria antes del menú
    Cuentabancaria cuenta = inicio(sc);
    boolean continuar   =   true;
    int menu;
do {
    System.out.println("===============================");
    System.out.println("Bienvenido al sistema bancario");
    System.out.println("================================");
    System.out.println("Seleccione una opción:");
    System.out.println("1. Mostrar saldo");
    System.out.println("2. Depositar dinero");
    System.out.println("3. Retirar dinero");
    System.out.println("4. Salir");
    menu = sc.nextInt();
    switch(menu) {
        case 1:
        cuenta.mostrarSaldoActual();
        break;
        case 2:
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidadDeposito = sc.nextDouble();
        cuenta.depositar(cantidadDeposito);
        break;
        case 3:
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidadRetiro = sc.nextDouble();
        cuenta.retirar(cantidadRetiro);
        break;
        case 4:
        continuar = false;
        System.out.println("Gracias por usar el sistema bancario. ¡Hasta luego!");
        sc.close();
        break;
        default:
        System.out.println("Opcion no valida");
        break;
    }
    } while(continuar); 
        
    }

    public static Cuentabancaria inicio( Scanner sc) {
        System.out.println("=======================");
        System.out.println("|   hola bienvenido   |");
        System.out.println("=======================");
        System.out.print("ingresa tu nombre:");
       
        String NombreTitular = sc.nextLine();

        Cuentabancaria  Persona = new Cuentabancaria(1, NombreTitular, 0.0);
   
        return Persona;
    
    }

}
       
