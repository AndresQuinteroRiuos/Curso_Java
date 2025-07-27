

public class Enterprise {
    private String Name;
    private Employee[] Employees;
    private Client[] Clients;


    public Enterprise(String name) {
       this. Name = name;
       this.Employees = new Employee[50]; // Initial capacity
       this.Clients = new Client[100]; // Initial capacity
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public Employee[] getEmployees() {
        return Employees;
    }

    public Client[] getClients() {
        return Clients;
    }
    
    public void addEmployee(int index, Employee employee) {
        Employees[index] = employee;
        
    }
    
    public void addClient(int index, Client client) {
    Clients[index] = client;
    }
    }

