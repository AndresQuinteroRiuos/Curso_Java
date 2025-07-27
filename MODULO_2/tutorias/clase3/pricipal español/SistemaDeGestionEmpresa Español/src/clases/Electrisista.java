

public class Electrisista extends Empleado{
    private String CertificadoElectrico;
public Electrisista(Integer Horario, String Nombre, Double Salario, String CertificadoElectrico) {
        super(Horario, Nombre, Salario);
        this.CertificadoElectrico = CertificadoElectrico;
    }
public String getCertificadoElectrico() {
    return CertificadoElectrico;
}
@Override
public String toString() {
    return "Electrisista [CertificadoElectrico=" + CertificadoElectrico + ", getNombre()=" + getNombre()
            + ", getCertificadoElectrico()=" + getCertificadoElectrico() + ", getHorario()=" + getHorario()
            + ", getSalario()=" + getSalario() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
            + ", toString()=" + super.toString() + "]";
}
public void setCertificadoElectrico(String certificadoElectrico) {
   this. CertificadoElectrico = certificadoElectrico;
}


}


