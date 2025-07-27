public class Empleado {
    private String Nombre;
    private Integer Horario;
    private Double Salario;

    public Empleado(Integer Horario, String Nombre, Double Salario) {
        this.Horario = Horario;
        this.Nombre = Nombre;
        this.Salario = Salario;
    }
public void trabajar() {
    
        System.out.println("El empleado " + Nombre + " está trabajando.");
    }
    @Override
    public String toString() {
        return "Empleado [Nombre=" + Nombre + ", Horario=" + Horario + ", Salario=" + Salario + ", getNombre()="
                + getNombre() + ", getHorario()=" + getHorario() + ", getSalario()=" + getSalario() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getHorario() {
        return Horario;
    }

    public void setHorario(Integer horario) {
        Horario = horario;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

}