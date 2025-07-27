public class App {
    public static void main(String[] args) throws Exception {
        // Creando empresa
        var company = new Enterprise("Cesar's Bar");
        
        // Creando directivo
        var cesar = new Directive("Cesar", 25, 3_000d, "CEO");
        
        // Creando empleados
        var luisa = new Employee("Luisa", 20, 1_000d);
        luisa.setManager(cesar);
        
        var manuel = new Employee("Manuel", 26, 1_500d);
        manuel.setManager(cesar);
        
        // Agregando empleados a la empresa
        company.addEmployee(0, cesar);
        company.addEmployee(1, luisa);
        company.addEmployee(2, manuel);

        // Agregando empleados al directivo
        cesar.addEmployee(0, luisa);
        cesar.addEmployee(1, manuel);

        // Creando cliente
        var santiago = new Client("Santiago", 30, "123456789");
        
        // Agregando cliente a la empresa
        company.addClient(0, santiago);

        // Mostrando empleados
        System.out.println("=== EMPLEADOS ===");
        var employees = company.getEmployees();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].mostrarDatos();
            }
        }
        
        // Mostrando clientes
        System.out.println("\n=== CLIENTES ===");
        var clients = company.getClients();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                clients[i].mostrarDatos();
            }
        }
        
        // Mostrando información adicional
        System.out.println("\n=== INFORMACIÓN DE LA EMPRESA ===");
        System.out.println("Empresa: " + company.getName());
        System.out.println("CEO: " + cesar.getName() + " - " + cesar.getCategory());
    }
}
