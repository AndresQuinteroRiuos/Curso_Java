public class fish extends Animal implements canSwim {
    private String color;
    private boolean formSea;
    
    public fish(String name, Integer age, String genre, String color, boolean formSea) {
        super(name, age, genre);
        this.color = color;
        this.formSea = formSea;
    }

    public String getColor() {
        return color;
    }

    public boolean isFormSea() {
        return formSea;
    }
    @Override
    public void swim() {
        System.out.printf("%s esta nadando%n", getName());
    }
    public boolean CanPutEggs() {
        return getGenre().equalsIgnoreCase("hembra");
    }
    @Override
    public void hunt() {
        System.out.printf("%s esta nadando, se cruza con el objetivo y se lo come%n", getName());
    }

    @Override
    public void makeNoise() {
       System.out.printf( " %s glob glob%n", getName());
    }
}