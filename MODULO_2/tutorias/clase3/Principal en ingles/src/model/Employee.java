package model;

import java.util.Date;

public abstract  class Employee { //empleado
private  String WorkerId;
private  String Name;
private double salary;
private  Date schedule;
public Employee(String workerId, String name, double salary, Date schedule) {
    this.WorkerId = workerId;
    this. Name = name;
    this.salary = salary;
    this.schedule = schedule;






   // showInformation; //mostrar informacion



}
public String getWorkerId() {
    return WorkerId;
}
public void setWorkerId(String workerId) {
    WorkerId = workerId;
}
public String getName() {
    return Name;
}
public void setName(String name) {
    Name = name;
}
public double getSalary() {
    return salary;
}
public void setSalary(double salary) {
    this.salary = salary;
}
public Date getSchedule() {
    return schedule;
}
@Override
public String toString() {
    return "Id" + WorkerId + "|Nombre=" + Name + "|Salario=" + salary + "|Horario=" + schedule ;
}
public void setSchedule(Date schedule) {
    this.schedule = schedule;
}
abstract void Trabajar (); //metodo abstractotrabajar

}