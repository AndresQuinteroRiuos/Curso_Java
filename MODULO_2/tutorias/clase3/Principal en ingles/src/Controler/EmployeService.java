package Controler;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeService {
    private List<Employee> employee;

    // Constructor
    public EmployeService() {
        employee = new ArrayList<>();
    }

    // CREATE: Agregar un empleado
    public List<Employee> addEmployee(Employee newEmployee) {
        employee.add(newEmployee);
        return employee;
    }

    // READ: Obtener la lista de empleados
    public List<Employee> getEmployee() {
        return employee;
    }

    // UPDATE: Actualizar un empleado por ID
    public Employee updateEmployeeId(Employee updatedEmployee, String id) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getWorkerId().equals(id)) {
                employee.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null; // No se encontró el empleado
    }

    // DELETE: Eliminar un empleado por ID
    public Employee deleteEmployeeId(String id) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getWorkerId().equals(id)) {
                Employee removed = employee.remove(i);
                return removed;
            }
        }
        return null; // No se encontró el empleado
    }
}
     
    