public class Eagle extends Animal implements canfly {
    private String type;

    public Eagle(String name, Integer age, String genre, String type) {
        super(name, age, genre);
        this.type = type;
    }

   public String getType() {
        return type;
    }

    @Override
    public void fly() {
        System.out.printf("%s esta bolando%n", getName());
    }

    public void Squeal () {
        System.out.printf("%s esta chillando%n", getName());
    }
    public boolean CanPutEggs() {
        return getGenre().equals("hembra");
    }
public void squeal  () {
        System.out.printf("%s esta chillandoo%n", getName());
}
    

    @Override
    public void hunt() {
        System.out.printf("%s maria esta cazando encuentra el objetivo y se lanza por el%n", getName());
        
    }
    @Override
    public void makeNoise() {
        squeal();
    }
}
