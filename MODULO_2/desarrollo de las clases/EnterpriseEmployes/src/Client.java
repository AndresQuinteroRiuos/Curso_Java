public class Client extends Person {

    private String ContactPhone;

    public Client(String name, int age, String contactPhone) {
        super(name, age);
        this.ContactPhone = contactPhone;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.ContactPhone = contactPhone;
    }

    @Override
    public void mostrarDatos() {
        System.out.printf("Cliente: nombre: %s, edad: %d, telefono de contacto: %s%n", 
                          getName(), getAge(), getContactPhone());
    }
    
    
    
    

}
