public class Directive extends Employee {

    private final int MAX_EMPLOYEES = 50;
    private String category;
    private Employee[] employees;

    public Directive(String name, int age, Double salary, String category) {
        super(name, age, salary);
        this.category = category;
        this.employees = new Employee[MAX_EMPLOYEES];
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Employee[] getEmployees() {
        return employees;
    }

    public void addEmployee(int index, Employee employee) {
        if (index >= 0 && index < MAX_EMPLOYEES) {
            employees[index] = employee;
        } else {
            System.err.println("Índice fuera de rango. No se puede agregar el empleado.");
        }
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("Directivo: nombre: %s, edad: %d, salario: $%,.2f, categoria: %s%n", 
                          getName(), getAge(), getSalary(), getCategory());
    }
}
