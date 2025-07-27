package model;

import Service.Interface.Reportable;
import java.util.Date;

public class Electrician extends Employee implements Reportable {
    private String electricalCertification;

    public Electrician(String electricalCertification, String workerId, String name, double salary, Date schedule) {
        super(workerId, name, salary, schedule);
        this.electricalCertification = electricalCertification;
    }

    @Override
    public void GenerarReport() {
        System.out.println(getName() + ", generando reporte. Certificación: " + electricalCertification + "!!");
    }

    @Override
    public void Trabajar() {
        System.out.println("El electricista " + getName() + " está trabajando. Certificación: " + electricalCertification + "!!");
    }

    public String getElectricalCertification() {
        return electricalCertification;
    }
}
