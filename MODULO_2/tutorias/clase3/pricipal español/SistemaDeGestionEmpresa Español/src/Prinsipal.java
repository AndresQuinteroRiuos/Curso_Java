// Clase principal para probar el sistema de gestión de empleados
public class Prinsipal {
    public static void main(String[] args) {
        // Crear un empleado genérico
        Empleado e1 = new Empleado(8, "Juan", 25.54);
        // Crear un electricista (Electrisista)
        Electrisista e2 = new Electrisista(8, "Pedro", 30.75, "Sí");

        // Llamar al método trabajar de cada empleado
        e1.trabajar();
        e2.trabajar();
    }
}
