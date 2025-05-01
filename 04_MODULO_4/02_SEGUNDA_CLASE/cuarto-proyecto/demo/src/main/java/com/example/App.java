package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private double salario;

    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    // Métodos setter para modificar los valores de los atributos.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

public class App {
    public static void main(String[] args) {
        // A partir de esta List<Empleado> cargala con 10 elementos; utilizar el List.of
        List<Empleado> empleados = List.of(
                new Empleado("Juan", "Pérez", 25, 2500.0),
                new Empleado("María", "García", 30, 3000.0),
                new Empleado("Carlos", "López", 35, 3500.0),
                new Empleado("Ana", "Martínez", 28, 2800.0),
                new Empleado("Pedro", "Sánchez", 32, 3200.0),
                new Empleado("Laura", "Rodríguez", 27, 2700.0),
                new Empleado("Miguel", "Fernández", 40, 4000.0),
                new Empleado("Sofía", "Gómez", 29, 2900.0),
                new Empleado("David", "Díaz", 33, 3300.0),
                new Empleado("Elena", "Ruiz", 31, 3100.0));

        List<Empleado> mayores_30 = empleados.stream()
                .filter(e -> e.getEdad() > 30)
                .collect(Collectors.toList());

        double promedio = empleados.stream()
                .mapToDouble(Empleado::getApellido)
                .average()
                .orElse(0.0);

        List<Empleado> ordenados = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getApellido))
                .collect(Collectors.toList());

        ordenados.stream()
                .limit(5)
                .forEach(e -> System.out.println(e.getApellido() + " , " + e.getNombre()););
    }
}
