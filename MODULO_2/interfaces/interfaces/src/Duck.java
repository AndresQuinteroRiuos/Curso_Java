public class Duck extends Animal implements canfly, canRun, canSwim {
    private String color;

    public Duck(String name, Integer age, String genre, String color) {
        super(name, age, genre);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
public void fly() {
        System.out.printf("%s esta bolando%n", getName());
    }
    @Override
     public void swim() {
        System.out.printf("%s esta nadando%n", getName());
    }
    @Override
    public void run() {
        System.out.printf("%s esta corriendo%n", getName());
    }

     public void roar() {
        System.out.printf("%s esta rugiendo%n", getName());
    }
       public boolean CanPutEggs() {
        return getGenre().equals("hembra");
    }
    @Override
    public void hunt() {
        System.out.printf("%s esta cazando en el agua agacha la cabeza y se come un pez%n", getName());
    }

    @Override
    public void makeNoise() {
       System.out.printf ("%s hace cuak cuak%n", getName());
    }

}
