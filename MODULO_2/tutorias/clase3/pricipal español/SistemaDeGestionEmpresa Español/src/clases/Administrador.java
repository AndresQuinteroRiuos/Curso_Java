// Clase Administrador que hereda de Empleado
public class Administrador extends Empleado {
    // Área de acceso del administrador
    private String areaDeAcceso;

    // Constructor
    public Administrador(Integer horario, String nombre, Double salario, String areaDeAcceso) {
        super(horario, nombre, salario);
        this.areaDeAcceso = areaDeAcceso;
    }

    // Getter
    public String getAreaDeAcceso() {
        return areaDeAcceso;
    }

    // Setter
    public void setAreaDeAcceso(String areaDeAcceso) {
        this.areaDeAcceso = areaDeAcceso;
    }

    // Implementación del método trabajar
    @Override
    public void trabajar() {
        System.out.println("El administrador " + getNombre() + " está supervisando recursos.");
    }

    // Método toString mejorado
    @Override
    public String toString() {
        return "Administrador {" +
                "nombre='" + getNombre() + '\'' +
                ", horario=" + getHorario() +
                ", salario=" + getSalario() +
                ", areaDeAcceso='" + areaDeAcceso + '\'' +
                '}';
    }
}
