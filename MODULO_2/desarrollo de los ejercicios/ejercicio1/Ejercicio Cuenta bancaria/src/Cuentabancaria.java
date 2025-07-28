public class Cuentabancaria {
    private int NumeroCuenta;
    private String NombreTitular;
    private double Saldo;
    public Cuentabancaria(int numeroCuenta, String nombreTitular, double saldo) {
        this. NumeroCuenta = numeroCuenta;
        this. NombreTitular = nombreTitular;
        this.Saldo = saldo;
    }
    public int getNumeroCuenta() {
        return NumeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
       this. NumeroCuenta = numeroCuenta;
    }
    public String getNombreTitular() {
        return NombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.NombreTitular = nombreTitular;
    }
    public double getSaldo() {
        return Saldo;
    }
    @Override
    public String toString() {
        return "Cuentabancaria [NumeroCuenta=" + NumeroCuenta + ", NombreTitular=" + NombreTitular + ", Saldo=" + Saldo
                + "]";
    }
    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    // metdodo para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            Saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + Saldo);
        } else {
            System.out.println("Cantidad a depositar debe ser mayor que cero.");
        }
    }
    // método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= Saldo) {
            Saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + Saldo);
        } else if (cantidad > Saldo) {
            System.out.println("Fondos insuficientes para retirar esa cantidad.");
        } else {
            System.out.println("Cantidad a retirar debe ser mayor que cero.");
        }
    }
    //metodo para mostrar el saldo actual
    public static void mostrarSaldo(Cuentabancaria cuenta) {
        if (cuenta == null) {
            System.out.println("Cuenta bancaria no existe.");
            return;
        }
        System.out.println("hola: " + cuenta.getNombreTitular()+ " | Usted tiene un saldo de $: " + cuenta.getSaldo());
    }

    // Método de instancia para mostrar el saldo actual
    public void mostrarSaldoActual() {
        System.out.println("Hola: " + this.getNombreTitular() + " | Su saldo actual es: $" + this.getSaldo());
    }
}
