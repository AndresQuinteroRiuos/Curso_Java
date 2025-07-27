package model;

import Service.Interface.Reportable;
import java.util.Date;

public class Administrator extends Employee implements Reportable {
    private String accessLevel;

    public Administrator(String workerId, String name, double salary, Date schedule, String accessLevel) {
        super(workerId, name, salary, schedule);
        this.accessLevel = accessLevel;
    }

    @Override
    public void Trabajar() {
        System.out.println(getName() + ", El administrador está gestionando recursos");
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    @Override
    public void GenerarReport() {
        System.out.println(getName() + ", Generando reporte de administrador. Nivel de acceso: " + accessLevel);
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}