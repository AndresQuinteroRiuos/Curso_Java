public class Employee extends Person {
   private  Double Salary;
   private Directive Manager;



   public Employee(String name, int age, Double Salary) {
    super(name, age);
    this.Salary = Salary;
   }

   public Double getSalary() {
    return Salary;
   }

   public void setSalary(Double Salary) {
    this.Salary = Salary;
   }

    public Directive getManager() {
        return Manager;
    }

 

    public void setManager(Directive Manager) {
        this.Manager = Manager;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("Empleado: nombre : %s, edad: %d, salario: %.2f%n", 
                          getName(), getAge(), getSalary());


        
    }

}
