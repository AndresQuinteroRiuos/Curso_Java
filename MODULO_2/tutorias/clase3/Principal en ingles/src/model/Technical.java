package model;

import Service.Interface.Reportable;
import java.util.Date;

public class Technical extends Employee implements Reportable {
    private String specialistArea;

    public Technical(String specialistArea, String workerId, String name, double salary, Date schedule) {
        super(workerId, name, salary, schedule);
        this.specialistArea = specialistArea;
    }

    public String getSpecialistArea() {
        return specialistArea;
    }

    @Override
    public void Trabajar() {
        System.out.println(getName() + ", el técnico está trabajando en: " + specialistArea + "!!");
    }

    @Override
    public void GenerarReport() {
        System.out.println(getName() + ", generando reporte técnico de: " + specialistArea + "!!");
    }
}